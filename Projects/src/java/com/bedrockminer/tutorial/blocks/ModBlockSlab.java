package com.bedrockminer.tutorial.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ModBlockSlab extends BlockSlab {

	public ModBlockSlab(String unlocalizedName, boolean isDoubleSlab, Material material) {
		super(isDoubleSlab, material);
		this.setBlockName(unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	//This method returns the unlocalized name based on the metadata. It is canned by ItemSlab
	public String func_150002_b(int metadata) {
		switch (metadata & 7) {
		case 0: return this.getUnlocalizedName() + "_iron";
		case 1: return this.getUnlocalizedName() + "_gold";
		default: return this.getUnlocalizedName();
		}
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		switch (meta & 7) {
		case 0: return Blocks.iron_block.getIcon(side, 0);
		case 1: return Blocks.gold_block.getIcon(side, 0);
		default: return Blocks.stone.getIcon(0, 0);
		}
	}

	@Override
	public void registerBlockIcons(IIconRegister reg) { }

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		if (!this.field_150004_a) { //Only if this is a single slab
			list.add(new ItemStack(item, 1, 0));
			list.add(new ItemStack(item, 1, 1));
		}
	}

	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		Block block = world.getBlock(x, y, z);

		if (block == null) return null;
		if (block == ModBlocks.double_slab) block = ModBlocks.slab;

		int meta = world.getBlockMetadata(x, y, z) & 7;
		return new ItemStack(block, 1, meta);
	}
}
