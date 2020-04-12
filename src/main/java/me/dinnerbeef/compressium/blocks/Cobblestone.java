package me.dinnerbeef.compressium.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class Cobblestone extends Block {

    public Cobblestone(Integer number) {
        super(Properties.create(Material.ROCK)
                .sound(SoundType.STONE)
                .hardnessAndResistance(2.0f*number.floatValue(), (float) Math.pow(6.0f, number.doubleValue())));
        setRegistryName("cobblestone_" + number);
    }
}
