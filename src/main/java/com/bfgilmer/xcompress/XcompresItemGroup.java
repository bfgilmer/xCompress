package com.bfgilmer.xcompress;

import com.bfgilmer.xcompress.blocks.XcompressBlocks;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class XcompresItemGroup extends CreativeModeTab {

	public XcompresItemGroup() {
		this(Xcompress.MODID);
	}

	public XcompresItemGroup(String label) {
		super(label);
	}

	public XcompresItemGroup(int index, String label) {
		super(index, label);
	}

	@Override
	public ItemStack makeIcon() {
		return new ItemStack(XcompressBlocks.COBBLESTONE_1.get());
	}

}
