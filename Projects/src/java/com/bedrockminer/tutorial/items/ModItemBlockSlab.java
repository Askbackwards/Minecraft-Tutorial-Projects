package com.bedrockminer.tutorial.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;

import com.bedrockminer.tutorial.blocks.ModBlockSlab;

public class ModItemBlockSlab extends ItemSlab {

	public ModItemBlockSlab(Block block, ModBlockSlab single_slab, ModBlockSlab double_slab, Boolean isDoubleSlab) {
		super(block, single_slab, double_slab, isDoubleSlab);
	}

}
