package com.bedrockminer.tutorial.blocks;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {

	public static void init() {
		GameRegistry.registerBlock(new BlockTileEntity("te"), "te");

		GameRegistry.registerTileEntity(TileTutorial.class, "tutorial_tile");
	}
}
