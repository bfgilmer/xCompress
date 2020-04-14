package me.dinnerbeef.compressium;


import me.dinnerbeef.compressium.blocks.*;
import me.dinnerbeef.compressium.item.CompressorItem;
import me.dinnerbeef.compressium.item.ModItems;
import me.dinnerbeef.compressium.item.ReusableItem;
import me.dinnerbeef.compressium.setup.ClientProxy;
import me.dinnerbeef.compressium.setup.IProxy;
import me.dinnerbeef.compressium.setup.ServerProxy;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static com.blakebr0.mysticalagriculture.MysticalAgriculture.ITEM_GROUP;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.blakebr0.mysticalagriculture.item.MasterInfusionCrystalItem;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("compressium")
public class Compressium {

    public static final String MOD_ID = "compressium";
    public static IProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> ServerProxy::new);

    public static final Logger LOGGER = LogManager.getLogger();

    public Compressium() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientsetup);
    }
    

    private void clientsetup(final FMLClientSetupEvent event) {   	
        RenderTypeLookup.setRenderLayer(ModBlocks.COBBLESTONE_1, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.COBBLESTONE_2, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.COBBLESTONE_3, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.COBBLESTONE_4, RenderType.cutout());

        RenderTypeLookup.setRenderLayer(ModBlocks.NETHERRACK_1, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.NETHERRACK_2, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.NETHERRACK_3, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.NETHERRACK_4, RenderType.cutout());

        RenderTypeLookup.setRenderLayer(ModBlocks.SAND_1, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SAND_2, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SAND_3, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SAND_4, RenderType.cutout());

        RenderTypeLookup.setRenderLayer(ModBlocks.SOULSAND_1, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SOULSAND_2, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SOULSAND_3, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SOULSAND_4, RenderType.cutout());
        
        RenderTypeLookup.setRenderLayer(ModBlocks.SNOW_1, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SNOW_2, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SNOW_3, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SNOW_4, RenderType.cutout());

        RenderTypeLookup.setRenderLayer(ModBlocks.CLAY_1, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.CLAY_2, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.CLAY_3, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.CLAY_4, RenderType.cutout());

        RenderTypeLookup.setRenderLayer(ModBlocks.GRAVEL_1, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.GRAVEL_2, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.GRAVEL_3, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.GRAVEL_4, RenderType.cutout());

        RenderTypeLookup.setRenderLayer(ModBlocks.DIRT_1, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.DIRT_2, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.DIRT_3, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.DIRT_4, RenderType.cutout());
        
        RenderTypeLookup.setRenderLayer(ModBlocks.STONE_1, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.STONE_2, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.STONE_3, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.STONE_4, RenderType.cutout());
        
        RenderTypeLookup.setRenderLayer(ModBlocks.IRON_1, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.IRON_2, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.IRON_3, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.IRON_4, RenderType.cutout());
    }

    private void setup(final FMLCommonSetupEvent event) {
    
    }


    public static final ItemGroup creativeTab = new ItemGroup(MOD_ID + ".compressium") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.COBBLESTONE_1);
        }
    };

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)


    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            for(int x = 1; x < 5; x++) {
            	// Primary drops that clog inventory
                event.getRegistry().register(new Cobblestone(x));
                event.getRegistry().register(new Sand(x));
                event.getRegistry().register(new Gravel(x));
                event.getRegistry().register(new Dirt(x)); 

                // Nether
                event.getRegistry().register(new Netherrack(x));
                event.getRegistry().register(new Soulsand(x));
                
                // result of smelting 
                event.getRegistry().register(new Stone(x));

                event.getRegistry().register(new Snow(x));
                event.getRegistry().register(new Clay(x));
                event.getRegistry().register(new Iron(x));
            }
        }


    @SubscribeEvent
    public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
    	//event.getRegistry().register(new CompressorItem(new Item.Properties().group(Compressium.creativeTab)).setRegistryName("compressor"));
    	event.getRegistry().register(new CompressorItem(p -> p.group(Compressium.creativeTab)));
        
        event.getRegistry().register(new BlockItem(ModBlocks.COBBLESTONE_1, new Item.Properties().group(Compressium.creativeTab)).setRegistryName("cobblestone_1"));
        event.getRegistry().register(new BlockItem(ModBlocks.COBBLESTONE_2, new Item.Properties().group(Compressium.creativeTab)).setRegistryName("cobblestone_2"));
        event.getRegistry().register(new BlockItem(ModBlocks.COBBLESTONE_3, new Item.Properties().group(Compressium.creativeTab)).setRegistryName("cobblestone_3"));
        event.getRegistry().register(new BlockItem(ModBlocks.COBBLESTONE_4, new Item.Properties().group(Compressium.creativeTab)).setRegistryName("cobblestone_4"));
        
        event.getRegistry().register(new BlockItem(ModBlocks.NETHERRACK_1, new Item.Properties().group(Compressium.creativeTab)).setRegistryName("netherrack_1"));
        event.getRegistry().register(new BlockItem(ModBlocks.NETHERRACK_2, new Item.Properties().group(Compressium.creativeTab)).setRegistryName("netherrack_2"));
        event.getRegistry().register(new BlockItem(ModBlocks.NETHERRACK_3, new Item.Properties().group(Compressium.creativeTab)).setRegistryName("netherrack_3"));
        event.getRegistry().register(new BlockItem(ModBlocks.NETHERRACK_4, new Item.Properties().group(Compressium.creativeTab)).setRegistryName("netherrack_4"));

        event.getRegistry().register(new BlockItem(ModBlocks.SAND_1, new Item.Properties().group(Compressium.creativeTab)).setRegistryName("sand_1"));
        event.getRegistry().register(new BlockItem(ModBlocks.SAND_2, new Item.Properties().group(Compressium.creativeTab)).setRegistryName("sand_2"));
        event.getRegistry().register(new BlockItem(ModBlocks.SAND_3, new Item.Properties().group(Compressium.creativeTab)).setRegistryName("sand_3"));
        event.getRegistry().register(new BlockItem(ModBlocks.SAND_4, new Item.Properties().group(Compressium.creativeTab)).setRegistryName("sand_4"));

        event.getRegistry().register(new BlockItem(ModBlocks.SOULSAND_1, new Item.Properties().group(Compressium.creativeTab)).setRegistryName("soulsand_1"));
        event.getRegistry().register(new BlockItem(ModBlocks.SOULSAND_2, new Item.Properties().group(Compressium.creativeTab)).setRegistryName("soulsand_2"));
        event.getRegistry().register(new BlockItem(ModBlocks.SOULSAND_3, new Item.Properties().group(Compressium.creativeTab)).setRegistryName("soulsand_3"));
        event.getRegistry().register(new BlockItem(ModBlocks.SOULSAND_4, new Item.Properties().group(Compressium.creativeTab)).setRegistryName("soulsand_4"));

        event.getRegistry().register(new BlockItem(ModBlocks.SNOW_1, new Item.Properties().group(Compressium.creativeTab)).setRegistryName("snow_1"));
        event.getRegistry().register(new BlockItem(ModBlocks.SNOW_2, new Item.Properties().group(Compressium.creativeTab)).setRegistryName("snow_2"));
        event.getRegistry().register(new BlockItem(ModBlocks.SNOW_3, new Item.Properties().group(Compressium.creativeTab)).setRegistryName("snow_3"));
        event.getRegistry().register(new BlockItem(ModBlocks.SNOW_4, new Item.Properties().group(Compressium.creativeTab)).setRegistryName("snow_4"));

        event.getRegistry().register(new BlockItem(ModBlocks.CLAY_1, new Item.Properties().group(Compressium.creativeTab)).setRegistryName("clay_1"));
        event.getRegistry().register(new BlockItem(ModBlocks.CLAY_2, new Item.Properties().group(Compressium.creativeTab)).setRegistryName("clay_2"));
        event.getRegistry().register(new BlockItem(ModBlocks.CLAY_3, new Item.Properties().group(Compressium.creativeTab)).setRegistryName("clay_3"));
        event.getRegistry().register(new BlockItem(ModBlocks.CLAY_4, new Item.Properties().group(Compressium.creativeTab)).setRegistryName("clay_4"));

        event.getRegistry().register(new BlockItem(ModBlocks.GRAVEL_1, new Item.Properties().group(Compressium.creativeTab)).setRegistryName("gravel_1"));
        event.getRegistry().register(new BlockItem(ModBlocks.GRAVEL_2, new Item.Properties().group(Compressium.creativeTab)).setRegistryName("gravel_2"));
        event.getRegistry().register(new BlockItem(ModBlocks.GRAVEL_3, new Item.Properties().group(Compressium.creativeTab)).setRegistryName("gravel_3"));
        event.getRegistry().register(new BlockItem(ModBlocks.GRAVEL_4, new Item.Properties().group(Compressium.creativeTab)).setRegistryName("gravel_4"));

        event.getRegistry().register(new BlockItem(ModBlocks.DIRT_1, new Item.Properties().group(Compressium.creativeTab)).setRegistryName("dirt_1"));
        event.getRegistry().register(new BlockItem(ModBlocks.DIRT_2, new Item.Properties().group(Compressium.creativeTab)).setRegistryName("dirt_2"));
        event.getRegistry().register(new BlockItem(ModBlocks.DIRT_3, new Item.Properties().group(Compressium.creativeTab)).setRegistryName("dirt_3"));
        event.getRegistry().register(new BlockItem(ModBlocks.DIRT_4, new Item.Properties().group(Compressium.creativeTab)).setRegistryName("dirt_4"));

        event.getRegistry().register(new BlockItem(ModBlocks.STONE_1, new Item.Properties().group(Compressium.creativeTab)).setRegistryName("stone_1"));
        event.getRegistry().register(new BlockItem(ModBlocks.STONE_2, new Item.Properties().group(Compressium.creativeTab)).setRegistryName("stone_2"));
        event.getRegistry().register(new BlockItem(ModBlocks.STONE_3, new Item.Properties().group(Compressium.creativeTab)).setRegistryName("stone_3"));
        event.getRegistry().register(new BlockItem(ModBlocks.STONE_4, new Item.Properties().group(Compressium.creativeTab)).setRegistryName("stone_4"));

        event.getRegistry().register(new BlockItem(ModBlocks.IRON_1, new Item.Properties().group(Compressium.creativeTab)).setRegistryName("iron_1"));
        event.getRegistry().register(new BlockItem(ModBlocks.IRON_2, new Item.Properties().group(Compressium.creativeTab)).setRegistryName("iron_2"));
        event.getRegistry().register(new BlockItem(ModBlocks.IRON_3, new Item.Properties().group(Compressium.creativeTab)).setRegistryName("iron_3"));
        event.getRegistry().register(new BlockItem(ModBlocks.IRON_4, new Item.Properties().group(Compressium.creativeTab)).setRegistryName("iron_4"));
        }
    }

}
