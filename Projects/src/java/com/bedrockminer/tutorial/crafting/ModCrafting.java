package com.bedrockminer.tutorial.crafting;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.bedrockminer.tutorial.blocks.ModBlocks;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModCrafting {

	public static void init() {
		GameRegistry.addRecipe(new ItemStack(ModBlocks.slab, 3, 0), 	"###",				'#', Items.iron_ingot);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.slab, 3, 1), 	"###",				'#', Items.gold_ingot);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.iron_stairs, 5), "#  ","## ","###",	'#', Items.iron_ingot);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.gold_stairs, 5), "#  ","## ","###",	'#', Items.gold_ingot);
	}
}
