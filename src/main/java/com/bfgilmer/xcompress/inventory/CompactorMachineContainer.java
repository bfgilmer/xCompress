package com.bfgilmer.xcompress.inventory;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;


public class CompactorMachineContainer extends Container {

	   private final IInventory hopper;
	   private final static int NumSlots=2;
	   
	   public static CompactorMachineContainer createContainer(int windowId, PlayerInventory playerInventory) {
		    return new CompactorMachineContainer(XcompressContainerTypes.COMPACTOR_CONTAINER.get(), windowId, playerInventory);
	   }
	   
	   public static CompactorMachineContainer createContainer(int windowId, PlayerInventory playerInventory, IInventory inventory) {
		    return new CompactorMachineContainer(XcompressContainerTypes.COMPACTOR_CONTAINER.get(), windowId, playerInventory, inventory);
	   }

	   public CompactorMachineContainer(ContainerType<?> containerType, int windowId, PlayerInventory playerInventory) {
		    this(containerType, windowId, playerInventory, new Inventory(NumSlots));
	   }
	   
		public CompactorMachineContainer(ContainerType<?> containerType, int windowId, PlayerInventory playerInventory,
				IInventory inventory) {
			super(containerType, windowId);
			checkContainerSize(inventory, NumSlots);
			
			this.hopper = inventory;

			hopper.startOpen(playerInventory.player);

			this.addSlot(new Slot(this.hopper, 0, 44, 35));
			this.addSlot(new Slot(this.hopper, 1, 116, 35));

			int leftCol = 8; // (hopperType.xSize - 162) / 2 + 1;

			for (int playerInvRow = 0; playerInvRow < 3; playerInvRow++) {
				for (int playerInvCol = 0; playerInvCol < 9; playerInvCol++) {
					this.addSlot(new Slot(playerInventory, playerInvCol + playerInvRow * 9 + 9,
							leftCol + playerInvCol * 18, 138 - (4 - playerInvRow) * 18 - 1));
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
}
