package com.bfgilmer.xcompress.blocks;


import net.minecraft.block.SoulSandBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;


public class SoulsandBlock extends SoulSandBlock {
    public SoulsandBlock(Integer number) {
        super(Properties.create(Material.SAND)
                .sound(SoundType.SAND)
                .hardnessAndResistance(0.5f, 0.5f));
    }

}