package com.bfgilmer.xcompress.blocks;

import javax.annotation.Nullable;

import com.bfgilmer.xcompress.blockentity.BaseFlintBlockEntity;
import com.bfgilmer.xcompress.blockentity.Flint1BlockEntity;
import com.bfgilmer.xcompress.blockentity.Flint2BlockEntity;
import com.bfgilmer.xcompress.blockentity.Flint3BlockEntity;
import com.bfgilmer.xcompress.blockentity.Flint4BlockEntity;
import com.bfgilmer.xcompress.inventory.FlintContainer;
import com.bfgilmer.xcompress.inventory.FlintTypes;
import com.bfgilmer.xcompress.inventory.XcompressContainers;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.extensions.IForgeBlock;
import net.minecraftforge.network.NetworkHooks;

public class FlintHopperBlock extends BaseEntityBlock implements IForgeBlock {
	public static final String SCREEN_TUTORIAL_POWERGEN = "screen.tutorial.powergen";

	private final int level;
	private final FlintTypes hopperType;

	public static final BooleanProperty EMPTY = BooleanProperty.create("empty");

	public FlintHopperBlock(Block.Properties properties) {
		this(properties, 1);
	}

	public FlintHopperBlock(Block.Properties properties, int level) {
		super(properties);
		this.level = FlintTypes.getLevel(level);
		this.hopperType = FlintTypes.createFlintType(this.level);

		this.registerDefaultState(this.stateDefinition.any().setValue(EMPTY, true));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(EMPTY);
	}

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state,
			BlockEntityType<T> type) {
		if (level.isClientSide()) {
			return null;
		}
		return (lvl, pos, blockState, t) -> {
			if (t instanceof BaseFlintBlockEntity tile) {
				BaseFlintBlockEntity.tickServer(lvl, pos, blockState, tile);
			}
		};
	}

	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn,
			BlockHitResult p_225533_6_) {
		if (worldIn.isClientSide) {
			return InteractionResult.SUCCESS;
		} else {
			BlockEntity tileentity = worldIn.getBlockEntity(pos);
			if (tileentity instanceof BaseFlintBlockEntity) {
				MenuProvider containerProvider = null;

				switch (((BaseFlintBlockEntity) tileentity).getFlintLevel()) {
				case 1: {
					containerProvider = new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return new TranslatableComponent(SCREEN_TUTORIAL_POWERGEN);
						}

						@Override
						public AbstractContainerMenu createMenu(int windowId, Inventory playerInventory,
								Player playerEntity) {
							return new FlintContainer(XcompressContainers.FLINT_CONTAINER_1.get(), windowId, pos,
									playerInventory, playerEntity, FlintTypes.createFlintType(1));
						}
					};
				}
				case 2: {
					containerProvider = new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return new TranslatableComponent(SCREEN_TUTORIAL_POWERGEN);
						}

						@Override
						public AbstractContainerMenu createMenu(int windowId, Inventory playerInventory,
								Player playerEntity) {
							return new FlintContainer(XcompressContainers.FLINT_CONTAINER_2.get(), windowId, pos,
									playerInventory, playerEntity, FlintTypes.createFlintType(2));
						}
					};

				}
				case 3: {
					containerProvider = new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return new TranslatableComponent(SCREEN_TUTORIAL_POWERGEN);
						}

						@Override
						public AbstractContainerMenu createMenu(int windowId, Inventory playerInventory,
								Player playerEntity) {
							return new FlintContainer(XcompressContainers.FLINT_CONTAINER_3.get(), windowId, pos,
									playerInventory, playerEntity, FlintTypes.createFlintType(3));
						}
					};

				}
				case 4: {
					containerProvider = new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return new TranslatableComponent(SCREEN_TUTORIAL_POWERGEN);
						}

						@Override
						public AbstractContainerMenu createMenu(int windowId, Inventory playerInventory,
								Player playerEntity) {
							return new FlintContainer(XcompressContainers.FLINT_CONTAINER_4.get(), windowId, pos,
									playerInventory, playerEntity, FlintTypes.createFlintType(4));
						}
					};

				}
				}

				NetworkHooks.openGui((ServerPlayer) player, containerProvider, tileentity.getBlockPos());

				player.awardStat(Stats.INSPECT_HOPPER);
			} else {
				throw new IllegalStateException("Our named container provider is missing!");
			}
		}

		return InteractionResult.SUCCESS;
	}

	public boolean isSignalSource(BlockState p_149744_1_) {
		return true;
	}

	@Override
	public int getSignal(BlockState state, BlockGetter reader, BlockPos position, Direction direction) {
		return state.getValue(EMPTY) ? 0 : 15;
	}

	public static void updateState(BlockState state, Level world, BlockPos position, boolean value) {
		world.setBlock(position, state.setValue(EMPTY, value), 3);
	}

	public int getLevel() {
		return level;
	}

	public FlintTypes getHopperType() {
		return hopperType;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos position, BlockState state) {
		if (getLevel() == 1) {
			return new Flint1BlockEntity(position, state);
		} else if (getLevel() == 2) {
			return new Flint2BlockEntity(position, state);
		} else if (getLevel() == 3) {
			return new Flint3BlockEntity(position, state);
		}

		return new Flint4BlockEntity(position, state);
	}

}
