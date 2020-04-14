package me.dinnerbeef.compressium.item;

import me.dinnerbeef.compressium.Compressium;
import net.minecraft.item.Item;
import net.minecraftforge.registries.ObjectHolder;

public class ModItems {
    @ObjectHolder("compressium:compressor")
    public static Item COMPRESSOR_1;
  
    public static Item COMPRESSOR_2 = new Item(new Item.Properties().group(Compressium.creativeTab)).setRegistryName("compressor");
}
