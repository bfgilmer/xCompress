package com.bfgilmer.xcompress;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bfgilmer.xcompress.blockentity.XcompressBlockEntities;
import com.bfgilmer.xcompress.blocks.XcompressBlocks;
import com.bfgilmer.xcompress.item.XcompressItems;
import com.bfgilmer.xcompress.setup.ClientSetup;
import com.bfgilmer.xcompress.setup.Registration;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

//The value here should match an entry in the META-INF/mods.toml file
@Mod("xcompress")
public class Xcompress {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "xcompress";
    
    public static final CreativeModeTab ITEM_GROUP = new CreativeModeTab(MODID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(XcompressBlocks.COBBLESTONE_1.get());
        }
    };

    public Xcompress() {

        // Register the deferred registry
    	XcompressItems.init();
    	XcompressBlocks.init();
    	XcompressBlockEntities.init();
    	
        // Register the deferred registry
        Registration.init();

        // Register the setup method for modloading
        IEventBus modbus = FMLJavaModLoadingContext.get().getModEventBus();
        
        // Register 'ModSetup::init' to be called at mod setup time (server and client)
 //       modbus.addListener(ModSetup::init);
        
        // Register 'ClientSetup::init' to be called at mod setup time (client only)
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> modbus.addListener(ClientSetup::init));
    }
}
