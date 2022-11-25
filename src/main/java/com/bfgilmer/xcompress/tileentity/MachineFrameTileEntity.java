package com.bfgilmer.xcompress.tileentity;

import com.bfgilmer.xcompress.inventory.MachineFrameContainer;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.IItemHandler;

public class MachineFrameTileEntity extends LockableLootTileEntity implements IItemHandler, IEnergyStorage, ITickableTileEntity  {

	private NonNullList<ItemStack> items = NonNullList.withSize(2, ItemStack.EMPTY);
	private int cooldownTime;

	public MachineFrameTileEntity() {
		super(XcompressTileEntities.MACHINE_FRAME.get());
		this.items = NonNullList.withSize(2, ItemStack.EMPTY);
	}
	
	@Override
	public void load(BlockState blockState, CompoundNBT nbt) {
		super.load(blockState, nbt);
		if (!this.tryLoadLootTable(nbt)) {
			ItemStackHelper.loadAllItems(nbt, this.items);
		}

		this.cooldownTime = nbt.getInt("TransferCooldown");
	}

	@Override
	public CompoundNBT save(CompoundNBT nbt) {
		super.save(nbt);
		if (!this.trySaveLootTable(nbt)) {
			ItemStackHelper.saveAllItems(nbt, this.items);
		}

		nbt.putInt("TransferCooldown", this.cooldownTime);
		return nbt;
	}

	@Override
	public int getContainerSize() {
		return this.items.size();
	}

	@Override
	protected NonNullList<ItemStack> getItems() {
		return this.items;
	}

	@Override
	protected void setItems(NonNullList<ItemStack> items) {
		this.items = items;
	}

	@Override
	protected ITextComponent getDefaultName() {
		return new TranslationTextComponent("container.xcompress.machine_frame");
	}

	@Override
	protected Container createMenu(int windowId, PlayerInventory player) {
		return MachineFrameContainer.createContainer(windowId, player, this);
	}

	@Override
	public int getSlots() {
		return 2;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return items.get(slot);
	}

	@Override
	public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
		return null;
	}

	@Override
	public ItemStack extractItem(int slot, int amount, boolean simulate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSlotLimit(int slot) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isItemValid(int slot, ItemStack stack) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int receiveEnergy(int maxReceive, boolean simulate) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int extractEnergy(int maxExtract, boolean simulate) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getEnergyStored() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxEnergyStored() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean canExtract() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canReceive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

}
