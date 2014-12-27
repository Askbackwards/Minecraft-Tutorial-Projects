package com.bedrockminer.tutorial.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.creativetab.CreativeTabs;

public class ModBlockStairs extends BlockStairs {

	public ModBlockStairs(String unlocalizedName, Block baseBlock, int metaOfBaseBlock) {
		super(baseBlock, metaOfBaseBlock);
		this.setBlockName(unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}

	public ModBlockStairs(String unlocalizedName, Block baseBlock) {
		this(unlocalizedName, baseBlock, 0);
	}
}
