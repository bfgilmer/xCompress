package me.dinnerbeef.compressium.blocks;

import com.blakebr0.cucumber.block.BaseBlock;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class Clay extends BaseBlock {

    public Clay(Integer number) {
        super(Material.CLAY, p -> p.sound(SoundType.GROUND)
                .hardnessAndResistance(0.6f*number.floatValue(), 0.6f*(float)Math.pow(2.0f, number.doubleValue())));
    }
}
