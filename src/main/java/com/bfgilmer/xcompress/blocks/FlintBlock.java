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

	private final float damageInflicted;
	private static final int RANGES[] = {1, 1, 3, 5, 7};

	public FlintBlock(Integer number) {
		super(Properties.of(Material.GLASS).sound(SoundType.GILDED_BLACKSTONE).strength(0.6f * number.floatValue(),
				0.6f * (float) Math.pow(2.0f, number.doubleValue())).noOcclusion());

		this.damageInflicted = (float) (2.0f * Math.pow(2.0f, number.doubleValue()));
		setRange(RANGES[number]);
	}

	@Override
	public void stepOn(World worldIn, BlockPos pos, Entity entityIn) {
		if (entityIn instanceof MonsterEntity) {
			entityIn.hurt(FLINT_DAMAGE, this.damageInflicted);
		}
		super.stepOn(worldIn, pos, entityIn);
	}
}
