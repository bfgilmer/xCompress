package com.bfgilmer.xcompress.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class SnowBlock extends BaseBlock {
	public SnowBlock(Integer number) {
		super(Material.SNOW,
				p -> p.sound(SoundType.SNOW).strength(0.2f * number.floatValue(), (0.2f * number.floatValue()))
						.friction(0.6f * number.floatValue()).speedFactor(number.floatValue()));
	}
}
