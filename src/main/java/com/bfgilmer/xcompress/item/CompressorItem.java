package com.bfgilmer.xcompress.item;

import java.util.function.Function;

import net.minecraft.world.item.ItemStack;

public class CompressorItem extends BaseItem {
	private final boolean damage;
	private final boolean tooltip;

	public CompressorItem(Function<Properties, Properties> properties) {
		this(true, properties);
	}

	public CompressorItem(boolean tooltip, Function<Properties, Properties> properties) {
		this(0, tooltip, properties);
	}

	public CompressorItem(int uses, Function<Properties, Properties> properties) {
		this(uses, true, properties);
	}

	public CompressorItem(int uses, boolean tooltip, Function<Properties, Properties> properties) {
		super(properties.compose(p -> p.defaultDurability(Math.max(uses - 1, 0)).setNoRepair()));
		this.damage = uses > 0;
		this.tooltip = tooltip;
	}

	public boolean isDamage() {
		return damage;
	}

	public boolean isTooltip() {
		return tooltip;
	}
	
	@Override
	public boolean hasContainerItem(ItemStack stack) {
		return true;
	}
	
	@Override
	public ItemStack getContainerItem(ItemStack stack) {
		ItemStack copy = stack.copy();
		copy.setCount(1);
		return copy;
	}
}
