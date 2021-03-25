package com.bfgilmer.xcompress.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class IronBlock extends BaseBlock {
    Block r=Blocks.REDSTONE_BLOCK;
	public IronBlock(Integer number) {
		super(Properties.of(Material.METAL).sound(SoundType.METAL).strength(6.0f * number.floatValue(),
				0.6f * (float) Math.pow(2.0f, number.doubleValue())).isRedstoneConductor(IronBlock::control));
	}
	
	  private static boolean control(BlockState block, IBlockReader p_235436_1_, BlockPos p_235436_2_) {
		      return false;
		   }

	  public boolean isSignalSource(BlockState p_149744_1_) {
	      return true;
	   }

	   public int getSignal(BlockState p_180656_1_, IBlockReader p_180656_2_, BlockPos p_180656_3_, Direction p_180656_4_) {
	      return 15;
	   }
}
