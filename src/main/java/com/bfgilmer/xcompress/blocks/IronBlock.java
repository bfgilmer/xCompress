package com.bfgilmer.xcompress.blocks;


import com.blakebr0.cucumber.block.BaseBlock;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class IronBlock extends BaseBlock {

    public IronBlock(Integer number) {
        super(Material.IRON, SoundType.METAL, 6.0f*number.floatValue(), (float)Math.pow(5.0f,number.doubleValue()));
    }
    
 }


