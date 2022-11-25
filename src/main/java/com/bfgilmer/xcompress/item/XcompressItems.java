package com.bfgilmer.xcompress.item;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import com.bfgilmer.xcompress.Xcompress;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class XcompressItems {
	public static final List<Supplier<? extends Item>> BLOCK_ENTRIES = new ArrayList<>();
	public static final List<Supplier<? extends Item>> ITEM_ENTRIES = new ArrayList<>();

	@SubscribeEvent
	public void onRegisterItems(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> registry = event.getRegistry();

		BLOCK_ENTRIES.stream().map(Supplier::get).forEach(registry::register);
		ITEM_ENTRIES.stream().map(Supplier::get).forEach(registry::register);
	}

	private static <T extends Item> RegistryObject<T> register(String name, Supplier<? extends Item> item) {
		ResourceLocation loc = new ResourceLocation(Xcompress.MOD_ID, name);
		ITEM_ENTRIES.add(() -> item.get().setRegistryName(loc));

		return RegistryObject.of(loc, ForgeRegistries.ITEMS);
	}

//    @ObjectHolder("compressium:compressor")
//    public static Item COMPRESSOR;
	public static final RegistryObject<CompressorItem> COMPRESSOR = register("compressor",
			() -> new CompressorItem(p -> p.tab(Xcompress.ITEM_GROUP)));
	public static final RegistryObject<CompressorItem> ZINC_INGOT = register("zinc_ingot",
			() -> new Item(new Item.Properties().tab(Xcompress.ITEM_GROUP)));
	public static final RegistryObject<CompressorItem> AL_INGOT = register("aluminum_ingot",
			() -> new Item(new Item.Properties().tab(Xcompress.ITEM_GROUP)));
}
