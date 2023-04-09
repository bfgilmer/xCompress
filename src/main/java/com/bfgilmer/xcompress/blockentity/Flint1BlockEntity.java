package com.bfgilmer.xcompress.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class Flint1BlockEntity extends BaseFlintBlockEntity {

	public Flint1BlockEntity(BlockPos worldPosition, BlockState blockState) {
	   super(XcompressBlockEntities.FLINT_1.get(), worldPosition, blockState, 1);
	}

}
