package com.bfgilmer.xcompress.blocks;

import java.util.function.Function;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class NetherrackBlock extends Block {
	public static final DamageSource STONE_DAMAGE = new DamageSource("Compressium");
	private final float damageInflicted;

	public NetherrackBlock(Integer number) {
		this(Material.STONE,
				p -> p.sound(SoundType.STONE).strength(0.4f * number.floatValue(), 0.4f * number.floatValue()).isValidSpawn(XcompressBlocks::always), number);	
	}
	
	public NetherrackBlock(Material material, Function<Properties, Properties> properties, Integer number) {
		super(properties.apply(Properties.of(material)));
		this.damageInflicted = (float) (2.0f * Math.pow(2.0f, number.doubleValue()));
	}

	@Override
	   public void stepOn(Level worldIn, BlockPos pos, BlockState state, Entity entityIn) {
		if (entityIn instanceof Chicken)
			if (!((AgeableMob) entityIn).isBaby()) {
				entityIn.hurt(STONE_DAMAGE, this.damageInflicted);
				entityIn.setSecondsOnFire(3);
			}
		
		if (entityIn instanceof Sheep)
			if (!((Sheep) entityIn).isSheared()) {
				((Sheep) entityIn).shear(SoundSource.NEUTRAL);
			}
		super.stepOn(worldIn, pos, state, entityIn);
	}
}
