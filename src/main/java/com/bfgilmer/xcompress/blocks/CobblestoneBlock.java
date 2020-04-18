package com.bfgilmer.xcompress.blocks;

import com.blakebr0.cucumber.block.BaseBlock;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class CobblestoneBlock extends BaseBlock {

    public CobblestoneBlock(Integer number) {
        super(Material.ROCK, p -> p.sound(SoundType.STONE).hardnessAndResistance(2.0f*number.floatValue(), (float) Math.pow(6.0f, number.doubleValue())));
    }
}
