package com.bfgilmer.xcompress.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class NetherrackBlock extends BaseBlock {
	public NetherrackBlock(Integer number) {
		super(Material.STONE,
				p -> p.sound(SoundType.STONE).strength(0.4f * number.floatValue(), 0.4f * number.floatValue()));
	}
}
