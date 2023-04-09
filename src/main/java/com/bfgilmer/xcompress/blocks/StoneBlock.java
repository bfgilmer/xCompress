package com.bfgilmer.xcompress.blocks;

import java.util.function.Function;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RedstoneLampBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class StoneBlock extends Block {
	protected static final VoxelShape COLLISION_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 15.0D, 15.0D);
	protected static final VoxelShape OUTLINE_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

	RedstoneLampBlock r;
	
	public static final DamageSource STONE_DAMAGE = new DamageSource("Compressium");
	private final float damageInflicted;

	public StoneBlock(Integer number) {
		this(Material.STONE, p -> p.sound(SoundType.STONE).strength(2.0f * number.floatValue(),
				(float) Math.pow(6.0f, number.doubleValue())).isValidSpawn(XcompressBlocks::always), number);
	}
	
	public StoneBlock(Material material, Function<Properties, Properties> properties, Integer number) {
		super(properties.apply(Properties.of(material)));
		this.damageInflicted = (float) (2.0f * Math.pow(2.0f, number.doubleValue()));
	}

	@Override
	   public void stepOn(Level worldIn, BlockPos pos, BlockState state, Entity entityIn) {
		if (entityIn instanceof Monster) {
			entityIn.hurt(STONE_DAMAGE, this.damageInflicted);
		}
		super.stepOn(worldIn, pos, state, entityIn);
	   }


	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockGetter reader, BlockPos position,
			CollisionContext context) {
		return COLLISION_SHAPE;
	}

/*
	public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_,
			ISelectionContext p_220053_4_) {
		return OUTLINE_SHAPE;
	}
*/
	public void entityInside(BlockState p_196262_1_, Level p_196262_2_, BlockPos p_196262_3_, Entity entityIn) {
		if (entityIn instanceof Monster) {
			entityIn.hurt(STONE_DAMAGE, this.damageInflicted);
		}
	}

}



