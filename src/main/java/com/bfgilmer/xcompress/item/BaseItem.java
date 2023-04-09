package com.bfgilmer.xcompress.item;

import java.util.function.Function;

import net.minecraft.world.item.Item;

public class BaseItem extends Item {
	public BaseItem(Function<Properties, Properties> properties) {
		super(properties.apply(new Properties()));
	}
}