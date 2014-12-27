package com.bedrockminer.tutorial.blocks;

import com.bedrockminer.tutorial.items.ModItemBlockSlab;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;

public class ModBlocks {

	public static Block iron_stairs;
	public static Block gold_stairs;

	public static Block slab;
	public static Block double_slab;

	public static void init() {
		GameRegistry.registerBlock(iron_stairs = new ModBlockStairs("iron_stairs", Blocks.iron_block), "iron_stairs");
		GameRegistry.registerBlock(gold_stairs = new ModBlockStairs("gold_stairs", Blocks.gold_block), "gold_stairs");

		slab = new ModBlockSlab("slab", false, Material.iron);
		double_slab = new ModBlockSlab("double_slab", true, Material.iron);
		GameRegistry.registerBlock(slab, ModItemBlockSlab.class, "slab", slab, double_slab, false);
		GameRegistry.registerBlock(double_slab, ModItemBlockSlab.class, "double_slab", slab, double_slab, true);
	}
}
