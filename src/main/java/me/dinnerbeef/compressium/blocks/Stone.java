package me.dinnerbeef.compressium.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class Stone extends Block {

    public Stone(Integer number) {
        super(Properties.create(Material.ROCK)
                .sound(SoundType.STONE)
                .hardnessAndResistance(6.0f,1.5f*number.floatValue()));
        setRegistryName("stone_" + number);
    }
}




