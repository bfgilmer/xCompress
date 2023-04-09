package com.bfgilmer.xcompress.blocks;

import java.util.Random;

import java.util.function.ToIntFunction;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RedstoneTorchBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Material;

public class IronBlock extends Block {
	public static final BooleanProperty LIT = RedstoneTorchBlock.LIT;

	public IronBlock(Integer number) {
		super(Properties.of(Material.HEAVY_METAL).sound(SoundType.METAL)
				.strength(6.0f * number.floatValue(), 0.6f * (float) Math.pow(2.0f, number.doubleValue()))
				.lightLevel(litBlockEmission(15)).isRedstoneConductor(IronBlock::control));
		this.registerDefaultState(this.defaultBlockState().setValue(LIT, Boolean.valueOf(false)));
	}

	private static ToIntFunction<BlockState> litBlockEmission(int level_) {
		return (blockState) -> {
			return blockState.getValue(BlockStateProperties.LIT) ? level_ : 0;
		};
	}

	/**
	 * @param block
	 * @param reader
	 * @param position
	 * @return true if the signal is blocked.
	 */
	private static boolean control(BlockState block, BlockGetter reader, BlockPos position) {
		return false;
	}

	public boolean isSignalSource(BlockState p_149744_1_) {
		return true;
	}

	public int getSignal(BlockState p_180656_1_, BlockGetter p_180656_2_, BlockPos p_180656_3_,
			Direction p_180656_4_) {
		return 15;
	}

	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(LIT,
				Boolean.valueOf(context.getLevel().hasNeighborSignal(context.getClickedPos())));
	}

	public void neighborChanged(BlockState blockState, Level world, BlockPos blockPosition, Block block,
			BlockPos p_220069_5_, boolean p_220069_6_) {
		if (!world.isClientSide) {
			boolean flag = blockState.getValue(LIT);
			if (flag != world.hasNeighborSignal(blockPosition)) {
				if (flag) {
					((LevelAccessor) world.getBlockTicks()).scheduleTick(blockPosition, this, 4);
				} else {
					world.setBlock(blockPosition, blockState.cycle(LIT), 2);
				}
			}

		}
	}

	public void tick(BlockState blockState, ServerLevel world, BlockPos blockPosition, Random p_225534_4_) {
		if (blockState.getValue(LIT) && !world.hasNeighborSignal(blockPosition)) {
			world.setBlock(blockPosition, blockState.cycle(LIT), 2);
		}

	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(LIT);
	}
}
