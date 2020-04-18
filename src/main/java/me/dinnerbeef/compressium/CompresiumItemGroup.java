package me.dinnerbeef.compressium;

import me.dinnerbeef.compressium.blocks.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class CompresiumItemGroup extends ItemGroup {

	public CompresiumItemGroup() {
		this(Compressium.MOD_ID);	
	}
	
	public CompresiumItemGroup(String label) {
		super(label);
	}

	public CompresiumItemGroup(int index, String label) {
		super(index, label);
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(ModBlocks.COBBLESTONE_1.get());
	}

}
