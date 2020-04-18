package com.bfgilmer.xcompress.blocks;


import com.blakebr0.cucumber.block.BaseBlock;

import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public class IronBlock extends BaseBlock {

    public IronBlock(Integer number) {
        super(Material.IRON, SoundType.METAL, 6.0f*number.floatValue(), (float)Math.pow(5.0f,number.doubleValue()));
    }
    
    @Override
    public boolean isBeaconBase(BlockState state, IWorldReader world, BlockPos pos, BlockPos beacon) {
        return true;
    }
}


