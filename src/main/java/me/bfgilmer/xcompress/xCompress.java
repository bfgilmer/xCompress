package me.bfgilmer.xcompress;

import me.bfgilmer.xcompress.blocks.Clay;
import me.bfgilmer.xcompress.blocks.Cobblestone;
import me.bfgilmer.xcompress.blocks.Diamond;
import me.bfgilmer.xcompress.blocks.Emerald;
import me.bfgilmer.xcompress.blocks.Gold;
import me.bfgilmer.xcompress.blocks.Gravel;
import me.bfgilmer.xcompress.blocks.Iron;
import me.bfgilmer.xcompress.blocks.ModBlocks;
import me.bfgilmer.xcompress.blocks.Netherrack;
import me.bfgilmer.xcompress.blocks.Sand;
import me.bfgilmer.xcompress.blocks.Snow;
import me.bfgilmer.xcompress.blocks.Soulsand;
import me.bfgilmer.xcompress.blocks.Stone;
import me.bfgilmer.xcompress.setup.IProxy;
import me.bfgilmer.xcompress.setup.ClientProxy;
import me.bfgilmer.xcompress.setup.ServerProxy;

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
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("xCompress")
public class xCompress {

    public static final String MOD_ID = "xCompress";
    public static IProxy proxy =  DistExecutor.runForDist(() -> ClientProxy::new, () -> ServerProxy::new);

    public static final Logger LOGGER = LogManager.getLogger();

