package com.bedrockminer.tutorial;

import com.bedrockminer.tutorial.blocks.ModBlocks;
import com.bedrockminer.tutorial.crafting.ModCrafting;
import com.bedrockminer.tutorial.items.ModItems;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent e) {
		ModBlocks.init();
		ModItems.init();

		ModCrafting.init();
	}

	public void init(FMLInitializationEvent e) {

	}

	public void postInit(FMLPostInitializationEvent e) {

	}
}
