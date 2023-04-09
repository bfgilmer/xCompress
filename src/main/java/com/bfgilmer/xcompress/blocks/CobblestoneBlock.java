package com.bfgilmer.xcompress.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class CobblestoneBlock extends Block {

	public CobblestoneBlock(Integer number) {
		super(Properties.of(Material.STONE).sound(SoundType.STONE).strength(2.0f * number.floatValue(),
				500.0F * (float) Math.pow(2.0f, number.doubleValue())));
	}
}