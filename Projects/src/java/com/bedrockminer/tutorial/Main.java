package com.bedrockminer.tutorial;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION)
public class Main {
	public static final String MODID = "tutorial";
	public static final String NAME = "Minecraft Tutorial Mod";
	public static final String VERSION = "1.0.0";

	@Instance
	public static Main instance = new Main();

	@SidedProxy(clientSide = "com.bedrockminer.tutorial.ClientProxy", serverSide = "com.bedrockminer.tutorial.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void onPreInit(FMLPreInitializationEvent e) {
		proxy.preInit(e);
	}

	@EventHandler
	public void onInit(FMLInitializationEvent e) {
		proxy.init(e);
	}

	@EventHandler
	public void onPostInit(FMLPostInitializationEvent e) {
		proxy.postInit(e);
	}
}
