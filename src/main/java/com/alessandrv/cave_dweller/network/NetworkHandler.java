package com.alessandrv.cave_dweller.network;

public class NetworkHandler {
    private static final String PROTOCOL_VERSION = "2";
    //public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(new ResourceLocation(CaveDweller.MODID, "main"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);

    public static void register() {
    //    CHANNEL.registerMessage(0, CaveSound.class, CaveSound::encode, CaveSound::decode, CaveSound::handle);
    }
}
