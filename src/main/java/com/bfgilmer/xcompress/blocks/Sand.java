package com.bfgilmer.xcompress.blocks;

import net.minecraft.block.FallingBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.FallingBlockEntity;

public class Sand extends FallingBlock {
    public Sand(Integer number) {
        super(Properties.create(Material.SAND)
                .sound(SoundType.SAND)
                .hardnessAndResistance(0.5f*number.floatValue(), 0.5f*(float)Math.pow(2.0f, number.doubleValue())));
    }
    
    protected void onStartFalling(FallingBlockEntity fallingEntity) {
        fallingEntity.setHurtEntities(true);
    }  
}