package com.bfgilmer.xcompress.item;

import static com.bfgilmer.xcompress.Xcompress.MODID;

import com.bfgilmer.xcompress.Xcompress;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class XcompressItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(bus);
    }
    
	public static final RegistryObject<CompressorItem> COMPRESSOR = ITEMS.register("compressor",
			() -> new CompressorItem(p -> p.tab(Xcompress.ITEM_GROUP)));
	public static final RegistryObject<Item> ZINC_INGOT = ITEMS.register("zinc_ingot",
			() -> new Item(new Item.Properties().tab(Xcompress.ITEM_GROUP)));
	public static final RegistryObject<Item> AL_INGOT = ITEMS.register("aluminum_ingot",
			() -> new Item(new Item.Properties().tab(Xcompress.ITEM_GROUP)));
}
