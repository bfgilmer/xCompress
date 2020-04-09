package me.bfgilmer.xcompress.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class Stone extends Block {

    public Stone(Integer number) {
        super(Properties.create(Material.ROCK)
                .sound(SoundType.STONE).hardnessAndResistance(2.0f));
        setRegistryName("stone_" + number);
    }
}




