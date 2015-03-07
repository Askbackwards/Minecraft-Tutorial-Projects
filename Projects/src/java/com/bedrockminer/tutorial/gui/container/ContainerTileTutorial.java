package com.bedrockminer.tutorial.gui.container;

import com.bedrockminer.tutorial.blocks.TileTutorial;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;


public class ContainerTileTutorial extends Container {

	private TileTutorial te;

	public ContainerTileTutorial(TileTutorial te, InventoryPlayer inventoryPlayer) {
		this.te = te;

		int y, x;

		//Slots of the Tile Entity
		for (y = 0; y < 3; ++y) {
            for (x = 0; x < 3; ++x) {
                this.addSlotToContainer(new Slot(te, x + y * 3, 62 + x * 18, 17 + y * 18));
            }
        }

		//Player Inventory
        for (y = 0; y < 3; ++y) {
            for (x = 0; x < 9; ++x) {
                this.addSlotToContainer(new Slot(inventoryPlayer, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
            }
        }
        for (y = 0; y < 9; ++y) {
            this.addSlotToContainer(new Slot(inventoryPlayer, y, 8 + y * 18, 142));
        }
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return this.te.isUseableByPlayer(player);
	}
}
