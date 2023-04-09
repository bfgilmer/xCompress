package com.bfgilmer.xcompress.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class Flint4BlockEntity extends BaseFlintBlockEntity {

	public Flint4BlockEntity(BlockPos worldPosition, BlockState blockState) {
		   super(XcompressBlockEntities.FLINT_4.get(), worldPosition, blockState, 4);
	}

}
