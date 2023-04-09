package com.bfgilmer.xcompress.blocks;

import net.minecraft.world.level.block.SoulSandBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class SoulsandBlock extends SoulSandBlock {
	public SoulsandBlock(Integer number) {
		super(Properties.of(Material.SAND).sound(SoundType.SAND).strength(0.5f).speedFactor((float) (0.5/number.floatValue())));
	}

}