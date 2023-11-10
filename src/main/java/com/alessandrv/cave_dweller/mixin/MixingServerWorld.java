package com.alessandrv.cave_dweller.mixin;

import com.alessandrv.cave_dweller.CaveDweller;
import com.alessandrv.cave_dweller.entities.CaveDwellerEntity;
import com.alessandrv.cave_dweller.network.CaveSound;
import com.alessandrv.cave_dweller.network.NetworkHandler;
import com.alessandrv.cave_dweller.registry.ModEntityTypes;
import com.alessandrv.cave_dweller.registry.ModSounds;
import com.alessandrv.cave_dweller.util.Utils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.lighting.LayerLightEventListener;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BooleanSupplier;

@Mixin(MinecraftServer.class)
public abstract class MixingServerWorld {

    private static boolean doReload;

    private final List<Player> spelunkers = new ArrayList<>();
    private final Random random = new Random();

    private int calmTimer;
    private int noiseTimer;
    @Shadow public abstract @Nullable ServerLevel getLevel(ResourceKey<Level> resourceKey);

    /** Currently needed to prevent the mob from sliding to its previously set target location */
    @Inject(method = "tickServer", at = @At("TAIL"), cancellable = true)
    public void tickServer(BooleanSupplier booleanSupplier, CallbackInfo ci) {


        if (doReload) {
            spelunkers.clear();
            resetNoiseTimer();
            resetCalmTimer();
            doReload = false;
        }

        ServerLevel overworld = this.getLevel(Level.OVERWORLD);

        if (overworld == null) {
            return;
        }

        Iterable<Entity> entities = overworld.getAllEntities();
        AtomicBoolean dwellerExists = new AtomicBoolean(false);

        entities.forEach(entity -> {
            if (entity instanceof CaveDwellerEntity) {
                dwellerExists.set(true);
                resetCalmTimer();
            }else{
                dwellerExists.set(false);

            }
        });
        --noiseTimer;
        if (noiseTimer <= 0 && (dwellerExists.get() || calmTimer <= Utils.secondsToTicks(CaveDweller.CONFIG.RESET_CALM_MAX()) / 2)) {
            overworld.getPlayers(this::playCaveSoundToSpelunkers);
            resetNoiseTimer();
        }

        boolean canSpawn = calmTimer <= 0;


        if (calmTimer != 0) {
            --calmTimer;
        }
         // FIXME :: Maybe don't let this go too high (if server is running empty e.g.)
        if (canSpawn && !dwellerExists.get()) {

            if (random.nextDouble() <= CaveDweller.CONFIG.SPAWN_CHANCE_PER_TICK()) {
                spelunkers.clear();
                overworld.getPlayers(this::listSpelunkers);

                if (!spelunkers.isEmpty()) {
                    Player victim = spelunkers.get(random.nextInt(spelunkers.size()));
                    overworld.getPlayers(this::playCaveSoundToSpelunkers);

                    CaveDwellerEntity caveDweller = new CaveDwellerEntity(ModEntityTypes.CAVEDWELLER, overworld);
                    caveDweller.setPos(caveDweller.generatePos(victim));
                    caveDweller.setInvisible(true);
                    overworld.addFreshEntity(caveDweller);

                    resetCalmTimer();
                    resetNoiseTimer();
                }
            }
        }




    }


    public boolean playCaveSoundToSpelunkers(final ServerPlayer player) {
        if (!isPlayerSpelunker(player)) {
            return false;
        }

        // TODO :: Play the same sound to all players?
        SoundEvent soundLocation = switch (random.nextInt(4)) {
            case 1 -> ModSounds.CAVENOISE_2;
            case 2 -> ModSounds.CAVENOISE_3;
            case 3 -> ModSounds.CAVENOISE_4;
            default -> ModSounds.CAVENOISE_1;
        };
       // player.playSound(soundLocation, 1.0F, 1.0F);
        player.playSound(SoundEvents.VILLAGER_NO, 1.0F, 1.0F);
        player.level().playSound(null, player, soundLocation, SoundSource.HOSTILE, 3.0f, 1.0f);
        //playEntitySound(ModSounds.SPOTTED, 3.0F, 1.0F);
        return true;
    }



    private boolean listSpelunkers(final ServerPlayer player) {
        if (isPlayerSpelunker(player)) {
            spelunkers.add(player);
        }

        return true;
    }


    public boolean isPlayerSpelunker(final ServerPlayer player) {
        if (!Utils.isValidPlayer(player)) {
            return false;
        }

        // Height level check
        if (player.position().y > CaveDweller.CONFIG.SPAWN_HEIGHT()) {
            return false;
        }

        Level serverLevel = player.level();

        // Sky light level check
        // Referenced from DaylightDetectorBlock
        int skyLightLevel = serverLevel.getBrightness(LightLayer.SKY, player.blockPosition()) - serverLevel.getSkyDarken();
        float sunAngle = serverLevel.getSunAngle(1.0F);
        if (skyLightLevel > 0) {
            float f1 = sunAngle < (float) Math.PI ? 0.0F : ((float) Math.PI * 2F);
            sunAngle += (f1 - sunAngle) * 0.2F;
            skyLightLevel = Math.round((float) skyLightLevel * Mth.cos(sunAngle));
        }

        skyLightLevel = Mth.clamp(skyLightLevel, 0, 15);

        if (skyLightLevel > CaveDweller.CONFIG.SKY_LIGHT_LEVEL()) {
            return false;
        }

        // Block light level check
        LayerLightEventListener blockLighting = serverLevel.getLightEngine().getLayerListener(LightLayer.BLOCK);

        if (blockLighting.getLightValue(player.blockPosition()) > CaveDweller.CONFIG.BLOCK_LIGHT_LEVEL()) {
            return false;
        }

        return (CaveDweller.CONFIG.ALLOW_SURFACE_SPAWN() || !serverLevel.canSeeSky(player.blockPosition()));
    }

    private void resetCalmTimer() {

        if (random.nextDouble() <= CaveDweller.CONFIG.RESET_CALM_COOLDOWN_CHANCE()) {
            calmTimer = Utils.secondsToTicks(CaveDweller.CONFIG.RESET_CALM_COOLDOWN());
        } else {
            int min = CaveDweller.CONFIG.RESET_CALM_MIN();
            int max = CaveDweller.CONFIG.RESET_CALM_MAX();

            if (max < min) {
                int temp = min;
                min = max;
                max = temp;

            }

            calmTimer = random.nextInt(Utils.secondsToTicks(min), Utils.secondsToTicks(max + 1));
        }
    }

    private void resetNoiseTimer() {
        int min = CaveDweller.CONFIG.RESET_NOISE_MIN();
        int max = CaveDweller.CONFIG.RESET_NOISE_MAX();

        if (max < min) {
            int temp = min;
            min = max;
            max = temp;

        }

        noiseTimer = random.nextInt(Utils.secondsToTicks(min), Utils.secondsToTicks(max + 1));
    }

}
