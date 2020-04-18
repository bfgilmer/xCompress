package me.dinnerbeef.compressium.blocks;


import com.blakebr0.cucumber.block.BaseBlock;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;


public class Snow extends BaseBlock {
    public Snow(Integer number) {
        super(Material.SNOW_BLOCK, p -> p.sound(SoundType.SNOW)
                .hardnessAndResistance(0.2f*number.floatValue(),(0.2f*number.floatValue()))
                .slipperiness(0.6f*number.floatValue())
                .speedFactor(number.floatValue()));
    }
}
