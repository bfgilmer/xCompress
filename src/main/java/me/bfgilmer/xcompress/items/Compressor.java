package me.bfgilmer.xcompress.items;

import java.util.function.Function;

import com.blakebr0.cucumber.item.ReusableItem;

import net.minecraft.item.ItemStack;

public class Compressor extends ReusableItem {

	public Compressor(Function<Properties, Properties> properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		return true;
	}
}
