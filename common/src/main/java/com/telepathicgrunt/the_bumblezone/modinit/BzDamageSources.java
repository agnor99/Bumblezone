package com.telepathicgrunt.the_bumblezone.modinit;

import com.telepathicgrunt.the_bumblezone.Bumblezone;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;

public class BzDamageSources {
    public static final ResourceKey<DamageType> CRYSTALLINE_FLOWER_TYPE = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(Bumblezone.MODID, "crystalline_flower"));
}
