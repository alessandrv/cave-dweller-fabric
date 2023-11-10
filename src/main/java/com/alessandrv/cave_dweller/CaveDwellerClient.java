package com.alessandrv.cave_dweller;

import com.alessandrv.cave_dweller.client.CaveDwellerRenderer;
import com.alessandrv.cave_dweller.registry.ModEntityTypes;
import com.alessandrv.cave_dweller.registry.ModSounds;
import com.alessandrv.cave_dweller.util.Utils;
import com.mojang.logging.LogUtils;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.lighting.LayerLightEventListener;
import org.slf4j.Logger;
import software.bernie.geckolib.GeckoLib;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Environment(EnvType.CLIENT)

public class CaveDwellerClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntityTypes.CAVEDWELLER, CaveDwellerRenderer::new);


    }
}
