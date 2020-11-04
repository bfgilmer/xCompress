package com.bfgilmer.xcompress.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SlimeBlock extends net.minecraft.block.SlimeBlock {

	private int level;
    public int getLevel() {
		return level;
	}

	private void setLevel(int level) {
		this.level = level;
	}

	public SlimeBlock(Integer number) {
		super(Properties.create(Material.ORGANIC)
                .sound(SoundType.SLIME)
                .hardnessAndResistance(0, 0));
        setLevel(number);
    }
    
    /**
     * Block's chance to react to a living entity falling on it.
     */
    @Override
	public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
         super.onFallenUpon(worldIn, pos, entityIn, fallDistance*getLevel());
    }
}
