package com.bedrockminer.tutorial.blocks;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileTutorial extends TileEntity {

	private String myString;

	public String getValue() {
	    return this.myString;
	}

	public void setValue(String value) {
	    this.myString = value;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		this.myString = nbt.getString("playerName");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setString("playerName", this.myString);
	}
}
