package me.dinnerbeef.compressium.item;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import com.blakebr0.cucumber.item.BaseItem;
import me.dinnerbeef.compressium.Compressium;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems {
    public static final List<Supplier<? extends Item>> ENTRIES = new ArrayList<>();
	
    @SubscribeEvent
    public void onRegisterItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();

        ENTRIES.stream().map(Supplier::get).forEach(registry::register);
    }

    private static <T extends Item> RegistryObject<T> register(String name) {
        return register(name, () -> new BaseItem(p -> p.group(Compressium.ITEM_GROUP)));
    }

    private static <T extends Item> RegistryObject<T> register(String name, Supplier<? extends Item> item) {
        ResourceLocation loc = new ResourceLocation(Compressium.MOD_ID, name);
        ENTRIES.add(() -> item.get().setRegistryName(loc));
        return RegistryObject.of(loc, ForgeRegistries.ITEMS);
    }
    
//    @ObjectHolder("compressium:compressor")
//    public static Item COMPRESSOR;

    public static final RegistryObject<CompressorItem> COMPRESSOR = register("compressor", () -> new CompressorItem(p -> p.group(Compressium.ITEM_GROUP)));
}
