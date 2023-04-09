package com.bfgilmer.xcompress.inventory;

import com.bfgilmer.xcompress.blocks.XcompressBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

public class FlintContainer extends AbstractContainerMenu {
	private final FlintTypes hopperType;

	private BlockEntity blockEntity;
	private Player playerEntity;
	private IItemHandler playerInventory;

	public FlintContainer(MenuType<?> menuType, int windowId, BlockPos pos, Inventory playerInventory, Player player,
			FlintTypes hopperType) {
		super(menuType, windowId);

		this.hopperType = hopperType;

		blockEntity = player.getCommandSenderWorld().getBlockEntity(pos);
		this.playerEntity = player;
		this.playerInventory = new InvWrapper(playerInventory);

		if (blockEntity != null) {
			blockEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(h -> {
				addSlot(new SlotItemHandler(h, 0, 64, 24));
			});
		}
		layoutPlayerInventorySlots(10, 70);
	}

	public static FlintContainer create(int windowId, BlockPos pos, Inventory playerInventory, Player player, int level) {
		switch (FlintTypes.getLevel(level)) {
		case 1 :
			return new FlintContainer(XcompressContainers.FLINT_CONTAINER_1.get(), windowId, pos, playerInventory, player, FlintTypes.createFlintType(level));
			
		case 2 :
			return new FlintContainer(XcompressContainers.FLINT_CONTAINER_2.get(), windowId, pos, playerInventory, player, FlintTypes.createFlintType(level));
			
		case 3 :
			return new FlintContainer(XcompressContainers.FLINT_CONTAINER_3.get(), windowId, pos, playerInventory, player, FlintTypes.createFlintType(level));
			
		case 4 :
			return new FlintContainer(XcompressContainers.FLINT_CONTAINER_4.get(), windowId, pos, playerInventory, player, FlintTypes.createFlintType(level));
		}
		
	   return null;	
	}
	
	/*
	 * public FlintContainer(MenuType<?> containerType, int windowId, Inventory
	 * playerInventory, Container inventory, FlintTypes hopperType) {
	 * super(containerType, windowId); checkContainerSize(inventory,
	 * hopperType.getSlots());
	 * 
	 * this.hopper = inventory; this.hopperType = hopperType;
	 * 
	 * hopper.startOpen(playerInventory.player);
	 * 
	 * int xoffset = 8 + 9 * (9 - hopperType.getColumns());
	 * 
	 * for (int hopperSlot = 0; hopperSlot < hopperType.getSlots(); hopperSlot++) {
	 * int x = xoffset + hopperSlot * 18; int y = 35;
	 * 
	 * this.addSlot(new Slot(this.hopper, hopperSlot, x, y)); }
	 * 
	 * int leftCol = 8; // (hopperType.xSize - 162) / 2 + 1;
	 * 
	 * for (int playerInvRow = 0; playerInvRow < 3; playerInvRow++) { for (int
	 * playerInvCol = 0; playerInvCol < 9; playerInvCol++) { this.addSlot(new
	 * Slot(playerInventory, playerInvCol + playerInvRow * 9 + 9, leftCol +
	 * playerInvCol * 18, hopperType.ySize - (4 - playerInvRow) * 18 - 1)); } }
	 * 
	 * for (int hotbarSlot = 0; hotbarSlot < 9; hotbarSlot++) { this.addSlot(new
	 * Slot(playerInventory, hotbarSlot, leftCol + hotbarSlot * 18, 123)); } }
	 */

	@Override
	public ItemStack quickMoveStack(Player playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.slots.get(index);
		if (slot != null && slot.hasItem()) {
			ItemStack stack = slot.getItem();
			itemstack = stack.copy();
			if (index == 0) {
				if (!this.moveItemStackTo(stack, 1, 37, true)) {
					return ItemStack.EMPTY;
				}
				slot.onQuickCraft(stack, itemstack);
			} else {
				if (ForgeHooks.getBurnTime(stack, RecipeType.SMELTING) > 0) {
					if (!this.moveItemStackTo(stack, 0, 1, false)) {
						return ItemStack.EMPTY;
					}
				} else if (index < 28) {
					if (!this.moveItemStackTo(stack, 28, 37, false)) {
						return ItemStack.EMPTY;
					}
				} else if (index < 37 && !this.moveItemStackTo(stack, 1, 28, false)) {
					return ItemStack.EMPTY;
				}
			}

			if (stack.isEmpty()) {
				slot.set(ItemStack.EMPTY);
			} else {
				slot.setChanged();
			}

			if (stack.getCount() == itemstack.getCount()) {
				return ItemStack.EMPTY;
			}

			slot.onTake(playerIn, stack);
		}

		return itemstack;
	}

	private int addSlotRange(IItemHandler handler, int index, int x, int y, int amount, int dx) {
		for (int i = 0; i < amount; i++) {
			addSlot(new SlotItemHandler(handler, index, x, y));
			x += dx;
			index++;
		}
		return index;
	}

	private int addSlotBox(IItemHandler handler, int index, int x, int y, int horAmount, int dx, int verAmount,
			int dy) {
		for (int j = 0; j < verAmount; j++) {
			index = addSlotRange(handler, index, x, y, horAmount, dx);
			y += dy;
		}
		return index;
	}

	private void layoutPlayerInventorySlots(int leftCol, int topRow) {
		// Player inventory
		addSlotBox(playerInventory, 9, leftCol, topRow, 9, 18, 3, 18);

		// Hotbar
		topRow += 58;
		addSlotRange(playerInventory, 0, leftCol, topRow, 9, 18);
	}

	public FlintTypes getHopperType() {
		return hopperType;
	}

	@Override
	public boolean stillValid(Player playerIn) {
		return stillValid(ContainerLevelAccess.create(blockEntity.getLevel(), blockEntity.getBlockPos()), playerEntity,
				XcompressBlocks.FLINT_1.get());
	}
}
