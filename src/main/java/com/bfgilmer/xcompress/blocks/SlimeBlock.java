package com.bfgilmer.xcompress.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class SlimeBlock extends net.minecraft.block.SlimeBlock {

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
