package com.alessandrv.cave_dweller.registry;

import com.alessandrv.cave_dweller.CaveDweller;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;


public class ModSounds {

    public static final SoundEvent CAVENOISE_1 = SoundEvent.createVariableRangeEvent(new ResourceLocation(CaveDweller.MODID, "cavenoise_1"));
    public static final SoundEvent CAVENOISE_2 = SoundEvent.createVariableRangeEvent(new ResourceLocation(CaveDweller.MODID, "cavenoise_2"));
    public static final SoundEvent CAVENOISE_3 = SoundEvent.createVariableRangeEvent(new ResourceLocation(CaveDweller.MODID, "cavenoise_3"));
    public static final SoundEvent CAVENOISE_4 = SoundEvent.createVariableRangeEvent(new ResourceLocation(CaveDweller.MODID, "cavenoise_4"));
    public static final SoundEvent CHASE_STEP_1 = SoundEvent.createVariableRangeEvent(new ResourceLocation(CaveDweller.MODID, "chase_step_1"));
    public static final SoundEvent CHASE_STEP_2 = SoundEvent.createVariableRangeEvent(new ResourceLocation(CaveDweller.MODID, "chase_step_2"));
    public static final SoundEvent CHASE_STEP_3 = SoundEvent.createVariableRangeEvent(new ResourceLocation(CaveDweller.MODID, "chase_step_3"));
    public static final SoundEvent CHASE_STEP_4 = SoundEvent.createVariableRangeEvent(new ResourceLocation(CaveDweller.MODID, "chase_step_4"));
    public static final SoundEvent CHASE_1 = SoundEvent.createVariableRangeEvent(new ResourceLocation(CaveDweller.MODID, "chase_1"));
    public static final SoundEvent CHASE_2 = SoundEvent.createVariableRangeEvent(new ResourceLocation(CaveDweller.MODID, "chase_2"));
    public static final SoundEvent CHASE_3 = SoundEvent.createVariableRangeEvent(new ResourceLocation(CaveDweller.MODID, "chase_3"));
    public static final SoundEvent CHASE_4 = SoundEvent.createVariableRangeEvent(new ResourceLocation(CaveDweller.MODID, "chase_4"));
    public static final SoundEvent FLEE_1 = SoundEvent.createVariableRangeEvent(new ResourceLocation(CaveDweller.MODID, "flee_1"));
    public static final SoundEvent FLEE_2 = SoundEvent.createVariableRangeEvent(new ResourceLocation(CaveDweller.MODID, "flee_2"));
    public static final SoundEvent SPOTTED = SoundEvent.createVariableRangeEvent(new ResourceLocation(CaveDweller.MODID, "spotted"));
    public static final SoundEvent DISAPPEAR = SoundEvent.createVariableRangeEvent(new ResourceLocation(CaveDweller.MODID, "disappear"));
    public static final SoundEvent DWELLER_HURT_1 = SoundEvent.createVariableRangeEvent(new ResourceLocation(CaveDweller.MODID, "dweller_hurt_1"));
    public static final SoundEvent DWELLER_HURT_2 = SoundEvent.createVariableRangeEvent(new ResourceLocation(CaveDweller.MODID, "dweller_hurt_2"));
    public static final SoundEvent DWELLER_HURT_3 = SoundEvent.createVariableRangeEvent(new ResourceLocation(CaveDweller.MODID, "dweller_hurt_3"));
    public static final SoundEvent DWELLER_HURT_4 = SoundEvent.createVariableRangeEvent(new ResourceLocation(CaveDweller.MODID, "dweller_hurt_4"));
    public static final SoundEvent DWELLER_DEATH = SoundEvent.createVariableRangeEvent(new ResourceLocation(CaveDweller.MODID, "dweller_death"));



    public static void register() {
        Registry.register(BuiltInRegistries.SOUND_EVENT, CAVENOISE_1.getLocation(), CAVENOISE_1);
        Registry.register(BuiltInRegistries.SOUND_EVENT, CAVENOISE_2.getLocation(), CAVENOISE_2);
        Registry.register(BuiltInRegistries.SOUND_EVENT, CAVENOISE_3.getLocation(), CAVENOISE_3);
        Registry.register(BuiltInRegistries.SOUND_EVENT, CAVENOISE_4.getLocation(), CAVENOISE_4);
        Registry.register(BuiltInRegistries.SOUND_EVENT, CHASE_STEP_1.getLocation(), CHASE_STEP_1);
        Registry.register(BuiltInRegistries.SOUND_EVENT, CHASE_STEP_2.getLocation(), CHASE_STEP_2);
        Registry.register(BuiltInRegistries.SOUND_EVENT, CHASE_STEP_3.getLocation(), CHASE_STEP_3);
        Registry.register(BuiltInRegistries.SOUND_EVENT, CHASE_STEP_4.getLocation(), CHASE_STEP_4);
        Registry.register(BuiltInRegistries.SOUND_EVENT, CHASE_1.getLocation(), CHASE_1);
        Registry.register(BuiltInRegistries.SOUND_EVENT, CHASE_2.getLocation(), CHASE_2);
        Registry.register(BuiltInRegistries.SOUND_EVENT, CHASE_3.getLocation(), CHASE_3);
        Registry.register(BuiltInRegistries.SOUND_EVENT, CHASE_4.getLocation(), CHASE_4);
        Registry.register(BuiltInRegistries.SOUND_EVENT, FLEE_1.getLocation(), FLEE_1);
        Registry.register(BuiltInRegistries.SOUND_EVENT, FLEE_2.getLocation(), FLEE_2);
        Registry.register(BuiltInRegistries.SOUND_EVENT, SPOTTED.getLocation(), SPOTTED);
        Registry.register(BuiltInRegistries.SOUND_EVENT, DISAPPEAR.getLocation(), DISAPPEAR);
        Registry.register(BuiltInRegistries.SOUND_EVENT, DWELLER_HURT_1.getLocation(), DWELLER_HURT_1);
        Registry.register(BuiltInRegistries.SOUND_EVENT, DWELLER_HURT_2.getLocation(), DWELLER_HURT_2);
        Registry.register(BuiltInRegistries.SOUND_EVENT, DWELLER_HURT_3.getLocation(), DWELLER_HURT_3);
        Registry.register(BuiltInRegistries.SOUND_EVENT, DWELLER_HURT_4.getLocation(), DWELLER_HURT_4);
        Registry.register(BuiltInRegistries.SOUND_EVENT, DWELLER_DEATH.getLocation(), DWELLER_DEATH);
    }

}
