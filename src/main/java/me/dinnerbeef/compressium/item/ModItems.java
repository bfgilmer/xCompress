package me.dinnerbeef.compressium.item;

import static com.blakebr0.mysticalagriculture.MysticalAgriculture.ITEM_GROUP;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import com.blakebr0.cucumber.item.BaseItem;
import com.blakebr0.mysticalagriculture.MysticalAgriculture;
import com.blakebr0.mysticalagriculture.registry.AugmentRegistry;
import com.blakebr0.mysticalagriculture.registry.CropRegistry;

import me.dinnerbeef.compressium.Compressium;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

public class ModItems {
    @ObjectHolder("compressium:compressor")
    public static Item COMPRESSOR_1;
  
    public static Item COMPRESSOR_2 = new Item(Properties().group(Compressium.creativeTab)).setRegistryName("compressor"));
}
