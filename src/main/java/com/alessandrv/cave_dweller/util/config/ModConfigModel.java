package com.alessandrv.cave_dweller.util.config;


import com.alessandrv.cave_dweller.CaveDweller;
import io.wispforest.owo.config.annotation.RangeConstraint;
import io.wispforest.owo.config.annotation.RestartRequired;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Modmenu;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
@Modmenu(modId = "cave_dweller")
@Config(name = "cave-dweller-config", wrapperName = "CaveDwellerConfiguration")
public class ModConfigModel{
    public boolean GIVE_DARKNESS = true;
    public boolean DISAPPEAR = true;
    public double SPAWN_CHANCE_PER_TICK = 0.005;
    public int RESET_CALM_MIN = 300;
    public int RESET_CALM_MAX = 600;
    public int RESET_CALM_COOLDOWN = 1200;
    public double RESET_CALM_COOLDOWN_CHANCE = 0.4;

    public int RESET_NOISE_MIN = 240;
    public int RESET_NOISE_MAX = 360;
    @RangeConstraint(min =-64, max = 256)
    public int SPAWN_HEIGHT = 40;
    public boolean ALLOW_SURFACE_SPAWN = false;
    public int SKY_LIGHT_LEVEL = 8;
    public int BLOCK_LIGHT_LEVEL = 15;
    @RestartRequired
    public int SPOTTING_RANGE = 60;
    public int TIME_UNTIL_LEAVE = 300;
    public int TIME_UNTIL_LEAVE_CHASE = 30;
    public boolean CAN_CLIMB = true;
    public boolean ALLOW_RIDING = false;
    public boolean TARGET_INVISIBLE = true;
    @RestartRequired
    public double MAX_HEALTH = 60.0;
    @RestartRequired
    public double ATTACK_DAMAGE = 6.0;
    @RestartRequired
    public double ATTACK_SPEED = 0.35;
    @RestartRequired
    public double MOVEMENT_SPEED = 0.5;
}
