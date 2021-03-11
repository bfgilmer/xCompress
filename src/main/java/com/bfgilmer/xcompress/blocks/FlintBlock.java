package com.bfgilmer.xcompress.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FlintBlock extends FlintHopperBlock {
    public static final DamageSource FLINT_DAMAGE = new DamageSource("Compressium");
    
    public FlintBlock(Integer number) {
/*    	super(Material.ROCK, SoundType.GROUND, 6.0f*number.floatValue(), (float)Math.pow(5.0f,number.doubleValue())); */
        super(Properties.create(Material.ROCK)
                .sound(SoundType.GROUND)
                .hardnessAndResistance(0.6f*number.floatValue(), 0.6f*(float)Math.pow(2.0f, number.doubleValue())));      
        setRank(number);
    }
    
	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		Integer level = getRank();
        if (entityIn instanceof MonsterEntity) {
	        entityIn.attackEntityFrom(FLINT_DAMAGE, 2*level*level);
        }
		super.onEntityWalk(worldIn, pos, entityIn);
	}
}
