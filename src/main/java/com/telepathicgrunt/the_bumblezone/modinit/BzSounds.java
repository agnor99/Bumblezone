package com.telepathicgrunt.the_bumblezone.modinit;

import com.telepathicgrunt.the_bumblezone.Bumblezone;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.SoundType;

public class BzSounds {
    public final static SoundEvent ANGERED_BEES = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "angered_bees"));
    public final static SoundEvent BEEHEMOTH_HURT = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "entity.the_bumblezone.beehemoth.hurt"));
    public final static SoundEvent BEEHEMOTH_DEATH = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "entity.the_bumblezone.beehemoth.death"));
    public final static SoundEvent BEEHEMOTH_LOOP = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "entity.the_bumblezone.beehemoth.loop"));
    public final static SoundEvent BEE_ESSENCE_CONSUMED = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "item.the_bumblezone.essence_of_the_bees.consumed"));
    public final static SoundEvent BEE_ESSENCE_CONSUMING = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "item.the_bumblezone.essence_of_the_bees.consuming"));
    public final static SoundEvent MUSIC_DISC_HONEY_BEE_RAT_FACED_BOY = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "music_disc.honey_bee_rat_faced_boy"));
    public final static SoundEvent MUSIC_DISC_FLIGHT_OF_THE_BUMBLEBEE_RIMSKY_KORSAKOV = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "music_disc.flight_of_the_bumblebee_rimsky_korsakov"));
    public final static SoundEvent MUSIC_DISC_LA_BEE_DA_LOCA = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "music_disc.la_bee_da_loca"));
    public final static SoundEvent MUSIC_DISC_BEE_LAXING_WITH_THE_HOM_BEES = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "music_disc.bee_laxing_with_the_hom_bees"));
    public static final SoundEvent STINGER_SPEAR_HIT = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "entity.the_bumblezone.stinger_spear.hit"));
    public static final SoundEvent STINGER_SPEAR_HIT_GROUND = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "entity.the_bumblezone.stinger_spear.hit_ground"));
    public static final SoundEvent STINGER_SPEAR_RETURN = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "entity.the_bumblezone.stinger_spear.return"));
    public static final SoundEvent STINGER_SPEAR_THROW = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "entity.the_bumblezone.stinger_spear.throw"));
    public static final SoundEvent BEE_STINGER_HIT = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "entity.the_bumblezone.bee_stinger.hit"));
    public static final SoundEvent HONEY_CRYSTAL_SHARD_HIT = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "entity.the_bumblezone.honey_crystal_shard.hit"));
    public static final SoundEvent HONEY_CRYSTAL_SHARD_SHATTER = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "entity.the_bumblezone.honey_crystal_shard.shatter"));
    public static final SoundEvent BUMBLE_BEE_CHESTPLATE_FLYING = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "item.the_bumblezone.bumble_bee_chestplate.fly"));
    public static final SoundEvent WASHING_RESIDUES = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "block.the_bumblezone.washing_honey_residues"));
    public static final SoundEvent CRYSTALLINE_FLOWER_USE = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "block.the_bumblezone.crystalline_flower.use"));
    public static final SoundEvent SUPER_CANDLE_WICK_LIT = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "block.the_bumblezone.super_candle_wick.lit"));
    public static final SoundEvent HONEY_SLIME_ATTACK = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "entity.the_bumblezone.honey_slime.attack"));
    public static final SoundEvent HONEY_SLIME_HURT = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "entity.the_bumblezone.honey_slime.hurt"));
    public static final SoundEvent HONEY_SLIME_DEATH = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "entity.the_bumblezone.honey_slime.death"));
    public static final SoundEvent HONEY_SLIME_SQUISH = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "entity.the_bumblezone.honey_slime.squish"));
    public static final SoundEvent HONEY_SLIME_JUMP = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "entity.the_bumblezone.honey_slime.jump"));
    public static final SoundEvent HONEY_SLIME_HURT_SMALL = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "entity.the_bumblezone.honey_slime.hurt_small"));
    public static final SoundEvent HONEY_SLIME_DEATH_SMALL = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "entity.the_bumblezone.honey_slime.death_small"));
    public static final SoundEvent HONEY_SLIME_SQUISH_SMALL = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "entity.the_bumblezone.honey_slime.squish_small"));
    public static final SoundEvent HONEY_SLIME_JUMP_SMALL = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "entity.the_bumblezone.honey_slime.jump_small"));
    public static final SoundEvent POLLEN_PUFF_THROW = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "entity.the_bumblezone.pollen_puff.throw"));
    public static final SoundEvent SUGAR_WATER_DRINK = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "item.the_bumblezone.sugar_water_bottle.drink"));
    public final static SoundEvent BEE_CANNON_FIRES = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "item.the_bumblezone.bee_cannon.fire"));
    public static final SoundEvent CRYSTAL_CANNON_FIRES = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "item.the_bumblezone.crystal_cannon.fire"));
    public static final SoundEvent ROYAL_JELLY_DRINK = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "item.the_bumblezone.royal_jelly_bottle.drink"));
    public static final SoundEvent ROYAL_JELLY_BLOCK_SLIDE = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "block.the_bumblezone.royal_jelly_block.slide"));
    public static final SoundEvent HONEY_COMPASS_BLOCK_LOCK = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "item.the_bumblezone.honey_compass.block_lock"));
    public static final SoundEvent HONEY_COMPASS_STRUCTURE_LOCK = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "item.the_bumblezone.honey_compass.structure_lock"));
    public static final SoundEvent BEE_QUEEN_HURT = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "entity.the_bumblezone.bee_queen.hurt"));
    public static final SoundEvent BEE_QUEEN_DEATH = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "entity.the_bumblezone.bee_queen.death"));
    public static final SoundEvent BEE_QUEEN_LOOP = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "entity.the_bumblezone.bee_queen.loop"));
    public static final SoundEvent BEE_QUEEN_HAPPY = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "entity.the_bumblezone.bee_queen.happy"));
    public static final SoundEvent HONEY_CRYSTAL_BLOCK_STEP = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "block.the_bumblezone.honey_crystal_block.step"));
    public static final SoundEvent HONEY_CRYSTAL_BLOCK_PLACE = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "block.the_bumblezone.honey_crystal_block.place"));
    public static final SoundEvent HONEY_CRYSTAL_BLOCK_HIT = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "block.the_bumblezone.honey_crystal_block.hit"));
    public static final SoundEvent HONEY_CRYSTAL_BLOCK_FALL = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "block.the_bumblezone.honey_crystal_block.fall"));
    public static final SoundEvent HONEY_CRYSTAL_BLOCK_CHIME = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "block.the_bumblezone.honey_crystal_block.chime"));
    public static final SoundEvent HONEY_CRYSTAL_BLOCK_BREAK = SoundEvent.createVariableRangeEvent(new ResourceLocation(Bumblezone.MODID, "block.the_bumblezone.honey_crystal_block.break"));

    public static final SoundType HONEY_CRYSTALS_TYPE = new SoundType(
            1.0F,
            1.0F,
            BzSounds.HONEY_CRYSTAL_BLOCK_BREAK,
            BzSounds.HONEY_CRYSTAL_BLOCK_STEP,
            BzSounds.HONEY_CRYSTAL_BLOCK_PLACE,
            BzSounds.HONEY_CRYSTAL_BLOCK_HIT,
            BzSounds.HONEY_CRYSTAL_BLOCK_FALL
    );

    public static void registerSounds() {
        Registry.register(BuiltInRegistries.SOUND_EVENT, ANGERED_BEES.getLocation(), ANGERED_BEES);
        Registry.register(BuiltInRegistries.SOUND_EVENT, BEEHEMOTH_HURT.getLocation(), BEEHEMOTH_HURT);
        Registry.register(BuiltInRegistries.SOUND_EVENT, BEEHEMOTH_DEATH.getLocation(), BEEHEMOTH_DEATH);
        Registry.register(BuiltInRegistries.SOUND_EVENT, BEEHEMOTH_LOOP.getLocation(), BEEHEMOTH_LOOP);
        Registry.register(BuiltInRegistries.SOUND_EVENT, BEE_ESSENCE_CONSUMED.getLocation(), BEE_ESSENCE_CONSUMED);
        Registry.register(BuiltInRegistries.SOUND_EVENT, BEE_ESSENCE_CONSUMING.getLocation(), BEE_ESSENCE_CONSUMING);
        Registry.register(BuiltInRegistries.SOUND_EVENT, BUMBLE_BEE_CHESTPLATE_FLYING.getLocation(), BUMBLE_BEE_CHESTPLATE_FLYING);
        Registry.register(BuiltInRegistries.SOUND_EVENT, MUSIC_DISC_HONEY_BEE_RAT_FACED_BOY.getLocation(), MUSIC_DISC_HONEY_BEE_RAT_FACED_BOY);
        Registry.register(BuiltInRegistries.SOUND_EVENT, MUSIC_DISC_FLIGHT_OF_THE_BUMBLEBEE_RIMSKY_KORSAKOV.getLocation(), MUSIC_DISC_FLIGHT_OF_THE_BUMBLEBEE_RIMSKY_KORSAKOV);
        Registry.register(BuiltInRegistries.SOUND_EVENT, MUSIC_DISC_LA_BEE_DA_LOCA.getLocation(), MUSIC_DISC_LA_BEE_DA_LOCA);
        Registry.register(BuiltInRegistries.SOUND_EVENT, MUSIC_DISC_BEE_LAXING_WITH_THE_HOM_BEES.getLocation(), MUSIC_DISC_BEE_LAXING_WITH_THE_HOM_BEES);
        Registry.register(BuiltInRegistries.SOUND_EVENT, STINGER_SPEAR_HIT.getLocation(), STINGER_SPEAR_HIT);
        Registry.register(BuiltInRegistries.SOUND_EVENT, STINGER_SPEAR_HIT_GROUND.getLocation(), STINGER_SPEAR_HIT_GROUND);
        Registry.register(BuiltInRegistries.SOUND_EVENT, STINGER_SPEAR_RETURN.getLocation(), STINGER_SPEAR_RETURN);
        Registry.register(BuiltInRegistries.SOUND_EVENT, STINGER_SPEAR_THROW.getLocation(), STINGER_SPEAR_THROW);
        Registry.register(BuiltInRegistries.SOUND_EVENT, BEE_STINGER_HIT.getLocation(), BEE_STINGER_HIT);
        Registry.register(BuiltInRegistries.SOUND_EVENT, HONEY_CRYSTAL_SHARD_HIT.getLocation(), HONEY_CRYSTAL_SHARD_HIT);
        Registry.register(BuiltInRegistries.SOUND_EVENT, HONEY_CRYSTAL_SHARD_SHATTER.getLocation(), HONEY_CRYSTAL_SHARD_SHATTER);
        Registry.register(BuiltInRegistries.SOUND_EVENT, WASHING_RESIDUES.getLocation(), WASHING_RESIDUES);
        Registry.register(BuiltInRegistries.SOUND_EVENT, CRYSTALLINE_FLOWER_USE.getLocation(), CRYSTALLINE_FLOWER_USE);
        Registry.register(BuiltInRegistries.SOUND_EVENT, SUPER_CANDLE_WICK_LIT.getLocation(), SUPER_CANDLE_WICK_LIT);
        Registry.register(BuiltInRegistries.SOUND_EVENT, HONEY_SLIME_ATTACK.getLocation(), HONEY_SLIME_ATTACK);
        Registry.register(BuiltInRegistries.SOUND_EVENT, HONEY_SLIME_HURT.getLocation(), HONEY_SLIME_HURT);
        Registry.register(BuiltInRegistries.SOUND_EVENT, HONEY_SLIME_DEATH.getLocation(), HONEY_SLIME_DEATH);
        Registry.register(BuiltInRegistries.SOUND_EVENT, HONEY_SLIME_SQUISH.getLocation(), HONEY_SLIME_SQUISH);
        Registry.register(BuiltInRegistries.SOUND_EVENT, HONEY_SLIME_JUMP.getLocation(), HONEY_SLIME_JUMP);
        Registry.register(BuiltInRegistries.SOUND_EVENT, HONEY_SLIME_HURT_SMALL.getLocation(), HONEY_SLIME_HURT_SMALL);
        Registry.register(BuiltInRegistries.SOUND_EVENT, HONEY_SLIME_DEATH_SMALL.getLocation(), HONEY_SLIME_DEATH_SMALL);
        Registry.register(BuiltInRegistries.SOUND_EVENT, HONEY_SLIME_SQUISH_SMALL.getLocation(), HONEY_SLIME_SQUISH_SMALL);
        Registry.register(BuiltInRegistries.SOUND_EVENT, HONEY_SLIME_JUMP_SMALL.getLocation(), HONEY_SLIME_JUMP_SMALL);
        Registry.register(BuiltInRegistries.SOUND_EVENT, POLLEN_PUFF_THROW.getLocation(), POLLEN_PUFF_THROW);
        Registry.register(BuiltInRegistries.SOUND_EVENT, SUGAR_WATER_DRINK.getLocation(), SUGAR_WATER_DRINK);
        Registry.register(BuiltInRegistries.SOUND_EVENT, BEE_CANNON_FIRES.getLocation(), BEE_CANNON_FIRES);
        Registry.register(BuiltInRegistries.SOUND_EVENT, CRYSTAL_CANNON_FIRES.getLocation(), CRYSTAL_CANNON_FIRES);
        Registry.register(BuiltInRegistries.SOUND_EVENT, ROYAL_JELLY_DRINK.getLocation(), ROYAL_JELLY_DRINK);
        Registry.register(BuiltInRegistries.SOUND_EVENT, ROYAL_JELLY_BLOCK_SLIDE.getLocation(), ROYAL_JELLY_BLOCK_SLIDE);
        Registry.register(BuiltInRegistries.SOUND_EVENT, HONEY_COMPASS_BLOCK_LOCK.getLocation(), HONEY_COMPASS_BLOCK_LOCK);
        Registry.register(BuiltInRegistries.SOUND_EVENT, HONEY_COMPASS_STRUCTURE_LOCK.getLocation(), HONEY_COMPASS_STRUCTURE_LOCK);
        Registry.register(BuiltInRegistries.SOUND_EVENT, BEE_QUEEN_HURT.getLocation(), BEE_QUEEN_HURT);
        Registry.register(BuiltInRegistries.SOUND_EVENT, BEE_QUEEN_DEATH.getLocation(), BEE_QUEEN_DEATH);
        Registry.register(BuiltInRegistries.SOUND_EVENT, BEE_QUEEN_LOOP.getLocation(), BEE_QUEEN_LOOP);
        Registry.register(BuiltInRegistries.SOUND_EVENT, BEE_QUEEN_HAPPY.getLocation(), BEE_QUEEN_HAPPY);
        Registry.register(BuiltInRegistries.SOUND_EVENT, HONEY_CRYSTAL_BLOCK_STEP.getLocation(), HONEY_CRYSTAL_BLOCK_STEP);
        Registry.register(BuiltInRegistries.SOUND_EVENT, HONEY_CRYSTAL_BLOCK_PLACE.getLocation(), HONEY_CRYSTAL_BLOCK_PLACE);
        Registry.register(BuiltInRegistries.SOUND_EVENT, HONEY_CRYSTAL_BLOCK_HIT.getLocation(), HONEY_CRYSTAL_BLOCK_HIT);
        Registry.register(BuiltInRegistries.SOUND_EVENT, HONEY_CRYSTAL_BLOCK_FALL.getLocation(), HONEY_CRYSTAL_BLOCK_FALL);
        Registry.register(BuiltInRegistries.SOUND_EVENT, HONEY_CRYSTAL_BLOCK_CHIME.getLocation(), HONEY_CRYSTAL_BLOCK_CHIME);
        Registry.register(BuiltInRegistries.SOUND_EVENT, HONEY_CRYSTAL_BLOCK_BREAK.getLocation(), HONEY_CRYSTAL_BLOCK_BREAK);
    }
}
