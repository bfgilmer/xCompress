package com.bfgilmer.xcompress.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class FlintBlock extends FlintHopperBlock {
	public static final DamageSource FLINT_DAMAGE = new DamageSource("Compressium");
	private final float damageInflicted;
	
	public FlintBlock(Integer number) {
		super(Properties.of(Material.GLASS).sound(SoundType.GILDED_BLACKSTONE).strength(0.6f * number.floatValue(),
				0.6f * (float) Math.pow(2.0f, number.doubleValue())).noOcclusion(), number);

		this.damageInflicted = (float) (2.0f * Math.pow(2.0f, number.doubleValue()));
	}

	@Override
   public void stepOn(Level worldIn, BlockPos pos, BlockState blockState, Entity entityIn) {
		if (entityIn instanceof Monster) {
			entityIn.hurt(FLINT_DAMAGE, this.damageInflicted);
		}
		super.stepOn(worldIn, pos, blockState, entityIn);
   }
}
