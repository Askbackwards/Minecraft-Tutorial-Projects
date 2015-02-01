package com.bedrockminer.tutorial.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
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
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
	    if (!world.isRemote && world.getTileEntity(x,y,z) != null && world.getTileEntity(x,y,z) instanceof TileTutorial) {
	        String message = ((TileTutorial)world.getTileEntity(x,y,z)).getValue();
	        MinecraftServer.getServer().getConfigurationManager().sendChatMsg(new ChatComponentText(message));
	        ((TileTutorial)world.getTileEntity(x,y,z)).setValue(player.getCommandSenderName() + "@" + MinecraftServer.getSystemTimeMillis());
	    }
	    return true;
	}
}
