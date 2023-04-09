package com.bfgilmer.xcompress.blocks;

import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class GravelBlock extends FallingBlock {
	public GravelBlock(Integer number) {
		super(Properties.of(Material.SAND).sound(SoundType.STONE).strength(0.6f * number.floatValue(),
				0.6f * (float) Math.pow(2.0f, number.doubleValue())));
	}

}
