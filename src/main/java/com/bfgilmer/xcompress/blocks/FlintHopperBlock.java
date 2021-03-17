package com.bfgilmer.xcompress.blocks;

import com.bfgilmer.xcompress.tileentity.FlintTileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeBlock;

public class FlintHopperBlock extends ContainerBlock implements IForgeBlock {
	private int range = 0; // Collection area = 0 is above and {1-4} is the distance from the block

	public FlintHopperBlock(Block.Properties properties) {
		super(properties);
	}

	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn,
			BlockRayTraceResult p_225533_6_) {
		if (worldIn.isClientSide) {
			return ActionResultType.SUCCESS;
		} else {
			TileEntity tileentity = worldIn.getBlockEntity(pos);
			if (tileentity instanceof FlintTileEntity) {
				player.openMenu((FlintTileEntity) tileentity);
				player.awardStat(Stats.INSPECT_HOPPER);
			}

			return ActionResultType.SUCCESS;
		}
	}

	/**
	 * The type of render function called. MODEL for mixed tesr and static model,
	 * MODELBLOCK_ANIMATED for TESR-only, LIQUID for vanilla liquids, INVISIBLE to
	 * skip all rendering
	 * 
	 * @deprecated call via {@link IBlockState#getRenderType()} whenever possible.
	 *             Implementing/overriding is fine.
	 */
	@Deprecated
	@Override
	public BlockRenderType getRenderShape(BlockState state) {
		return BlockRenderType.MODEL;
	}

	@Override
	public TileEntity newBlockEntity(IBlockReader blockReader) {
		FlintTileEntity te = new FlintTileEntity();
		te.setCollectionSize(getRange());
		return te;
	}

	/**
	 * @return the range
	 */
	public int getRange() {
		return range;
	}

	/**
	 * @param range the range to set
	 */
	public void setRange(int range) {
		this.range = range;
	}
}
