package com.bfgilmer.xcompress.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySpawnPlacementRegistry.PlacementType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class StoneBlock extends BaseBlock {

	public static final DamageSource STONE_DAMAGE = new DamageSource("Compressium");
	private final float damageInflicted;


	public StoneBlock(Integer number) {
		super(Material.STONE, p -> p.sound(SoundType.STONE).strength(2.0f * number.floatValue(),
				(float) Math.pow(6.0f, number.doubleValue())));
		this.damageInflicted = (float) (2.0f * Math.pow(2.0f, number.doubleValue()));
	}

	@Override
	public boolean canCreatureSpawn(BlockState state, IBlockReader world, BlockPos pos, PlacementType type,
			EntityType<?> entityType) {
		return true;
	}

	@Override
	public void stepOn(World worldIn, BlockPos pos, Entity entityIn) {
		if (entityIn instanceof MonsterEntity) {
			entityIn.hurt(STONE_DAMAGE, this.damageInflicted);
		}
		super.stepOn(worldIn, pos, entityIn);
	}
}
