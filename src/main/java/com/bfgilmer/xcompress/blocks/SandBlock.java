package com.bfgilmer.xcompress.blocks;

import net.minecraft.block.FallingBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.FallingBlockEntity;

public class SandBlock extends FallingBlock {
	public SandBlock(Integer number) {
		super(Properties.of(Material.SAND).sound(SoundType.SAND).strength(0.5f * number.floatValue(),
				0.5f * (float) Math.pow(2.0f, number.doubleValue())));
	}

	@Override
	protected void falling(FallingBlockEntity fallingEntity) {
		fallingEntity.setHurtsEntities(true);
	}
}