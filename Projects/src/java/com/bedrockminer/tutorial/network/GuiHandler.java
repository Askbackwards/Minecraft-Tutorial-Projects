package com.bedrockminer.tutorial.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.bedrockminer.tutorial.blocks.TileTutorial;
import com.bedrockminer.tutorial.client.gui.GuiTileTutorial;
import com.bedrockminer.tutorial.gui.container.ContainerTileTutorial;

import cpw.mods.fml.common.network.IGuiHandler;


public class GuiHandler implements IGuiHandler {

	public static final int TILE_TUTORIAL_ID = 0;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == TILE_TUTORIAL_ID)
			return new ContainerTileTutorial((TileTutorial)world.getTileEntity(x, y, z), player.inventory);
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == TILE_TUTORIAL_ID)
			return new GuiTileTutorial((TileTutorial)world.getTileEntity(x, y, z), player.inventory);
		return null;
	}

}
