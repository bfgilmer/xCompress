package com.bfgilmer.xcompress.inventory;

import com.bfgilmer.xcompress.Xcompress;

import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class XcompressContainers  {
	  public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, Xcompress.MODID);
/*	  
	  public static final RegistryObject<MenuType<PowergenContainer>> POWERGEN_CONTAINER = CONTAINERS.register("powergen",
	            () -> IForgeMenuType.create((windowId, inv, data) -> new PowergenContainer(windowId, data.readBlockPos(), inv, inv.player)));
	            */
	  
	  public static final RegistryObject<MenuType<FlintContainer>> FLINT_CONTAINER_1 = CONTAINERS.register("flint_container_1",
			  () -> IForgeMenuType.create((windowId, inv, data) -> FlintContainer.create(windowId, data.readBlockPos(), inv, inv.player, 1)));
	  public static final RegistryObject<MenuType<FlintContainer>> FLINT_CONTAINER_2 = CONTAINERS.register("flint_container_2",
			  () -> IForgeMenuType.create((windowId, inv, data) -> FlintContainer.create(windowId, data.readBlockPos(), inv, inv.player, 2)));
	  public static final RegistryObject<MenuType<FlintContainer>> FLINT_CONTAINER_3 = CONTAINERS.register("flint_container_3",
			  () -> IForgeMenuType.create((windowId, inv, data) -> FlintContainer.create(windowId, data.readBlockPos(), inv, inv.player, 3)));
	  public static final RegistryObject<MenuType<FlintContainer>> FLINT_CONTAINER_4 = CONTAINERS.register("flint_container_4",
			  () -> IForgeMenuType.create((windowId, inv, data) -> FlintContainer.create(windowId, data.readBlockPos(), inv, inv.player, 4)));
  
//	  public static final RegistryObject<MenuType<CompactorMachineContainer>> COMPACTOR_CONTAINER = CONTAINERS.register("compactor_container", () -> new MenuType<>(CompactorMachineContainer::createContainer));
//	  public static final RegistryObject<MenuType<MachineFrameContainer>> MACHINE_FRAME = CONTAINERS.register("machineframe_container", () -> new MenuType<>(MachineFrameContainer::createContainer));
	}
