package com.bfgilmer.xcompress.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry.PlacementType;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class NetherrackBlock extends BaseBlock {
	public static final DamageSource STONE_DAMAGE = new DamageSource("Compressium");
	private final float damageInflicted;

	public NetherrackBlock(Integer number) {
		super(Material.STONE,
				p -> p.sound(SoundType.STONE).strength(0.4f * number.floatValue(), 0.4f * number.floatValue()));
		
		this.damageInflicted = (float) (2.0f * Math.pow(2.0f, number.doubleValue()));
	}
	
	@Override
	public boolean canCreatureSpawn(BlockState state, IBlockReader world, BlockPos pos, PlacementType type,
			EntityType<?> entityType) {
		return true;
	}

	@Override
	public void stepOn(World worldIn, BlockPos pos, Entity entityIn) {
		if (entityIn instanceof ChickenEntity)
			if (!((AgeableEntity) entityIn).isBaby()) {
				entityIn.hurt(STONE_DAMAGE, this.damageInflicted);
				entityIn.setSecondsOnFire(3);
			}
		
		if (entityIn instanceof SheepEntity)
			if (!((SheepEntity) entityIn).isSheared()) {
				((SheepEntity) entityIn).shear(SoundCategory.NEUTRAL);
			}
		super.stepOn(worldIn, pos, entityIn);
	}
}
