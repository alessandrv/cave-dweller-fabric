package com.alessandrv.cave_dweller.client;

import com.alessandrv.cave_dweller.network.CaveSound;


/** Proxy class to avoid loading client code on the server-side */
public class HandleCaveSound {
    public static void handle(final CaveSound packet) {
     //   IForgeRegistry<SoundEvent> soundEvents = ForgeRegistries.SOUND_EVENTS;

    //    if (soundEvents == null) {
    //        CaveDweller.LOG.error("Forge Sound registry was null while handling packet");
   //         return;
     //   }

   //     SoundEvent soundEvent = soundEvents.getValue(packet.soundResource);

    //    if (soundEvent == null) {
   //         CaveDweller.LOG.error("Sound Event [" + packet.soundResource + "] was null while handling packet");
     //       return;
    //    }

      //  Minecraft.getInstance().getSoundManager().play(new SimpleSoundInstance(soundEvent, SoundSource.AMBIENT, 2.0F, 1.0F, RandomSource.create(), packet.playerPosition));
    }
}
