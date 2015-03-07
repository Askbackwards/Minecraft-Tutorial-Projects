package com.bedrockminer.tutorial.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.bedrockminer.tutorial.Main;

public class BlockTileEntity extends BlockContainer {

	protected BlockTileEntity(String unlocalizedName) {
		super(Material.iron);
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName(Main.MODID + ":" + unlocalizedName);
		this.setHardness(12.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setCreativeTab(CreativeTabs.tabDecorations);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileTutorial();
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		if (!world.isRemote && world.getTileEntity(x, y, z) != null && world.getTileEntity(x, y, z) instanceof TileTutorial) {
			TileTutorial te = (TileTutorial) world.getTileEntity(x, y, z);
			for (int i = 0; i < te.getSizeInventory(); ++i) {
				ItemStack itemstack = te.getStackInSlot(i);

				if (itemstack != null) {
					EntityItem entityitem;

					for (; itemstack.stackSize > 0; world.spawnEntityInWorld(entityitem)) {
						float vX = world.rand.nextFloat() * 0.8F + 0.1F;
						float vY = world.rand.nextFloat() * 0.8F + 0.1F;
						float vZ = world.rand.nextFloat() * 0.8F + 0.1F;
						int size = world.rand.nextInt(21) + 10;

						if (size > itemstack.stackSize) {
							size = itemstack.stackSize;
						}

						itemstack.stackSize -= size;
						entityitem = new EntityItem(world, x + vX, y + vY, z + vZ, new ItemStack(itemstack.getItem(), size, itemstack.getItemDamage()));
						float motion = 0.05F;
						entityitem.motionX = (float) world.rand.nextGaussian() * motion;
						entityitem.motionY = (float) world.rand.nextGaussian() * motion + 0.2F;
						entityitem.motionZ = (float) world.rand.nextGaussian() * motion;

						if (itemstack.hasTagCompound()) {
							entityitem.getEntityItem().setTagCompound((NBTTagCompound) itemstack.getTagCompound().copy());
						}
					}
				}
			}
		}
		super.breakBlock(world, x, y, z, block, meta);
	}
}
