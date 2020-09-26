package com.bfgilmer.xcompress.blocks;

import com.blakebr0.cucumber.block.BaseBlock;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class FlintBlock extends BaseBlock {
    public FlintBlock(Integer number) {
        super(Material.ROCK, p -> p.sound(SoundType.GROUND)
                .hardnessAndResistance(0.6f*number.floatValue(), 0.6f*(float)Math.pow(2.0f, number.doubleValue())));
    }

}
