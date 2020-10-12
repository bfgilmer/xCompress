package com.bfgilmer.xcompress.item;

import java.util.function.Function;

import com.blakebr0.cucumber.item.ReusableItem;

import net.minecraft.item.ItemStack;


public class CompressorItem extends ReusableItem {
    public CompressorItem(Function<Properties, Properties> properties) {
        super(properties);
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}
