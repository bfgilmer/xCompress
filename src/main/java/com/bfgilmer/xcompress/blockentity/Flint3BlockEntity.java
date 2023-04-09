package com.bfgilmer.xcompress.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class Flint3BlockEntity extends BaseFlintBlockEntity {

	public Flint3BlockEntity(BlockPos worldPosition, BlockState blockState) {
		   super(XcompressBlockEntities.FLINT_3.get(), worldPosition, blockState, 3);
	}

}
