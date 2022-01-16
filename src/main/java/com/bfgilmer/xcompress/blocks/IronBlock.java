package com.bfgilmer.xcompress.blocks;

import java.util.Random;

import java.util.function.ToIntFunction;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneTorchBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class IronBlock extends BaseBlock {
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
	private static boolean control(BlockState block, IBlockReader reader, BlockPos position) {
		return false;
	}

	public boolean isSignalSource(BlockState p_149744_1_) {
		return true;
	}

	public int getSignal(BlockState p_180656_1_, IBlockReader p_180656_2_, BlockPos p_180656_3_,
			Direction p_180656_4_) {
		return 15;
	}

	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.defaultBlockState().setValue(LIT,
				Boolean.valueOf(context.getLevel().hasNeighborSignal(context.getClickedPos())));
	}

	public void neighborChanged(BlockState blockState, World world, BlockPos blockPosition, Block block,
			BlockPos p_220069_5_, boolean p_220069_6_) {
		if (!world.isClientSide) {
			boolean flag = blockState.getValue(LIT);
			if (flag != world.hasNeighborSignal(blockPosition)) {
				if (flag) {
					world.getBlockTicks().scheduleTick(blockPosition, this, 4);
				} else {
					world.setBlock(blockPosition, blockState.cycle(LIT), 2);
				}
			}

		}
	}

	public void tick(BlockState blockState, ServerWorld world, BlockPos blockPosition, Random p_225534_4_) {
		if (blockState.getValue(LIT) && !world.hasNeighborSignal(blockPosition)) {
			world.setBlock(blockPosition, blockState.cycle(LIT), 2);
		}

	}

	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(LIT);
	}
}
