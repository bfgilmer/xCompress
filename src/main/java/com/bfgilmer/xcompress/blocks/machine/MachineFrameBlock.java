package com.bfgilmer.xcompress.blocks.machine;

import com.bfgilmer.xcompress.Xcompress;
import com.bfgilmer.xcompress.tileentity.MachineFrameTileEntity;

import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeBlock;

public class MachineFrameBlock extends ContainerBlock implements IForgeBlock {

	public MachineFrameBlock(Properties properties) {
		this();
	}
	
	public MachineFrameBlock() {
		super(Properties.of(Material.CLAY).sound(SoundType.STONE).strength(0.6f, 0.6f));
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return this.newBlockEntity(world);
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public TileEntity newBlockEntity(IBlockReader reader) {
		return new MachineFrameTileEntity();
	}


	@Override
	public BlockRenderType getRenderShape(BlockState p_149645_1_) {
		return BlockRenderType.MODEL;
	}

	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn,
			BlockRayTraceResult p_225533_6_) {
		if (worldIn.isClientSide) {
			return ActionResultType.SUCCESS;
		} else {
			TileEntity tileentity = worldIn.getBlockEntity(pos);
			if (tileentity instanceof MachineFrameTileEntity) {		
				player.openMenu((MachineFrameTileEntity) tileentity);
			}
			else {
				Xcompress.LOGGER.info(getDescriptionId(), tileentity, tileentity, state, worldIn, pos, player, handIn, p_225533_6_, tileentity);
			}

			return ActionResultType.SUCCESS;
		}
	}

}
