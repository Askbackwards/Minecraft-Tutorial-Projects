package com.bedrockminer.tutorial.blocks;

import net.minecraft.tileentity.TileEntity;

public class TileTutorial extends TileEntity {

	private String myString;

	public String getValue() {
	    return this.myString;
	}

	public void setValue(String value) {
	    this.myString = value;
	}
}
