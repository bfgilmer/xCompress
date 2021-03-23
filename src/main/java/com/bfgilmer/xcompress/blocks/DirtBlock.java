package com.bfgilmer.xcompress.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.FlowersFeature;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.IPlantable;

public class DirtBlock extends BaseBlock implements IGrowable {
	public DirtBlock(Integer number) {
		super(Material.DIRT, SoundType.GRASS, 0.5f * number.floatValue(),
				0.5f * (float) Math.pow(2.0f, number.doubleValue()));
	}

	@Override
	public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing,
			IPlantable plantable) {
		return net.minecraftforge.common.PlantType.PLAINS.equals(plantable.getPlantType(world, pos.relative(facing)));
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean isValidBonemealTarget(IBlockReader blockReader, BlockPos position, BlockState blockState,
			boolean p_176473_4_) {
		return blockReader.getBlockState(position.above()).isAir(blockReader, position);
	}

	@Override
	public boolean isBonemealSuccess(World p_180670_1_, Random p_180670_2_, BlockPos p_180670_3_,
			BlockState p_180670_4_) {
		return true;
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	@Override
	public void performBonemeal(ServerWorld world, Random random, BlockPos blockPosition, BlockState blockState) {
		BlockPos blockAbove = blockPosition.above();

		if (world.getBlockState(blockAbove).isAir()) {
			BlockState blockstate1;
			List<ConfiguredFeature<?, ?>> list = world.getBiome(blockAbove).getGenerationSettings().getFlowerFeatures();
			if (!list.isEmpty()) {
				ConfiguredFeature<?, ?> configuredfeature = list.get(0);

				FlowersFeature flowersfeature = (FlowersFeature) configuredfeature.feature();
				blockstate1 = flowersfeature.getRandomFlower(random, blockAbove, configuredfeature.config());
				if (blockstate1.canSurvive(world, blockAbove)) {
					world.setBlock(blockAbove, blockstate1, 3);
				}
			}
		}
	}
}
