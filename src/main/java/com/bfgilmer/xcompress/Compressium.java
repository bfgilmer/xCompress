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

// The value here should match an entry in the META-INF/mods.toml file
@Mod("xcompress")
public class Compressium {
    public static final String MOD_ID = "xcompress";
	public static final ItemGroup ITEM_GROUP = new CompresiumItemGroup(Compressium.MOD_ID);
    public static final Logger LOGGER = LogManager.getLogger();

    public static IProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> ServerProxy::new);

    public Compressium() {       
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
        // Register the setup method for modloading
        bus.addListener(this::setup);
        bus.addListener(this::clientsetup);

		bus.register(this);
		bus.register(new ModBlocks());
		bus.register(new ModItems());
    }
    
    private void clientsetup(final FMLClientSetupEvent event) {   	
        ModBlocks.BLOCK_ENTRIES.forEach(block -> {
            RenderTypeLookup.setRenderLayer(block.get(), RenderType.cutout());
        });
    }

    private void setup(final FMLCommonSetupEvent event) {
    }
}
