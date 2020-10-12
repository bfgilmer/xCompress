package com.bfgilmer.xcompress.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class FlintBlock extends FlintHopperBlock {
    public FlintBlock(Integer number) {
/*    	super(Material.ROCK, SoundType.GROUND, 6.0f*number.floatValue(), (float)Math.pow(5.0f,number.doubleValue())); */
        super(Properties.create(Material.ROCK)
                .sound(SoundType.GROUND)
                .hardnessAndResistance(0.6f*number.floatValue(), 0.6f*(float)Math.pow(2.0f, number.doubleValue())));      
        setRank(number);
    }  
}
