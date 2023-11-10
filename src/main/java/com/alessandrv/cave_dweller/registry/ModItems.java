package com.alessandrv.cave_dweller.registry;


import com.alessandrv.cave_dweller.CaveDweller;
import com.alessandrv.cave_dweller.entities.CaveDwellerEntity;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.*;
import software.bernie.example.registry.ItemRegistry;

import java.util.function.Supplier;

import static software.bernie.example.registry.ItemRegistry.registerItem;

public class ModItems {
    public static final SpawnEggItem CAVE_DWELLER_SPAWN_EGG = registerSpawnEggs("cave_dweller_spawn_egg", new SpawnEggItem(ModEntityTypes.CAVEDWELLER, 0x1F1F1F, 0x0D0D0D, new Item.Properties()));

    public static <I extends Item> I registerSpawnEggs(String name, I item) {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.SPAWN_EGGS).register(content -> {
            content.accept(item);
        });
        return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(CaveDweller.MODID, name), item);
    }


}
