package com.bfgilmer.xcompress.inventory;

import com.bfgilmer.xcompress.Xcompress;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class XcompressContainerTypes  {
	  public static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, Xcompress.MOD_ID);

	  public static final RegistryObject<ContainerType<FlintContainer>> FLINT_CONTAINER_1 = CONTAINERS.register("flint_container_1", () -> new ContainerType<>(FlintContainer::createFlintWoodContainer));
	  public static final RegistryObject<ContainerType<FlintContainer>> FLINT_CONTAINER_2 = CONTAINERS.register("flint_container_2", () -> new ContainerType<>(FlintContainer::createFlintStoneContainer));
	  public static final RegistryObject<ContainerType<FlintContainer>> FLINT_CONTAINER_3 = CONTAINERS.register("flint_container_3", () -> new ContainerType<>(FlintContainer::createFlintIronContainer));
	  public static final RegistryObject<ContainerType<FlintContainer>> FLINT_CONTAINER_4 = CONTAINERS.register("flint_container_4", () -> new ContainerType<>(FlintContainer::createFlintDiamondContainer));

	}
