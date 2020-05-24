package net.telepathicgrunt.bumblezone.blocks;

import net.fabricmc.fabric.api.block.FabricMaterialBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.fluid.BaseFluid;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.telepathicgrunt.bumblezone.Bumblezone;
import net.telepathicgrunt.bumblezone.fluids.SugarWaterFluid;


public class BzBlocks
{
	public static Material RESIDUE = new FabricMaterialBuilder(MaterialColor.ORANGE_TERRACOTTA)
																.lightPassesThrough()
																.destroyedByPiston()
																.allowsMovement()
																.replaceable()
																.notSolid()
																.build();

    public static final Block POROUS_HONEYCOMB = new PorousHoneycomb();
    public static final Block FILLED_POROUS_HONEYCOMB = new FilledPorousHoneycomb();
	public static final Block DEAD_HONEYCOMB_LARVA = new EmptyHoneycombBrood();
	public static final Block HONEYCOMB_LARVA = new HoneycombBrood();
	public static final Block SUGAR_INFUSED_STONE = new SugarInfusedStone();
	public static final Block SUGAR_INFUSED_COBBLESTONE = new SugarInfusedCobblestone();
	public static final Block HONEY_CRYSTAL = new HoneyCrystal();
	public static final Block STICKY_HONEY_RESIDUE = new StickyHoneyResidue();
	public static final Block STICKY_HONEY_REDSTONE = new StickyHoneyRedstone();


	//fluid mess
	public static final Identifier FLUID_STILL = new Identifier(Bumblezone.MODID+":block/sugar_water_still");
	public static final Identifier FLUID_FLOWING = new Identifier(Bumblezone.MODID+":block/sugar_water_flow");
	public static final Identifier FLUID_OVERLAY = new Identifier(Bumblezone.MODID+":block/sugar_water_overlay");

	public static final BaseFluid SUGAR_WATER_FLUID = new SugarWaterFluid.Source();
	public static final BaseFluid SUGAR_WATER_FLUID_FLOWING = new SugarWaterFluid.Flowing();
	public static final Block SUGAR_WATER_BLOCK = new SugarWaterBlock(SUGAR_WATER_FLUID);

	/**
	 * registers the Blocks so they now exist in the registry
	 */
	public static void registerBlocks()
	{
		Registry.register(Registry.BLOCK, new Identifier(Bumblezone.MODID, "porous_honeycomb_block"), POROUS_HONEYCOMB);
		Registry.register(Registry.BLOCK, new Identifier(Bumblezone.MODID, "filled_porous_honeycomb_block"), FILLED_POROUS_HONEYCOMB);
		Registry.register(Registry.BLOCK, new Identifier(Bumblezone.MODID, "dead_honeycomb_larva_block"), DEAD_HONEYCOMB_LARVA);
		Registry.register(Registry.BLOCK, new Identifier(Bumblezone.MODID, "honeycomb_larva_block"), HONEYCOMB_LARVA);
		Registry.register(Registry.BLOCK, new Identifier(Bumblezone.MODID, "sugar_infused_stone"), SUGAR_INFUSED_STONE);
		Registry.register(Registry.BLOCK, new Identifier(Bumblezone.MODID, "sugar_infused_cobblestone"), SUGAR_INFUSED_COBBLESTONE);
		Registry.register(Registry.BLOCK, new Identifier(Bumblezone.MODID, "honey_crystal"), HONEY_CRYSTAL);
		Registry.register(Registry.BLOCK, new Identifier(Bumblezone.MODID, "sticky_honey_residue"), STICKY_HONEY_RESIDUE);
		Registry.register(Registry.BLOCK, new Identifier(Bumblezone.MODID, "sticky_honey_redstone"), STICKY_HONEY_REDSTONE);
		Registry.register(Registry.FLUID, new Identifier(Bumblezone.MODID, "sugar_water_flowing"), SUGAR_WATER_FLUID);
		Registry.register(Registry.FLUID, new Identifier(Bumblezone.MODID, "sugar_water_flowing"), SUGAR_WATER_FLUID_FLOWING);
		Registry.register(Registry.BLOCK, new Identifier(Bumblezone.MODID, "sugar_water_block"), SUGAR_WATER_BLOCK);
	}

}