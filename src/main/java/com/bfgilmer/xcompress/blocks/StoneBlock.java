package com.bfgilmer.xcompress.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class StoneBlock extends BaseBlock {

	private Integer level;
	public static final DamageSource STONE_DAMAGE = new DamageSource("Compressium");

	public StoneBlock(Integer number) {
		super(Material.STONE, p -> p.sound(SoundType.STONE).strength(2.0f * number.floatValue(),
				(float) Math.pow(6.0f, number.doubleValue())));
		setLevel(number);
	}

	@Override
	public void stepOn(World worldIn, BlockPos pos, Entity entityIn) {
		if (entityIn instanceof MonsterEntity) {
			entityIn.hurt(STONE_DAMAGE, 2 * level * level);
		}
		super.stepOn(worldIn, pos, entityIn);
	}

	public Integer getLevel() {
		return level;
	}

	private void setLevel(Integer level) {
		this.level = level;
	}
}
