package com.bedrockminer.tutorial.blocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileTutorial extends TileEntity implements IInventory {

	private ItemStack[] inventory = new ItemStack[this.getSizeInventory()];

	private String customInventoryName;

	@Override
	public int getSizeInventory() {
		return 9;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		if (slot < this.getSizeInventory() && slot >= 0)
			return this.inventory[slot];
		return null;
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		if (this.getStackInSlot(slot) != null) {
			ItemStack stack;
			if (this.getStackInSlot(slot).stackSize <= amount) {
				stack = this.getStackInSlot(slot);
				this.setInventorySlotContents(slot, null);
				this.markDirty();
				return stack;
			} else {
				stack = this.getStackInSlot(slot).splitStack(amount);
				if (this.getStackInSlot(slot).stackSize == 0)
					this.setInventorySlotContents(slot, null);
				this.markDirty();
				return stack;
			}
		} else {
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		ItemStack stack = this.getStackInSlot(slot);
		this.setInventorySlotContents(slot, null);
		return stack;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		if (slot < this.getSizeInventory() && slot >= 0)
			this.inventory[slot] = stack;
	}

	@Override
	public String getInventoryName() {
		return this.hasCustomInventoryName() ? this.customInventoryName : "inventory.tiletutorial.title";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return this.customInventoryName != null;
	}

	public void setCustomInventoryName(String name) {
		this.customInventoryName = name;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return true;
	}

	@Override
	public void openInventory() { }

	@Override
	public void closeInventory() { }

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack) {
		return true;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);

		NBTTagList itemList = nbt.getTagList("Items", 10);
        this.inventory = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < itemList.tagCount(); ++i)
        {
            NBTTagCompound stackTag = itemList.getCompoundTagAt(i);
            int j = stackTag.getByte("Slot") & 255;

            if (j >= 0 && j < this.getSizeInventory())
            {
                this.setInventorySlotContents(j, ItemStack.loadItemStackFromNBT(stackTag));
            }
        }

        if (nbt.hasKey("CustomName", 8))
        {
        	System.out.println("Loaded");
            this.customInventoryName = nbt.getString("CustomName");
        }
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		NBTTagList itemList = new NBTTagList();

        for (int i = 0; i < this.getSizeInventory(); ++i)
        {
            if (this.getStackInSlot(i) != null)
            {
                NBTTagCompound stackTag = new NBTTagCompound();
                stackTag.setByte("Slot", (byte)i);
                this.getStackInSlot(i).writeToNBT(stackTag);
                itemList.appendTag(stackTag);
            }
        }

        nbt.setTag("Items", itemList);

        if (this.hasCustomInventoryName())
        {
        	System.out.println("Saved");
            nbt.setString("CustomName", this.customInventoryName);
        }
	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, this.blockMetadata, nbt);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		this.xCoord = pkt.func_148856_c();
		this.yCoord = pkt.func_148855_d();
		this.zCoord = pkt.func_148854_e();
		this.blockMetadata = pkt.func_148853_f();
		this.readFromNBT(pkt.func_148857_g());
	}
}
