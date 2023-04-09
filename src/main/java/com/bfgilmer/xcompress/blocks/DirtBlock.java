package com.bfgilmer.xcompress.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.IPlantable;


public class DirtBlock extends Block implements BonemealableBlock {
	public DirtBlock(Integer number) {
		this(Material.DIRT, SoundType.GRASS, 0.5f * number.floatValue(),
				0.5f * (float) Math.pow(2.0f, number.doubleValue()));
	}

	public DirtBlock(Material material, SoundType sound, float hardness, float resistance) {
		super(Properties.of(material).sound(sound).strength(hardness, resistance));
	}

	@Override
	public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing,
			IPlantable plantable) {
		return net.minecraftforge.common.PlantType.PLAINS.equals(plantable.getPlantType(world, pos.relative(facing)));
	}

	@Override
	public boolean isValidBonemealTarget(BlockGetter blockReader, BlockPos position, BlockState blockState,
			boolean p_176473_4_) {
		return blockReader.getBlockState(position.above()).isAir();
	}

	@Override
	public boolean isBonemealSuccess(Level p_180670_1_, Random p_180670_2_, BlockPos p_180670_3_,
			BlockState p_180670_4_) {
		return true;
	}

	@Override
	  public void performBonemeal(ServerLevel world, Random rando, BlockPos blockPosition, BlockState blockState) {
	      BlockPos blockpos = blockPosition.above();
	      BlockState blockstate = Blocks.GRASS.defaultBlockState();

	      label46:
	      for(int i = 0; i < 128; ++i) {
	         BlockPos blockpos1 = blockpos;

	         for(int j = 0; j < i / 16; ++j) {
	            blockpos1 = blockpos1.offset(rando.nextInt(3) - 1, (rando.nextInt(3) - 1) * rando.nextInt(3) / 2, rando.nextInt(3) - 1);
	            if (!world.getBlockState(blockpos1.below()).is(this) || world.getBlockState(blockpos1).isCollisionShapeFullBlock(world, blockpos1)) {
	               continue label46;
	            }
	         }

	         BlockState blockstate1 = world.getBlockState(blockpos1);
	         if (blockstate1.is(blockstate.getBlock()) && rando.nextInt(10) == 0) {
	            ((BonemealableBlock)blockstate.getBlock()).performBonemeal(world, rando, blockpos1, blockstate1);
	         }

	         if (blockstate1.isAir()) {
	            Holder<PlacedFeature> holder;
	            if (rando.nextInt(8) == 0) {
	               List<ConfiguredFeature<?, ?>> list = world.getBiome(blockpos1).value().getGenerationSettings().getFlowerFeatures();
	               if (list.isEmpty()) {
	                  continue;
	               }

	               holder = ((RandomPatchConfiguration)list.get(0).config()).feature();
	            } else {
	               holder = VegetationPlacements.GRASS_BONEMEAL;
	            }

	            holder.value().place(world, world.getChunkSource().getGenerator(), rando, blockpos1);
	         }
	      }

	   }
}
