package com.alessandrv.cave_dweller.network;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;

public class CaveSound {
    public final ResourceLocation soundResource;
    public final BlockPos playerPosition;
    public final float volume, pitch;

    public CaveSound(final ResourceLocation soundResource, final BlockPos playerPosition, float volume, float pitch) {
        this.soundResource = soundResource;
        this.playerPosition = playerPosition;
        this.volume = volume;
        this.pitch = pitch;
    }

    public void encode(final FriendlyByteBuf buffer) {
        buffer.writeResourceLocation(soundResource);
        buffer.writeBlockPos(playerPosition);
        buffer.writeFloat(volume);
        buffer.writeFloat(pitch);
    }

    public static CaveSound decode(final FriendlyByteBuf buffer) {
        return new CaveSound(
                buffer.readResourceLocation(),
                buffer.readBlockPos(),
                buffer.readFloat(),
                buffer.readFloat()
        );
    }


}
