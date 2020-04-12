package me.dinnerbeef.compressium.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class Dirt extends Block {

	public Dirt(Integer number) {
        super(Properties.create(Material.EARTH)
                .sound(SoundType.GROUND)
                .hardnessAndResistance(0.5f * number.floatValue(), 0.5f * (float) Math.pow(2.0f, number.doubleValue()) ));
        setRegistryName("dirt_" + number);
	}
}