    public xCompress() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientsetup);


    }

    private void clientsetup(final FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(ModBlocks.SOULSAND_1, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SOULSAND_2, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SOULSAND_3, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SOULSAND_4, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SOULSAND_5, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SOULSAND_6, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SOULSAND_7, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SOULSAND_8, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SOULSAND_9, RenderType.cutout());

        RenderTypeLookup.setRenderLayer(ModBlocks.SNOW_1, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SNOW_2, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SNOW_3, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SNOW_4, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SNOW_5, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SNOW_6, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SNOW_7, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SNOW_8, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SNOW_9, RenderType.cutout());

        RenderTypeLookup.setRenderLayer(ModBlocks.NETHERRACK_1, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.NETHERRACK_2, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.NETHERRACK_3, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.NETHERRACK_4, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.NETHERRACK_5, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.NETHERRACK_6, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.NETHERRACK_7, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.NETHERRACK_8, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.NETHERRACK_9, RenderType.cutout());

        RenderTypeLookup.setRenderLayer(ModBlocks.CLAY_1, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.CLAY_2, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.CLAY_3, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.CLAY_4, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.CLAY_5, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.CLAY_6, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.CLAY_7, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.CLAY_8, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.CLAY_9, RenderType.cutout());

        RenderTypeLookup.setRenderLayer(ModBlocks.COBBLESTONE_1, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.COBBLESTONE_2, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.COBBLESTONE_3, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.COBBLESTONE_4, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.COBBLESTONE_5, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.COBBLESTONE_6, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.COBBLESTONE_7, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.COBBLESTONE_8, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.COBBLESTONE_9, RenderType.cutout());

        RenderTypeLookup.setRenderLayer(ModBlocks.SAND_1, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SAND_2, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SAND_3, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SAND_4, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SAND_5, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SAND_6, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SAND_7, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SAND_8, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SAND_9, RenderType.cutout());

        RenderTypeLookup.setRenderLayer(ModBlocks.GRAVEL_1, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.GRAVEL_2, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.GRAVEL_3, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.GRAVEL_4, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.GRAVEL_5, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.GRAVEL_6, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.GRAVEL_7, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.GRAVEL_8, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.GRAVEL_9, RenderType.cutout());

        RenderTypeLookup.setRenderLayer(ModBlocks.STONE_1, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.STONE_2, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.STONE_3, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.STONE_4, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.STONE_5, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.STONE_6, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.STONE_7, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.STONE_8, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.STONE_9, RenderType.cutout());

        RenderTypeLookup.setRenderLayer(ModBlocks.IRON_1, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.IRON_2, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.IRON_3, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.IRON_4, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.IRON_5, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.IRON_6, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.IRON_7, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.IRON_8, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.IRON_9, RenderType.cutout());

        RenderTypeLookup.setRenderLayer(ModBlocks.GOLD_1, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.GOLD_2, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.GOLD_3, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.GOLD_4, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.GOLD_5, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.GOLD_6, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.GOLD_7, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.GOLD_8, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.GOLD_9, RenderType.cutout());

        RenderTypeLookup.setRenderLayer(ModBlocks.DIAMOND_1, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.DIAMOND_2, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.DIAMOND_3, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.DIAMOND_4, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.DIAMOND_5, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.DIAMOND_6, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.DIAMOND_7, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.DIAMOND_8, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.DIAMOND_9, RenderType.cutout());

        RenderTypeLookup.setRenderLayer(ModBlocks.EMERALD_1, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.EMERALD_2, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.EMERALD_3, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.EMERALD_4, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.EMERALD_5, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.EMERALD_6, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.EMERALD_7, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.EMERALD_8, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.EMERALD_9, RenderType.cutout());
    }

    private void setup(final FMLCommonSetupEvent event) {

      
    }


    public static final ItemGroup creativeTab = new ItemGroup(MOD_ID + ".xcompress") {
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
            for(int x = 1; x < 10; x++) {
                event.getRegistry().register(new Soulsand(x));
                event.getRegistry().register(new Snow(x));
                event.getRegistry().register(new Netherrack(x));
                event.getRegistry().register(new Clay(x));
                event.getRegistry().register(new Cobblestone(x));
                event.getRegistry().register(new Sand(x));
                event.getRegistry().register(new Gravel(x));
                event.getRegistry().register(new Stone(x));
                event.getRegistry().register(new Iron(x));
                event.getRegistry().register(new Gold(x));
                event.getRegistry().register(new Diamond(x));
                event.getRegistry().register(new Emerald(x));
            }
        }


    @SubscribeEvent
    public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {

        event.getRegistry().register(new BlockItem(ModBlocks.SOULSAND_1, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("soulsand_1"));
        event.getRegistry().register(new BlockItem(ModBlocks.SOULSAND_2, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("soulsand_2"));
        event.getRegistry().register(new BlockItem(ModBlocks.SOULSAND_3, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("soulsand_3"));
        event.getRegistry().register(new BlockItem(ModBlocks.SOULSAND_4, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("soulsand_4"));
        event.getRegistry().register(new BlockItem(ModBlocks.SOULSAND_5, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("soulsand_5"));
        event.getRegistry().register(new BlockItem(ModBlocks.SOULSAND_6, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("soulsand_6"));
        event.getRegistry().register(new BlockItem(ModBlocks.SOULSAND_7, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("soulsand_7"));
        event.getRegistry().register(new BlockItem(ModBlocks.SOULSAND_8, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("soulsand_8"));
        event.getRegistry().register(new BlockItem(ModBlocks.SOULSAND_9, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("soulsand_9"));

        event.getRegistry().register(new BlockItem(ModBlocks.SNOW_1, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("snow_1"));
        event.getRegistry().register(new BlockItem(ModBlocks.SNOW_2, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("snow_2"));
        event.getRegistry().register(new BlockItem(ModBlocks.SNOW_3, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("snow_3"));
        event.getRegistry().register(new BlockItem(ModBlocks.SNOW_4, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("snow_4"));
        event.getRegistry().register(new BlockItem(ModBlocks.SNOW_5, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("snow_5"));
        event.getRegistry().register(new BlockItem(ModBlocks.SNOW_6, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("snow_6"));
        event.getRegistry().register(new BlockItem(ModBlocks.SNOW_7, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("snow_7"));
        event.getRegistry().register(new BlockItem(ModBlocks.SNOW_8, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("snow_8"));
        event.getRegistry().register(new BlockItem(ModBlocks.SNOW_9, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("snow_9"));

        event.getRegistry().register(new BlockItem(ModBlocks.NETHERRACK_1, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("netherrack_1"));
        event.getRegistry().register(new BlockItem(ModBlocks.NETHERRACK_2, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("netherrack_2"));
        event.getRegistry().register(new BlockItem(ModBlocks.NETHERRACK_3, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("netherrack_3"));
        event.getRegistry().register(new BlockItem(ModBlocks.NETHERRACK_4, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("netherrack_4"));
        event.getRegistry().register(new BlockItem(ModBlocks.NETHERRACK_5, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("netherrack_5"));
        event.getRegistry().register(new BlockItem(ModBlocks.NETHERRACK_6, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("netherrack_6"));
        event.getRegistry().register(new BlockItem(ModBlocks.NETHERRACK_7, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("netherrack_7"));
        event.getRegistry().register(new BlockItem(ModBlocks.NETHERRACK_8, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("netherrack_8"));
        event.getRegistry().register(new BlockItem(ModBlocks.NETHERRACK_9, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("netherrack_9"));

        event.getRegistry().register(new BlockItem(ModBlocks.CLAY_1, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("clay_1"));
        event.getRegistry().register(new BlockItem(ModBlocks.CLAY_2, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("clay_2"));
        event.getRegistry().register(new BlockItem(ModBlocks.CLAY_3, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("clay_3"));
        event.getRegistry().register(new BlockItem(ModBlocks.CLAY_4, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("clay_4"));
        event.getRegistry().register(new BlockItem(ModBlocks.CLAY_5, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("clay_5"));
        event.getRegistry().register(new BlockItem(ModBlocks.CLAY_6, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("clay_6"));
        event.getRegistry().register(new BlockItem(ModBlocks.CLAY_7, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("clay_7"));
        event.getRegistry().register(new BlockItem(ModBlocks.CLAY_8, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("clay_8"));
        event.getRegistry().register(new BlockItem(ModBlocks.CLAY_9, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("clay_9"));


        event.getRegistry().register(new BlockItem(ModBlocks.COBBLESTONE_1, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("cobblestone_1"));
        event.getRegistry().register(new BlockItem(ModBlocks.COBBLESTONE_2, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("cobblestone_2"));
        event.getRegistry().register(new BlockItem(ModBlocks.COBBLESTONE_3, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("cobblestone_3"));
        event.getRegistry().register(new BlockItem(ModBlocks.COBBLESTONE_4, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("cobblestone_4"));
        event.getRegistry().register(new BlockItem(ModBlocks.COBBLESTONE_5, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("cobblestone_5"));
        event.getRegistry().register(new BlockItem(ModBlocks.COBBLESTONE_6, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("cobblestone_6"));
        event.getRegistry().register(new BlockItem(ModBlocks.COBBLESTONE_7, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("cobblestone_7"));
        event.getRegistry().register(new BlockItem(ModBlocks.COBBLESTONE_8, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("cobblestone_8"));
        event.getRegistry().register(new BlockItem(ModBlocks.COBBLESTONE_9, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("cobblestone_9"));

        event.getRegistry().register(new BlockItem(ModBlocks.SAND_1, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("sand_1"));
        event.getRegistry().register(new BlockItem(ModBlocks.SAND_2, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("sand_2"));
        event.getRegistry().register(new BlockItem(ModBlocks.SAND_3, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("sand_3"));
        event.getRegistry().register(new BlockItem(ModBlocks.SAND_4, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("sand_4"));
        event.getRegistry().register(new BlockItem(ModBlocks.SAND_5, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("sand_5"));
        event.getRegistry().register(new BlockItem(ModBlocks.SAND_6, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("sand_6"));
        event.getRegistry().register(new BlockItem(ModBlocks.SAND_7, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("sand_7"));
        event.getRegistry().register(new BlockItem(ModBlocks.SAND_8, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("sand_8"));
        event.getRegistry().register(new BlockItem(ModBlocks.SAND_9, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("sand_9"));

        event.getRegistry().register(new BlockItem(ModBlocks.GRAVEL_1, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("gravel_1"));
        event.getRegistry().register(new BlockItem(ModBlocks.GRAVEL_2, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("gravel_2"));
        event.getRegistry().register(new BlockItem(ModBlocks.GRAVEL_3, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("gravel_3"));
        event.getRegistry().register(new BlockItem(ModBlocks.GRAVEL_4, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("gravel_4"));
        event.getRegistry().register(new BlockItem(ModBlocks.GRAVEL_5, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("gravel_5"));
        event.getRegistry().register(new BlockItem(ModBlocks.GRAVEL_6, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("gravel_6"));
        event.getRegistry().register(new BlockItem(ModBlocks.GRAVEL_7, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("gravel_7"));
        event.getRegistry().register(new BlockItem(ModBlocks.GRAVEL_8, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("gravel_8"));
        event.getRegistry().register(new BlockItem(ModBlocks.GRAVEL_9, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("gravel_9"));

        event.getRegistry().register(new BlockItem(ModBlocks.STONE_1, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("stone_1"));
        event.getRegistry().register(new BlockItem(ModBlocks.STONE_2, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("stone_2"));
        event.getRegistry().register(new BlockItem(ModBlocks.STONE_3, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("stone_3"));
        event.getRegistry().register(new BlockItem(ModBlocks.STONE_4, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("stone_4"));
        event.getRegistry().register(new BlockItem(ModBlocks.STONE_5, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("stone_5"));
        event.getRegistry().register(new BlockItem(ModBlocks.STONE_6, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("stone_6"));
        event.getRegistry().register(new BlockItem(ModBlocks.STONE_7, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("stone_7"));
        event.getRegistry().register(new BlockItem(ModBlocks.STONE_8, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("stone_8"));
        event.getRegistry().register(new BlockItem(ModBlocks.STONE_9, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("stone_9"));

        event.getRegistry().register(new BlockItem(ModBlocks.IRON_1, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("iron_1"));
        event.getRegistry().register(new BlockItem(ModBlocks.IRON_2, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("iron_2"));
        event.getRegistry().register(new BlockItem(ModBlocks.IRON_3, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("iron_3"));
        event.getRegistry().register(new BlockItem(ModBlocks.IRON_4, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("iron_4"));
        event.getRegistry().register(new BlockItem(ModBlocks.IRON_5, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("iron_5"));
        event.getRegistry().register(new BlockItem(ModBlocks.IRON_6, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("iron_6"));
        event.getRegistry().register(new BlockItem(ModBlocks.IRON_7, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("iron_7"));
        event.getRegistry().register(new BlockItem(ModBlocks.IRON_8, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("iron_8"));
        event.getRegistry().register(new BlockItem(ModBlocks.IRON_9, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("iron_9"));

        event.getRegistry().register(new BlockItem(ModBlocks.GOLD_1, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("gold_1"));
        event.getRegistry().register(new BlockItem(ModBlocks.GOLD_2, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("gold_2"));
        event.getRegistry().register(new BlockItem(ModBlocks.GOLD_3, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("gold_3"));
        event.getRegistry().register(new BlockItem(ModBlocks.GOLD_4, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("gold_4"));
        event.getRegistry().register(new BlockItem(ModBlocks.GOLD_5, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("gold_5"));
        event.getRegistry().register(new BlockItem(ModBlocks.GOLD_6, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("gold_6"));
        event.getRegistry().register(new BlockItem(ModBlocks.GOLD_7, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("gold_7"));
        event.getRegistry().register(new BlockItem(ModBlocks.GOLD_8, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("gold_8"));
        event.getRegistry().register(new BlockItem(ModBlocks.GOLD_9, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("gold_9"));

        event.getRegistry().register(new BlockItem(ModBlocks.DIAMOND_1, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("diamond_1"));
        event.getRegistry().register(new BlockItem(ModBlocks.DIAMOND_2, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("diamond_2"));
        event.getRegistry().register(new BlockItem(ModBlocks.DIAMOND_3, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("diamond_3"));
        event.getRegistry().register(new BlockItem(ModBlocks.DIAMOND_4, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("diamond_4"));
        event.getRegistry().register(new BlockItem(ModBlocks.DIAMOND_5, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("diamond_5"));
        event.getRegistry().register(new BlockItem(ModBlocks.DIAMOND_6, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("diamond_6"));
        event.getRegistry().register(new BlockItem(ModBlocks.DIAMOND_7, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("diamond_7"));
        event.getRegistry().register(new BlockItem(ModBlocks.DIAMOND_8, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("diamond_8"));
        event.getRegistry().register(new BlockItem(ModBlocks.DIAMOND_9, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("diamond_9"));

        event.getRegistry().register(new BlockItem(ModBlocks.EMERALD_1, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("emerald_1"));
        event.getRegistry().register(new BlockItem(ModBlocks.EMERALD_2, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("emerald_2"));
        event.getRegistry().register(new BlockItem(ModBlocks.EMERALD_3, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("emerald_3"));
        event.getRegistry().register(new BlockItem(ModBlocks.EMERALD_4, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("emerald_4"));
        event.getRegistry().register(new BlockItem(ModBlocks.EMERALD_5, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("emerald_5"));
        event.getRegistry().register(new BlockItem(ModBlocks.EMERALD_6, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("emerald_6"));
        event.getRegistry().register(new BlockItem(ModBlocks.EMERALD_7, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("emerald_7"));
        event.getRegistry().register(new BlockItem(ModBlocks.EMERALD_8, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("emerald_8"));
        event.getRegistry().register(new BlockItem(ModBlocks.EMERALD_9, new Item.Properties().group(xCompress.creativeTab)).setRegistryName("emerald_9"));

        }
    }

}
