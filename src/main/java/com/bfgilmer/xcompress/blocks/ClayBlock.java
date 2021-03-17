package com.bfgilmer.xcompress.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class ClayBlock extends BaseBlock {

	public ClayBlock(Integer number) {
		super(Properties.of(Material.CLAY).sound(SoundType.STONE).strength(0.6f * number.floatValue(),
				0.6f * (float) Math.pow(2.0f, number.doubleValue())));
	}

}
