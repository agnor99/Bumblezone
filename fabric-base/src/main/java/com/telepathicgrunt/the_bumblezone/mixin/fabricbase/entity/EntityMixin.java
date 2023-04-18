package com.telepathicgrunt.the_bumblezone.mixin.fabricbase.entity;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.telepathicgrunt.the_bumblezone.events.entity.EntityTravelingToDimensionEvent;
import com.telepathicgrunt.the_bumblezone.modinit.BzTags;
import com.telepathicgrunt.the_bumblezone.platform.BzEntityHooks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Set;

@Mixin(Entity.class)
public abstract class EntityMixin implements BzEntityHooks {

    @Unique
    private FluidState bz$eyeFluidState = Fluids.EMPTY.defaultFluidState();

    @Shadow public abstract boolean isEyeInFluid(TagKey<Fluid> tagKey);

    @Shadow public abstract double getEyeY();

    @Shadow public abstract double getX();

    @Shadow public abstract double getZ();

    @Shadow public Level level;

    @Shadow @Final private Set<TagKey<Fluid>> fluidOnEyes;

    @Shadow public abstract boolean updateFluidHeightAndDoFluidPushing(TagKey<Fluid> tagKey, double d);

    @Shadow public float fallDistance;

    @Shadow protected boolean wasTouchingWater;

    @Shadow public abstract void clearFire();

    @Inject(
            method = "changeDimension",
            at = @At("HEAD"),
            cancellable = true
    )
    private void bumblezone$onChangeDimension(ServerLevel serverLevel, CallbackInfoReturnable<Entity> cir) {
        if (EntityTravelingToDimensionEvent.EVENT.invoke(new EntityTravelingToDimensionEvent(serverLevel.dimension(), (Entity)(Object)this))) {
            cir.setReturnValue(null);
        }
    }

    // let honey fluid push entity
    @Inject(method = "updateInWaterStateAndDoWaterCurrentPushing()V",
            at = @At(value = "TAIL"))
    private void bumblezone$fluidPushing(CallbackInfo ci) {
        if (this.updateFluidHeightAndDoFluidPushing(BzTags.SPECIAL_HONEY_LIKE, 0.014D)) {
            this.fallDistance = 0.0F;
            this.wasTouchingWater = true;
            this.clearFire();
        }
    }

    // make sure we set that we are in fluid
    @WrapOperation(method = "updateFluidOnEyes()V",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/Entity;isEyeInFluid(Lnet/minecraft/tags/TagKey;)Z"))
    private boolean bumblezone$markEyesInFluid1(Entity entity, TagKey<Fluid> tagKey, Operation<Boolean> original) {
        if(this.isEyeInFluid(BzTags.SPECIAL_HONEY_LIKE)) {
            return true;
        }
        return original.call(entity, tagKey);
    }

    @Inject(method = "updateFluidOnEyes()V",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/world/level/Level;getFluidState(Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/material/FluidState;"),
            cancellable = true)
    private void bumblezone$markEyesInFluid2(CallbackInfo ci) {
        double eyeHeight = this.getEyeY() - 0.11111111F;
        BlockPos blockPos = BlockPos.containing(this.getX(), eyeHeight, this.getZ());
        FluidState fluidState = this.level.getFluidState(blockPos);
        if (fluidState.is(BzTags.SPECIAL_HONEY_LIKE)) {
            double fluidHeight = (float)blockPos.getY() + fluidState.getHeight(this.level, blockPos);
            if (fluidHeight > eyeHeight) {
                fluidState.getTags().forEach(this.fluidOnEyes::add);
                this.bz$eyeFluidState = fluidState;
                ci.cancel();
            }
        }
    }

    // let honey fluid be swimmable
    @WrapOperation(method = "updateSwimming()V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/material/FluidState;is(Lnet/minecraft/tags/TagKey;)Z"))
    private boolean bumblezone$setSwimming(FluidState fluidState, TagKey<Fluid> tagKey, Operation<Boolean> original) {
        // check if we are swimming in honey fluid
        if(fluidState.is(BzTags.SPECIAL_HONEY_LIKE)) {
            return true;
        }
        return original.call(fluidState, tagKey);
    }

    @Inject(method = "updateFluidOnEyes", at = @At("HEAD"))
    public void bumblezone$onSetFluidInEyes(CallbackInfo ci) {
        bz$eyeFluidState = Fluids.EMPTY.defaultFluidState();
    }

    @Inject(
            method = "updateFluidOnEyes",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/material/FluidState;getTags()Ljava/util/stream/Stream;"),
            locals = LocalCapture.CAPTURE_FAILHARD
    )
    public void bumblezone$onSetFluidInEyes_fabric(CallbackInfo ci, double d, Entity entity, BlockPos blockPos, FluidState fluidState, double e) {
        bz$eyeFluidState = fluidState;
    }

    @Override
    public FluidState bz$getFluidOnEyes() {
        return bz$eyeFluidState;
    }
}
