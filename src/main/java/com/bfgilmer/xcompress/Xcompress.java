package com.bfgilmer.xcompress;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bfgilmer.xcompress.blocks.XcompressBlocks;
import com.bfgilmer.xcompress.client.screen.FlintContainerScreen;
import com.bfgilmer.xcompress.inventory.XcompressContainerTypes;
import com.bfgilmer.xcompress.item.XcompressItems;
import com.bfgilmer.xcompress.particles.XcompressParticle;
import com.bfgilmer.xcompress.setup.ClientProxy;
import com.bfgilmer.xcompress.setup.IProxy;
import com.bfgilmer.xcompress.setup.ServerProxy;
import com.bfgilmer.xcompress.tileentity.XcompressTileEntities;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("xcompress")
public class Xcompress {
	public static final String MOD_ID = "xcompress";
	public static final ItemGroup ITEM_GROUP = new XcompresItemGroup(Xcompress.MOD_ID);
	public static final Logger LOGGER = LogManager.getLogger();

	public static IProxy proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> ServerProxy::new);

	public Xcompress() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		LOGGER.debug("Loading %s", MOD_ID);
		XcompressContainerTypes.CONTAINERS.register(bus);
		
		
		bus.register(this);
//		bus.register(new ModContainerTypes());
		bus.register(new XcompressParticle());
		bus.register(new XcompressBlocks());
		bus.register(new XcompressItems());
		bus.register(new XcompressTileEntities());

		// Register the setup method for modloading
		bus.addListener(this::setup);
		bus.addListener(this::clientsetup);
		bus.addListener(this::preInit);
		
	}
	
    public void preInit(FMLCommonSetupEvent evt)
    {
 //       IronTileEntity.register();
    }
    
	private void clientsetup(final FMLClientSetupEvent event) {
	    ScreenManager.register(XcompressContainerTypes.FLINT_CONTAINER_1.get(), FlintContainerScreen::new);
	    ScreenManager.register(XcompressContainerTypes.FLINT_CONTAINER_2.get(), FlintContainerScreen::new);
	    ScreenManager.register(XcompressContainerTypes.FLINT_CONTAINER_3.get(), FlintContainerScreen::new);
	    ScreenManager.register(XcompressContainerTypes.FLINT_CONTAINER_4.get(), FlintContainerScreen::new);

		RenderTypeLookup.setRenderLayer(XcompressBlocks.SOULSAND_1.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(XcompressBlocks.SOULSAND_2.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(XcompressBlocks.SOULSAND_3.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(XcompressBlocks.SOULSAND_4.get(), RenderType.cutout());

		RenderTypeLookup.setRenderLayer(XcompressBlocks.COBBLESTONE_1.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(XcompressBlocks.COBBLESTONE_2.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(XcompressBlocks.COBBLESTONE_3.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(XcompressBlocks.COBBLESTONE_4.get(), RenderType.cutout());

		RenderTypeLookup.setRenderLayer(XcompressBlocks.GRAVEL_1.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(XcompressBlocks.GRAVEL_2.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(XcompressBlocks.GRAVEL_3.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(XcompressBlocks.GRAVEL_4.get(), RenderType.cutout());

		RenderTypeLookup.setRenderLayer(XcompressBlocks.IRON_1.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(XcompressBlocks.IRON_2.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(XcompressBlocks.IRON_3.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(XcompressBlocks.IRON_4.get(), RenderType.cutout());

		RenderTypeLookup.setRenderLayer(XcompressBlocks.NETHERRACK_1.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(XcompressBlocks.NETHERRACK_2.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(XcompressBlocks.NETHERRACK_3.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(XcompressBlocks.NETHERRACK_4.get(), RenderType.cutout());

		RenderTypeLookup.setRenderLayer(XcompressBlocks.SNOW_1.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(XcompressBlocks.SNOW_2.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(XcompressBlocks.SNOW_3.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(XcompressBlocks.SNOW_4.get(), RenderType.cutout());

		RenderTypeLookup.setRenderLayer(XcompressBlocks.STONE_1.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(XcompressBlocks.STONE_2.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(XcompressBlocks.STONE_3.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(XcompressBlocks.STONE_4.get(), RenderType.cutout());

		RenderTypeLookup.setRenderLayer(XcompressBlocks.SAND_1.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(XcompressBlocks.SAND_2.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(XcompressBlocks.SAND_3.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(XcompressBlocks.SAND_4.get(), RenderType.cutout());

		RenderTypeLookup.setRenderLayer(XcompressBlocks.CLAY_1.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(XcompressBlocks.CLAY_2.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(XcompressBlocks.CLAY_3.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(XcompressBlocks.CLAY_4.get(), RenderType.cutout());

		RenderTypeLookup.setRenderLayer(XcompressBlocks.DIRT_1.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(XcompressBlocks.DIRT_2.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(XcompressBlocks.DIRT_3.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(XcompressBlocks.DIRT_4.get(), RenderType.cutout());
				
		RenderTypeLookup.setRenderLayer(XcompressBlocks.DIRTSTAIR_1.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(XcompressBlocks.EGGS.get(), RenderType.cutout());

		RenderTypeLookup.setRenderLayer(XcompressBlocks.FLINT_1.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(XcompressBlocks.FLINT_2.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(XcompressBlocks.FLINT_3.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(XcompressBlocks.FLINT_4.get(), RenderType.cutout());

		RenderTypeLookup.setRenderLayer(XcompressBlocks.SLIME_1.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(XcompressBlocks.SLIME_2.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(XcompressBlocks.SLIME_3.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(XcompressBlocks.SLIME_4.get(), RenderType.cutout());
	}

	private void setup(final FMLCommonSetupEvent event) {
	}
}
