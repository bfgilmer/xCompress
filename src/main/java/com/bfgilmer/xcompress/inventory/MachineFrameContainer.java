package com.bfgilmer.xcompress.inventory;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;

public class MachineFrameContainer extends Container {

	private static final int NumSlots=2;
	private final IInventory machine;

   public static MachineFrameContainer createContainer(int windowId, PlayerInventory playerInventory) {
	    return new MachineFrameContainer(XcompressContainerTypes.MACHINE_FRAME.get(), windowId, playerInventory);
   }
   
   public static MachineFrameContainer createContainer(int windowId, PlayerInventory playerInventory, IInventory inventory) {
	    return new MachineFrameContainer(XcompressContainerTypes.MACHINE_FRAME.get(), windowId, playerInventory, inventory);
  }
   
   public MachineFrameContainer(ContainerType<MachineFrameContainer> containerType, int windowId,
			PlayerInventory playerInventory) {
		this(containerType, windowId, playerInventory, new Inventory(NumSlots));
	}
 
	public MachineFrameContainer(ContainerType<?> containerType, int windowId, PlayerInventory playerInventory,
			IInventory inventory) {
		super(containerType, windowId);
		checkContainerSize(inventory, NumSlots);
		
		this.machine = inventory;

		machine.startOpen(playerInventory.player);

		this.addSlot(new Slot(this.machine, 0, 44, 35));
		this.addSlot(new Slot(this.machine, 1, 116, 35));

		int leftCol = 8; // (machineType.xSize - 162) / 2 + 1;

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


	@Override
	public boolean stillValid(PlayerEntity player) {
		return this.machine.stillValid(player);
	}

}
