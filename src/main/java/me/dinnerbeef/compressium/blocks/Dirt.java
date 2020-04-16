package me.dinnerbeef.compressium.blocks;

import com.blakebr0.cucumber.block.BaseBlock;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class Dirt extends BaseBlock {

	public Dirt(Integer number) {
        super(Material.EARTH, SoundType.GROUND, 0.5f * number.floatValue(), 0.5f * (float) Math.pow(2.0f, number.doubleValue()) );
	}
}
