package com.bfgilmer.xcompress.blocks;

import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class CobblestoneBlock extends BaseBlock {

	@SuppressWarnings("deprecation")
	public CobblestoneBlock(Integer number) {
		super(Properties.of(Material.STONE).sound(SoundType.STONE).strength(2.0f * number.floatValue(),
				Blocks.STONE.getExplosionResistance() * (float) Math.pow(2.0f, number.doubleValue())));
	}
}
