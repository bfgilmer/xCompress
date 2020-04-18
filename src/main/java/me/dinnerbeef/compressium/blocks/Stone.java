package me.dinnerbeef.compressium.blocks;

import com.blakebr0.cucumber.block.BaseBlock;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class Stone extends BaseBlock {

    public Stone(Integer number) {
        super(Material.ROCK, SoundType.STONE, 6.0f, 1.5f*number.floatValue());
    }
}




