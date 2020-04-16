package me.dinnerbeef.compressium.blocks;

import com.blakebr0.cucumber.block.BaseBlock;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class Cobblestone extends BaseBlock {

    public Cobblestone(Integer number) {
        super(Material.ROCK, p -> p.sound(SoundType.STONE).hardnessAndResistance(2.0f*number.floatValue(), (float) Math.pow(6.0f, number.doubleValue())));
    }
}
