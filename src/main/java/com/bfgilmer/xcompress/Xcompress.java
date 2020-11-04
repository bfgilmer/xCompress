package com.bfgilmer.xcompress;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bfgilmer.xcompress.blocks.*;
import com.bfgilmer.xcompress.item.ModItems;
import com.bfgilmer.xcompress.setup.ClientProxy;
import com.bfgilmer.xcompress.setup.IProxy;
import com.bfgilmer.xcompress.setup.ServerProxy;
import com.bfgilmer.xcompress.tileentity.ModTileEntities;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("xcompress")
public class Xcompress {
    public static final String MOD_ID = "xcompress";
	public static final ItemGroup ITEM_GROUP = new XcompresItemGroup(Xcompress.MOD_ID);
    public static final Logger LOGGER = LogManager.getLogger();

    public static IProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> ServerProxy::new);

    public Xcompress() {       
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		bus.register(this);
		bus.register(new ModBlocks());
		bus.register(new ModItems());
    	bus.register(new ModTileEntities());
		
        // Register the setup method for modloading
        bus.addListener(this::setup);
        bus.addListener(this::clientsetup);
    }
    
    private void clientsetup(final FMLClientSetupEvent event) {   	       
        RenderTypeLookup.setRenderLayer(ModBlocks.SOULSAND_1.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SOULSAND_2.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SOULSAND_3.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SOULSAND_4.get(), RenderType.cutout());
        
        RenderTypeLookup.setRenderLayer(ModBlocks.COBBLESTONE_1.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.COBBLESTONE_2.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.COBBLESTONE_3.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.COBBLESTONE_4.get(), RenderType.cutout());

        RenderTypeLookup.setRenderLayer(ModBlocks.GRAVEL_1.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.GRAVEL_2.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.GRAVEL_3.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.GRAVEL_4.get(), RenderType.cutout());

        RenderTypeLookup.setRenderLayer(ModBlocks.IRON_1.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.IRON_2.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.IRON_3.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.IRON_4.get(), RenderType.cutout());
        
        RenderTypeLookup.setRenderLayer(ModBlocks.NETHERRACK_1.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.NETHERRACK_2.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.NETHERRACK_3.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.NETHERRACK_4.get(), RenderType.cutout());
        
        RenderTypeLookup.setRenderLayer(ModBlocks.SNOW_1.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SNOW_2.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SNOW_3.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SNOW_4.get(), RenderType.cutout());
        
        RenderTypeLookup.setRenderLayer(ModBlocks.STONE_1.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.STONE_2.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.STONE_3.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.STONE_4.get(), RenderType.cutout());
        
        RenderTypeLookup.setRenderLayer(ModBlocks.SAND_1.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SAND_2.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SAND_3.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SAND_4.get(), RenderType.cutout());
        
        RenderTypeLookup.setRenderLayer(ModBlocks.CLAY_1.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.CLAY_2.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.CLAY_3.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.CLAY_4.get(), RenderType.cutout());
        
        RenderTypeLookup.setRenderLayer(ModBlocks.DIRT_1.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.DIRT_2.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.DIRT_3.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.DIRT_4.get(), RenderType.cutout());
        
        RenderTypeLookup.setRenderLayer(ModBlocks.FLINT_1.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.FLINT_2.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.FLINT_3.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.FLINT_4.get(), RenderType.cutout());
        
        RenderTypeLookup.setRenderLayer(ModBlocks.SLIME_1.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SLIME_2.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SLIME_3.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SLIME_4.get(), RenderType.cutout()); 

    }

    private void setup(final FMLCommonSetupEvent event) {
    }
}
