package com.alessandrv.cave_dweller.entities.goals;

import com.alessandrv.cave_dweller.entities.CaveDwellerEntity;
import com.alessandrv.cave_dweller.util.Utils;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

public class CaveDwellerBreakInvisGoal extends Goal {
    private final CaveDwellerEntity caveDweller;

    public CaveDwellerBreakInvisGoal(final CaveDwellerEntity caveDweller) {
        this.caveDweller = caveDweller;
    }

    @Override
    public boolean canUse() {
        return caveDweller.isInvisible() && !caveDweller.targetIsLookingAtMe;
    }

    @Override
    public void start() {
        super.start();
        caveDweller.setInvisible(false);
    }
}