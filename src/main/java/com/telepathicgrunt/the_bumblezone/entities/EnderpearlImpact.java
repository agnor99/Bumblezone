package com.telepathicgrunt.the_bumblezone.entities;

import net.minecraft.world.entity.projectile.ThrownEnderpearl;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.EntityTeleportEvent;
import net.minecraftforge.eventbus.api.Event;

public class EnderpearlImpact {

    public static void onPearlHit(EntityTeleportEvent.EnderPearl event) {
        if(EntityTeleportationHookup.runEnderpearlImpact(new Vec3(event.getTargetX(), event.getTargetY(), event.getTargetZ()), event.getEntity(), event.getPearlEntity())) {
            event.setResult(Event.Result.DENY);
            return;
        }

        if (event.getHitResult() != null && event.getHitResult() instanceof EntityHitResult entityHitResult) {
            ThrownEnderpearl thrownEnderpearl = event.getPearlEntity();
            if (EntityTeleportationHookup.runEntityHitCheck(entityHitResult, thrownEnderpearl)) {
                event.setResult(Event.Result.DENY);
            }
        }
    }
}