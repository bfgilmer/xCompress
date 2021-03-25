package com.bfgilmer.xcompress.blocks;

import net.minecraft.block.FallingBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class GravelBlock extends FallingBlock {
	public GravelBlock(Integer number) {
		super(Properties.of(Material.SAND).sound(SoundType.STONE).strength(0.6f * number.floatValue(),
				0.6f * (float) Math.pow(2.0f, number.doubleValue())));
	}

}
