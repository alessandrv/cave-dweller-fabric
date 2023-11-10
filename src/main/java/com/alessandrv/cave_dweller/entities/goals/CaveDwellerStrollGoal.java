package com.alessandrv.cave_dweller.entities.goals;

import com.alessandrv.cave_dweller.entities.CaveDwellerEntity;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;

public class CaveDwellerStrollGoal extends WaterAvoidingRandomStrollGoal {
    public CaveDwellerStrollGoal(final CaveDwellerEntity mob, double speedModifier) {
        super(mob, speedModifier);
    }

    @Override
    public boolean canUse() {
        return ((CaveDwellerEntity) this.mob).currentRoll == Roll.STROLL && super.canUse();
    }

    @Override
    public boolean canContinueToUse() {
        return ((CaveDwellerEntity) this.mob).currentRoll == Roll.STROLL && super.canContinueToUse();
    }
}
