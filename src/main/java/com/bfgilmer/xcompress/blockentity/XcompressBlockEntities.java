package com.bfgilmer.xcompress.blockentity;

import static com.bfgilmer.xcompress.Xcompress.MODID;

import com.bfgilmer.xcompress.blocks.XcompressBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class XcompressBlockEntities {
    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, MODID);

    public static void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCK_ENTITIES.register(bus);    
    }
    
    public static final RegistryObject<BlockEntityType<Flint1BlockEntity>> FLINT_1 = BLOCK_ENTITIES.register("flint1_vac", () -> BlockEntityType.Builder.of(Flint1BlockEntity::new, XcompressBlocks.FLINT_1.get()).build(null));
    public static final RegistryObject<BlockEntityType<Flint2BlockEntity>> FLINT_2 = BLOCK_ENTITIES.register("flint2_vac", () -> BlockEntityType.Builder.of(Flint2BlockEntity::new, XcompressBlocks.FLINT_2.get()).build(null));
    public static final RegistryObject<BlockEntityType<Flint3BlockEntity>> FLINT_3 = BLOCK_ENTITIES.register("flint3_vac", () -> BlockEntityType.Builder.of(Flint3BlockEntity::new, XcompressBlocks.FLINT_3.get()).build(null));
    public static final RegistryObject<BlockEntityType<Flint4BlockEntity>> FLINT_4 = BLOCK_ENTITIES.register("flint4_vac", () -> BlockEntityType.Builder.of(Flint4BlockEntity::new, XcompressBlocks.FLINT_4.get()).build(null));
}
