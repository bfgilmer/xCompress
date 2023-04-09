package com.bfgilmer.xcompress.blockentity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.bfgilmer.xcompress.blocks.FlintBlock;
import com.bfgilmer.xcompress.inventory.FlintTypes;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class BaseFlintBlockEntity extends BlockEntity {
	private int flintLevel; 
	private FlintTypes type;
	
	private int cooldownTime;
	private CoolDownTimer cooldown;
	
	private final CollectionArea target;
	
    private final ItemStackHandler itemHandler = createHandler();
    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);
    
	public BaseFlintBlockEntity(BlockEntityType<?> fte, BlockPos worldPosition, BlockState blockState, int flevel) {
		super(fte, worldPosition, blockState);
		
		setFlintLevel(flevel);
		
		this.cooldown=new CoolDownTimer(level, 8);
		this.cooldownTime=this.cooldown.getCool();

		this.target = CollectionArea.createCollectionArea(this, level, type.getCollectionArea(), worldPosition);
	}
	
	// getter for flint level
	public int getFlintLevel() {
		return FlintTypes.getLevel(flintLevel);		
	}

	// setter flint level
	public void setFlintLevel(int level) {
		this.flintLevel = FlintTypes.getLevel(level);
		this.type = FlintTypes.createFlintType(level);
	}

	// setter for cooldowntime always go through cooldown class
	public void setCooldown(int cool) {
		this.cooldown.setCool(cool);		
		this.cooldownTime = this.cooldown.getCool();
	}

	// getter for cooldowntime alway go through cooldown class
	public int getCooldown() {
		return this.cooldown.getCool();
	}
	

    @Override
    public void load(CompoundTag tag) {
        if (tag.contains("Inventory")) {
            itemHandler.deserializeNBT(tag.getCompound("Inventory"));
        }
        if (tag.contains("Info")) {
            this.cooldownTime = tag.getCompound("Info").getInt("TransferCooldown");
            this.cooldown.setCool(cooldownTime);
            
            this.flintLevel = tag.getCompound("Info").getInt("FlintLevel");
    		this.type = FlintTypes.createFlintType(this.flintLevel);
        }
        super.load(tag);
    }

    @Override
    public void saveAdditional(CompoundTag tag) {
        tag.put("Inventory", itemHandler.serializeNBT());

        CompoundTag infoTag = new CompoundTag();
        infoTag.putInt("FlintLevel", this.flintLevel);
        infoTag.putInt("TransferCooldown", this.cooldown.getCool());
        tag.put("Info", infoTag);
    }
    
    private ItemStackHandler createHandler() {
        return new ItemStackHandler(FlintTypes.createFlintType(this.flintLevel).getSlots()) {

            @Override
            protected void onContentsChanged(int slot) {
                // To make sure the TE persists when the chunk is saved later we need to
                // mark it dirty every time the item handler changes
                setChanged();
            }
        };
    }
    
    @Override
    public void setRemoved() {
        super.setRemoved();
        handler.invalidate();
    }
    
	public static boolean tickServer(Level lvl, BlockPos pos, BlockState state, BaseFlintBlockEntity be) {
		// Check cooldown for readiness
		// Eject items
		// Check for space available
		// Vaccume items from above
		// Update Block state
		
 		if (lvl != null && !lvl.isClientSide) {
 			if (be.cooldown.ticked()) {
 				ejectItems(be.itemHandler, lvl, pos);
 				
 				if (!BaseFlintBlockEntity.isFull(be.itemHandler))
 				{
 					for (ItemEntity itementity : getItemsAtAndAbove(be.target)) {
 						if (addItem(be.itemHandler, itementity.getItem())) {
 							return true;
 						}
 					}

 				}
 			}

			if (be.cooldown.ready()) {
				be.cooldown.reset();
				
		         BlockState blockstate = be.getBlockState();
		         Block block = blockstate.getBlock();
		         if (block instanceof FlintBlock) {
		            FlintBlock.updateState(blockstate, lvl, pos, isEmpty(be.itemHandler));
		         }
			}
		}
 		return true;
	}

	// Ejects the first available item stack below
	private static boolean ejectItems(IItemHandler itemHandler, Level level, BlockPos worldPosition) {
		if (!isEmpty(itemHandler)) {
            BlockEntity be = level.getBlockEntity(worldPosition.relative(Direction.DOWN));
            if (be != null) {
            	be.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, Direction.UP).map(handler->{
            		if (isFull(handler)) {
            			return false;
            		}
            		
            		int first=firstAvailable(itemHandler);
        			for (int k=0;k < handler.getSlots(); k++) {
            			ItemStack stack = itemHandler.extractItem(first, handler.getSlotLimit(k), false);
        				ItemStack remainder = handler.insertItem(k, stack , false);
        				if (remainder.isEmpty()) {
        					return true;
        				}
        				itemHandler.insertItem(first, remainder, false);
        			}
            		return false;            	
            	});
            };
	    }
		
		return false;
	}
	
	public static List<ItemEntity> getItemsAtAndAbove(CollectionArea hopper) {	
		return hopper.getCollectionArea().toAabbs().stream().flatMap((blk) -> {
			return hopper.getLevel()
					.getEntitiesOfClass(
							ItemEntity.class, blk.move(hopper.getLevelX() - 0.5D,
									hopper.getLevelY() - 0.5D, hopper.getLevelZ() - 0.5D),
							EntitySelector.ENTITY_STILL_ALIVE)
					.stream();
		}).collect(Collectors.toList());
	}
	
	// Attempt to place item in the container
	public static boolean addItem(IItemHandler handler, ItemStack item) {
		int count=item.getCount();
		List<Integer> slots=IntStream.rangeClosed(0, handler.getSlots()).boxed().toList();			
	 
		// Can merge with existing stack
		if (!isEmpty(handler)) {
			List<Integer> merge=slots.stream().filter(w->handler.getStackInSlot(w).sameItem(item)).toList();
			if (!merge.isEmpty()) {
				for (Integer i : merge) {
					if (canMergeItems(handler.getStackInSlot(i), item)) {						
						int apply = handler.getStackInSlot(i).getCount() + count;
						
						apply = (apply > handler.getSlotLimit(i)) ? handler.getSlotLimit(i) : apply;
						handler.getStackInSlot(i).setCount(apply);
						count -= apply;
						if (count <= 0) {						
							return true;
						}
					}
				}
			}
			
			// Can place in an empty stack			
			List<Integer> free=slots.stream().filter(w->handler.getStackInSlot(w).isEmpty()).toList();
			if (!free.isEmpty()) {
				ItemStack copyOf = item.copy();
				for (Integer i: free) {
					copyOf=handler.insertItem(i, copyOf, false);
					count = copyOf.getCount();
					if (count <= 0) { 
						return true;
					}
				}
			}
		}
		
		return (count > 0);
	}
	
	
	private static boolean isFull(IItemHandler handler) {
		for (int i=0; i<handler.getSlots(); i++) {
			ItemStack stack=handler.getStackInSlot(i);
			if (stack.isEmpty() || stack.getCount() != stack.getMaxStackSize())
				return false;
		}

		return true;
	}
	
	private static boolean isEmpty(IItemHandler handler) {
		for (int i=0; i<handler.getSlots(); i++) {
			ItemStack stack=handler.getStackInSlot(i);
			if (!stack.isEmpty())
				return false;
		}
		
		return true;
	}
	
	private static int firstAvailable(IItemHandler handler) {
		for (int i=0; i<handler.getSlots(); i++) {
			ItemStack stack=handler.getStackInSlot(i);
			if (!stack.isEmpty())
				return i;
		}
		
		return -1;
	}
	
	private static boolean canMergeItems(ItemStack input, ItemStack target) {
		if (ItemStack.isSameItemSameTags(input, target)) {
			return (input.getCount() > input.getMaxStackSize());
		} 

		return false;
	}

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return handler.cast();
        }
        return super.getCapability(cap, side);
    }
	
	// Cooldown timer container
	private class CoolDownTimer {
		private int cool=-1;
		private long game;
		private final int expire;
		private final Level lvl;
		
		public CoolDownTimer(Level lvl, int expire) {
			this.lvl=lvl;
			this.expire=expire;
			this.game=lvl.getGameTime();
		}
			
		// reset the cool down to configured expire time
		public void reset() {
			this.cool=expire;
		}
		
		// Has the cooldown period ended?
		public boolean ready() {
			return cool <= 0;
		}
		
		// Update the cool down timer once a tick cycle
		public boolean ticked() {
			if (game < lvl.getGameTime()) {
				game = lvl.getGameTime();
				--this.cool;
			}
			return this.cool <= 0;
		}
		
		public int getCool() {
			return cool;
		}

		public void setCool(int cool) {
			this.cool = cool;
		}
	}
	
	// CollectionArea container.
	public class CollectionArea {
		public final Level lvl;
		public final VoxelShape shape;
		public final double X;
		public final double Y;
		public final double Z;
		
		private CollectionArea(Level l, VoxelShape s, BlockPos p) {
			this.lvl=l;
			this.shape=s;
			this.X=p.getX() + 0.5D;
			this.Y=p.getY() + 0.5D;
			this.Z=p.getZ() + 0.5D;
		}
		
		public static CollectionArea createCollectionArea(BaseFlintBlockEntity be, Level l, VoxelShape s, BlockPos p) {
			return be.new CollectionArea(l, s, p);
		}
		
		public double getLevelX() { //.toAabbs().stream()
			return this.X;
		}

		public double getLevelY() {
			return this.Y;
		}

		public double getLevelZ() {
			return this.Z;
		}
		
		public Level getLevel() {
			return lvl;
		}
		
		public VoxelShape getCollectionArea() {
			return this.shape;
		}
	}

}
