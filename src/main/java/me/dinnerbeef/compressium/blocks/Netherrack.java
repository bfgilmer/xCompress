package me.dinnerbeef.compressium.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;


public class Netherrack extends Block {
    public Netherrack(Integer number) {
        super(Properties.create(Material.ROCK)
                .sound(SoundType.STONE).hardnessAndResistance(0.4f*number.floatValue(),0.4f*number.floatValue()));
        setRegistryName("netherrack_"+ number);
    }
    
    @Override
    public boolean isFireSource(BlockState state, IBlockReader world, BlockPos pos, Direction side) {
        return true;
    }
}
