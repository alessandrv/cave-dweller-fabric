package com.alessandrv.cave_dweller.registry;

import com.alessandrv.cave_dweller.CaveDweller;
import com.alessandrv.cave_dweller.entities.CaveDwellerEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;


public class ModEntityTypes {
   // public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, CaveDweller.MODID);
    //public static final RegistryObject<EntityType<CaveDwellerEntity>> CAVE_DWELLER = ENTITY_TYPES.register(
    //        "cave_dweller",
    //        () -> EntityType.Builder.of(CaveDwellerEntity::new, MobCategory.MONSTER)
     //               .sized(0.4F, 3.0F)
   //                 .build(new ResourceLocation(CaveDweller.MODID, "cave_dweller").toString())
    //);

    //public static void register(final IEventBus eventBus) {
     //   ENTITY_TYPES.register(eventBus);
   // }

    public static final EntityType<? extends CaveDwellerEntity> CAVEDWELLER = register(new ResourceLocation(CaveDweller.MODID, "cave_dweller").getPath(), CaveDwellerEntity::new, 0.4f, 2.9f);

    private static <T extends Entity> EntityType<T> register(String name, EntityType.EntityFactory<T> factory, float width, float height) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, new ResourceLocation(CaveDweller.MODID, name), FabricEntityTypeBuilder.create(MobCategory.MONSTER, factory).dimensions(EntityDimensions.fixed(width, height)).trackedUpdateRate(1).build());
    }

    public static void register() {
        FabricDefaultAttributeRegistry.register(CAVEDWELLER, CaveDwellerEntity.getAttributeBuilder());
    }

}
