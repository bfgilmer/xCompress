package com.bfgilmer.xcompress.inventory;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;


public class FlintContainer extends Container {

	   private final IInventory hopper;
	   private final FlintTypes hopperType;
	   
	   public static FlintContainer createFlintWoodContainer(int windowId, PlayerInventory playerInventory) {
		    return new FlintContainer(XcompressContainerTypes.FLINT_CONTAINER_1.get(), windowId, playerInventory, FlintTypes.createFlintType(1));
	   }
	   public static FlintContainer createFlintStoneContainer(int windowId, PlayerInventory playerInventory) {
		    return new FlintContainer(XcompressContainerTypes.FLINT_CONTAINER_2.get(), windowId, playerInventory, FlintTypes.createFlintType(2));
	   }
	   public static FlintContainer createFlintIronContainer(int windowId, PlayerInventory playerInventory) {
		    return new FlintContainer(XcompressContainerTypes.FLINT_CONTAINER_3.get(), windowId, playerInventory, FlintTypes.createFlintType(3));
	   }
	   public static FlintContainer createFlintDiamondContainer(int windowId, PlayerInventory playerInventory) {
		    return new FlintContainer(XcompressContainerTypes.FLINT_CONTAINER_4.get(), windowId, playerInventory, FlintTypes.createFlintType(4));
	   }
	   
	   public static FlintContainer createFlintWoodContainer(int windowId, PlayerInventory playerInventory, IInventory inventory) {
		    return new FlintContainer(XcompressContainerTypes.FLINT_CONTAINER_1.get(), windowId, playerInventory, inventory, FlintTypes.createFlintType(1));
	   }
	   public static FlintContainer createFlintStoneContainer(int windowId, PlayerInventory playerInventory, IInventory inventory) {
		    return new FlintContainer(XcompressContainerTypes.FLINT_CONTAINER_2.get(), windowId, playerInventory, inventory, FlintTypes.createFlintType(2));
	   }
	   public static FlintContainer createFlintIronContainer(int windowId, PlayerInventory playerInventory, IInventory inventory) {
		    return new FlintContainer(XcompressContainerTypes.FLINT_CONTAINER_3.get(), windowId, playerInventory, inventory, FlintTypes.createFlintType(3));
	   }
	   public static FlintContainer createFlintDiamondContainer(int windowId, PlayerInventory playerInventory, IInventory inventory) {
		    return new FlintContainer(XcompressContainerTypes.FLINT_CONTAINER_4.get(), windowId, playerInventory, inventory, FlintTypes.createFlintType(4));
	   }

	   public FlintContainer(ContainerType<?> containerType, int windowId, PlayerInventory playerInventory, FlintTypes fType) {
		    this(containerType, windowId, playerInventory, new Inventory(fType.getSlots()), fType);
	   }
	   
		public FlintContainer(ContainerType<?> containerType, int windowId, PlayerInventory playerInventory,
				IInventory inventory, FlintTypes hopperType) {
			super(containerType, windowId);
			checkContainerSize(inventory, hopperType.getSlots());
			
			this.hopper = inventory;
			this.hopperType = hopperType;

			hopper.startOpen(playerInventory.player);

			int xoffset = 8 + 9 * (9 - hopperType.getColumns());

			for (int hopperSlot = 0; hopperSlot < hopperType.getSlots(); hopperSlot++) {
				int x = xoffset + hopperSlot * 18;
				int y = 35;

				this.addSlot(new Slot(this.hopper, hopperSlot, x, y));
			}

			int leftCol = 8; // (hopperType.xSize - 162) / 2 + 1;

			for (int playerInvRow = 0; playerInvRow < 3; playerInvRow++) {
				for (int playerInvCol = 0; playerInvCol < 9; playerInvCol++) {
					this.addSlot(new Slot(playerInventory, playerInvCol + playerInvRow * 9 + 9,
							leftCol + playerInvCol * 18, hopperType.ySize - (4 - playerInvRow) * 18 - 1));
				}
			}

			for (int hotbarSlot = 0; hotbarSlot < 9; hotbarSlot++) {
				this.addSlot(new Slot(playerInventory, hotbarSlot, leftCol + hotbarSlot * 18, 123));
			}
		}

	   
	   public boolean stillValid(PlayerEntity player) {
	      return this.hopper.stillValid(player);
	   }

	   public ItemStack quickMoveStack(PlayerEntity player, int theSlot) {
	      ItemStack itemstack = ItemStack.EMPTY;
	      Slot slot = this.slots.get(theSlot);
	      if (slot != null && slot.hasItem()) {
	         ItemStack itemstack1 = slot.getItem();
	         itemstack = itemstack1.copy();
	         if (theSlot < this.hopper.getContainerSize()) {
	            if (!this.moveItemStackTo(itemstack1, this.hopper.getContainerSize(), this.slots.size(), true)) {
	               return ItemStack.EMPTY;
	            }
	         } else if (!this.moveItemStackTo(itemstack1, 0, this.hopper.getContainerSize(), false)) {
	            return ItemStack.EMPTY;
	         }

	         if (itemstack1.isEmpty()) {
	            slot.set(ItemStack.EMPTY);
	         } else {
	            slot.setChanged();
	         }
	      }

	      return itemstack;
	   }

	   public void removed(PlayerEntity player) {
	      super.removed(player);
	      this.hopper.stopOpen(player);
	   }


	public FlintTypes getHopperType() {
		return hopperType;
	}
}
