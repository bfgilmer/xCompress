package com.bfgilmer.xcompress;

import com.bfgilmer.xcompress.blocks.XcompressBlocks;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class XcompresItemGroup extends ItemGroup {

	public XcompresItemGroup() {
		this(Xcompress.MOD_ID);
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
