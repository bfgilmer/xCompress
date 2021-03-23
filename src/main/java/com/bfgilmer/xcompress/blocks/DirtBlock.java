package com.bfgilmer.xcompress.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.IPlantable;

public class DirtBlock extends BaseBlock {

	public DirtBlock(Integer number) {
		super(Material.DIRT, SoundType.GRASS, 0.5f * number.floatValue(),
				0.5f * (float) Math.pow(2.0f, number.doubleValue()));
	}

	@Override
	public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing,
			IPlantable plantable) {
		 return net.minecraftforge.common.PlantType.PLAINS.equals(plantable.getPlantType(world, pos.relative(facing)));
	}
}
