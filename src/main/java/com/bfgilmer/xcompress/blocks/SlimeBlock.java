package com.bfgilmer.xcompress.blocks;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class SlimeBlock extends net.minecraft.world.level.block.SlimeBlock {

	private int level;

	public int getLevel() {
		return level;
	}

	private void setLevel(int level) {
		this.level = level;
	}

	public SlimeBlock(Integer number) {
		super(Properties.of(Material.SPONGE).sound(SoundType.SLIME_BLOCK).strength(0, 0));
		setLevel(number);
	}
}
