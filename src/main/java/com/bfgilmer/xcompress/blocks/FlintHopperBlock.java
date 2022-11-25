package com.bfgilmer.xcompress.blocks;

import com.bfgilmer.xcompress.inventory.FlintTypes;
import com.bfgilmer.xcompress.tileentity.BaseFlintTileEntity;
import com.bfgilmer.xcompress.tileentity.Flint1TileEntity;
import com.bfgilmer.xcompress.tileentity.Flint2TileEntity;
import com.bfgilmer.xcompress.tileentity.Flint3TileEntity;
import com.bfgilmer.xcompress.tileentity.Flint4TileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeBlock;


public class FlintHopperBlock extends ContainerBlock implements IForgeBlock {
	@Override
	public boolean canHarvestBlock(BlockState state, IBlockReader world, BlockPos pos, PlayerEntity player) {
		return true;
	}

	private final int level;
	private final FlintTypes hopperType;
	
    public static final BooleanProperty EMPTY = BooleanProperty.create("empty");
    
	public FlintHopperBlock(Block.Properties properties) {
		this(properties,1);
	}

	public FlintHopperBlock(Block.Properties properties, int level) {
		super(properties);
		this.level= FlintTypes.getLevel(level);
		this.hopperType=FlintTypes.createFlintType(this.level);
		
		this.registerDefaultState(this.stateDefinition.any().setValue(EMPTY, true));
	}

	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn,
			BlockRayTraceResult p_225533_6_) {
		if (worldIn.isClientSide) {
			return ActionResultType.SUCCESS;
		} else {
			TileEntity tileentity = worldIn.getBlockEntity(pos);
			if (tileentity instanceof BaseFlintTileEntity) {		
				player.openMenu((BaseFlintTileEntity) tileentity);
				player.awardStat(Stats.INSPECT_HOPPER);
			}

			return ActionResultType.SUCCESS;
		}
	}

	@Override
	public BlockRenderType getRenderShape(BlockState state) {
		return BlockRenderType.MODEL;
	}
	
	@Override
	public TileEntity newBlockEntity(IBlockReader blockReader) {
		if (getLevel() == 1) {
			return new Flint1TileEntity();
		} else if (getLevel() == 2) {
			return new Flint2TileEntity();
		} else if (getLevel() == 3) {
			return new Flint3TileEntity();
		}  
		
		return new Flint4TileEntity();
	}

	@Override
	  public boolean isSignalSource(BlockState p_149744_1_) {
	      return true;
	   }

	@Override
	   public int getSignal(BlockState state, IBlockReader reader, BlockPos position, Direction direction) {
	      return state.getValue(EMPTY) ? 0 : 15;
	   }
	
	public static void updateState(BlockState state, World world, BlockPos position, boolean value) {
		world.setBlock(position, state.setValue(EMPTY, value), 3);
	}

	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
		builder.add(EMPTY);
	}

	public int getLevel() {
		return level;
	}

	public FlintTypes getHopperType() {
		return hopperType;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return this.newBlockEntity(world);
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
	
	
	
}
