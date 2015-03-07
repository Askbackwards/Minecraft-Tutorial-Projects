package com.bedrockminer.tutorial.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.bedrockminer.tutorial.Main;
import com.bedrockminer.tutorial.blocks.TileTutorial;
import com.bedrockminer.tutorial.gui.container.ContainerTileTutorial;


public class GuiTileTutorial extends GuiContainer {

	private final InventoryPlayer inventoryPlayer;
	private final IInventory inventory;

	public GuiTileTutorial(TileTutorial te, InventoryPlayer inventoryPlayer) {
		super(new ContainerTileTutorial(te, inventoryPlayer));

		this.inventory = te;
		this.inventoryPlayer = inventoryPlayer;

		//this.xSize = 176;
		//this.ySize = 166;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_)
    {
        this.fontRendererObj.drawString(I18n.format(this.inventory.getInventoryName()), 8, 6, 0xffffff);
        this.fontRendererObj.drawString(I18n.format(this.inventoryPlayer.getInventoryName()), 8, this.ySize - 94, 0xffffff);
    }

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTick, int mouseX, int mouseY) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(new ResourceLocation(Main.MODID + ":textures/gui/te.png"));
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	}

}
