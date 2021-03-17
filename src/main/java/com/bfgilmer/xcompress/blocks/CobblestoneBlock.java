package com.bfgilmer.xcompress.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class CobblestoneBlock extends BaseBlock {

	public CobblestoneBlock(Integer number) {
		super(Properties.of(Material.STONE).sound(SoundType.STONE).strength(2.0f * number.floatValue(),
				(float) Math.pow(6.0f, number.doubleValue())));
	}
}
