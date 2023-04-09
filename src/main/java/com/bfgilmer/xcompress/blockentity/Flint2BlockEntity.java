package com.bfgilmer.xcompress.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class Flint2BlockEntity extends BaseFlintBlockEntity {

	public Flint2BlockEntity(BlockPos worldPosition, BlockState blockState) {
		   super(XcompressBlockEntities.FLINT_2.get(), worldPosition, blockState, 2);
	}

}
