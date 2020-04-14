package me.dinnerbeef.compressium.item;

import java.util.function.Function;

import net.minecraft.item.Item;

public class BaseItem extends Item {
	public BaseItem(Function<Properties, Properties> properties) {
		super(properties.apply(new Properties()));
	}
}