package com.bfgilmer.xcompress.blocks;


import com.blakebr0.cucumber.block.BaseBlock;

import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;


public class NetherrackBlock extends BaseBlock {
    public NetherrackBlock(Integer number) {
        super(Material.ROCK, p -> p.sound(SoundType.STONE).hardnessAndResistance(0.4f*number.floatValue(),0.4f*number.floatValue()));
    }
    
    @Override
    public boolean isFireSource(BlockState state, IBlockReader world, BlockPos pos, Direction side) {
        return true;
    }
}
