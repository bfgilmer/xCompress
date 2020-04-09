package me.bfgilmer.xcompress.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;


public class Snow extends Block {
    public Snow(Integer number) {
        super(Properties.create(Material.SNOW_BLOCK)
                .sound(SoundType.SNOW).hardnessAndResistance(2.0f));
        setRegistryName("snow_" + number);
    }
}
