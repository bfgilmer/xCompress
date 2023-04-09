package com.bfgilmer.xcompress.blocks;

import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class SandBlock extends FallingBlock {
	public SandBlock(Integer number) {
		super(Properties.of(Material.SAND).sound(SoundType.SAND).strength(0.5f * number.floatValue(),
				0.5f * (float) Math.pow(2.0f, number.doubleValue())));
	}

	@Override
	protected void falling(FallingBlockEntity fallingEntity) {
		fallingEntity.setHurtsEntities(0.5F, 10);
	}
}