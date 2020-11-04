package com.bfgilmer.xcompress.blocks;

import com.blakebr0.cucumber.block.BaseBlock;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;


public class ClayBlock extends BaseBlock {

	private int level;
    public int getLevel() {
		return level;
	}

	private void setLevel(int level) {
		this.level = level;
	}

	public ClayBlock(Integer number) {
        super(Material.CLAY, p -> p.sound(SoundType.GROUND)
                .hardnessAndResistance(0.6f*number.floatValue(), 0.6f*(float)Math.pow(2.0f, number.doubleValue())));
        setLevel(number);
    }
    
}
