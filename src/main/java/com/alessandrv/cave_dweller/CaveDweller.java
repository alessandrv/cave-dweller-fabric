package com.alessandrv.cave_dweller;

import com.alessandrv.cave_dweller.registry.ModItems;
import com.alessandrv.cave_dweller.util.config.CaveDwellerConfiguration;
import com.alessandrv.cave_dweller.util.config.ModConfigModel;
import com.mojang.logging.LogUtils;
import com.alessandrv.cave_dweller.registry.ModEntityTypes;
import com.alessandrv.cave_dweller.registry.ModSounds;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import software.bernie.geckolib.GeckoLib;

public class CaveDweller implements ModInitializer {
    public static final String MODID = "cave_dweller";
    public static final Logger LOG = LogUtils.getLogger();
    private static ModConfigModel config;

    public static ModConfigModel getConfig() {
        return config;
    }
    private boolean myBooleanOption;
    public static final CaveDwellerConfiguration CONFIG = CaveDwellerConfiguration.createAndLoad();

    @Override
    public void onInitialize() {



        new ModItems();

        GeckoLib.initialize();
        ModSounds.register();
        ModEntityTypes.register();

    }
}
