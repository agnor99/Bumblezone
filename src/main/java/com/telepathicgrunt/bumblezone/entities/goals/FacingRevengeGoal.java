package com.telepathicgrunt.bumblezone.entities.goals;

import com.telepathicgrunt.bumblezone.entities.controllers.HoneySlimeMoveHelperController;
import com.telepathicgrunt.bumblezone.entities.mobs.HoneySlimeEntity;
import java.util.EnumSet;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;

public class FacingRevengeGoal extends HurtByTargetGoal {
    private final HoneySlimeEntity slime;

    public FacingRevengeGoal(HoneySlimeEntity slimeIn) {
        super(slimeIn);
        this.slime = slimeIn;
        this.setFlags(EnumSet.of(Goal.Flag.LOOK));
    }
    public boolean canContinueToUse() {
        return slime.getTarget() != null && super.canContinueToUse();
    }

    public void tick() {
        this.slime.lookAt(this.slime.getTarget(), 10.0F, 10.0F);
        ((HoneySlimeMoveHelperController) this.slime.getMoveControl()).setDirection(this.slime.getYRot(), this.slime.canDamagePlayer());
    }
}