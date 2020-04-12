package me.dinnerbeef.compressium.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class Clay extends Block {

    public Clay(Integer number) {
        super(Properties.create(Material.CLAY)
                .sound(SoundType.GROUND)
                .hardnessAndResistance(0.6f*number.floatValue(), 0.6f*(float)Math.pow(2.0f, number.doubleValue())));
        setRegistryName("clay_" + number);
    }
}
