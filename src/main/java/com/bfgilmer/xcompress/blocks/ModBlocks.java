package com.bfgilmer.xcompress.blocks;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import com.bfgilmer.xcompress.Xcompress;
import com.bfgilmer.xcompress.item.ModItems;
import com.blakebr0.cucumber.block.BaseBlock;
import com.blakebr0.cucumber.item.BaseBlockItem;

import net.minecraft.block.Block;
import net.minecraft.block.HopperBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {
    public static final List<Supplier<? extends Block>> BLOCK_ENTRIES = new ArrayList<>();
    
    // Soulsand
    public static final RegistryObject<Block> SOULSAND_1 = register("soulsand_1", () -> new SoulsandBlock(1));
    public static final RegistryObject<Block> SOULSAND_2 = register("soulsand_2", () -> new SoulsandBlock(2));
    public static final RegistryObject<Block> SOULSAND_3 = register("soulsand_3", () -> new SoulsandBlock(3));
    public static final RegistryObject<Block> SOULSAND_4 = register("soulsand_4", () -> new SoulsandBlock(4));

    // Snow
    public static final RegistryObject<BaseBlock> SNOW_1 = register("snow_1", () -> new SnowBlock(1));
    public static final RegistryObject<BaseBlock> SNOW_2 = register("snow_2", () -> new SnowBlock(2));
    public static final RegistryObject<BaseBlock> SNOW_3 = register("snow_3", () -> new SnowBlock(3));
    public static final RegistryObject<BaseBlock> SNOW_4 = register("snow_4", () -> new SnowBlock(4));

    // Netherrack
    public static final RegistryObject<BaseBlock> NETHERRACK_1 = register("netherrack_1", () -> new NetherrackBlock(1));
    public static final RegistryObject<BaseBlock> NETHERRACK_2 = register("netherrack_2", () -> new NetherrackBlock(2));
    public static final RegistryObject<BaseBlock> NETHERRACK_3 = register("netherrack_3", () -> new NetherrackBlock(3));
    public static final RegistryObject<BaseBlock> NETHERRACK_4 = register("netherrack_4", () -> new NetherrackBlock(4));
   
    // Clay
    public static final RegistryObject<BaseBlock> CLAY_1 = register("clay_1", () -> new ClayBlock(1));
    public static final RegistryObject<BaseBlock> CLAY_2 = register("clay_2", () -> new ClayBlock(2));
    public static final RegistryObject<BaseBlock> CLAY_3 = register("clay_3", () -> new ClayBlock(3));
    public static final RegistryObject<BaseBlock> CLAY_4 = register("clay_4", () -> new ClayBlock(4));

    // Cobblestone
    public static final RegistryObject<BaseBlock> COBBLESTONE_1 = register("cobblestone_1", () -> new CobblestoneBlock(1));
    public static final RegistryObject<BaseBlock> COBBLESTONE_2 = register("cobblestone_2", () -> new CobblestoneBlock(2));
    public static final RegistryObject<BaseBlock> COBBLESTONE_3 = register("cobblestone_3", () -> new CobblestoneBlock(3));
    public static final RegistryObject<BaseBlock> COBBLESTONE_4 = register("cobblestone_4", () -> new CobblestoneBlock(4));

    // Sand
    public static final RegistryObject<Block> SAND_1 = register("sand_1", () -> new SandBlock(1));
    public static final RegistryObject<Block> SAND_2 = register("sand_2", () -> new SandBlock(2));
    public static final RegistryObject<Block> SAND_3 = register("sand_3", () -> new SandBlock(3));
    public static final RegistryObject<Block> SAND_4 = register("sand_4", () -> new SandBlock(4));

    // Gravel
    public static final RegistryObject<Block> GRAVEL_1 = register("gravel_1", () -> new GravelBlock(1));
    public static final RegistryObject<Block> GRAVEL_2 = register("gravel_2", () -> new GravelBlock(2));
    public static final RegistryObject<Block> GRAVEL_3 = register("gravel_3", () -> new GravelBlock(3));
    public static final RegistryObject<Block> GRAVEL_4 = register("gravel_4", () -> new GravelBlock(4));

    // dirt
    public static final RegistryObject<BaseBlock> DIRT_1 = register("dirt_1", () -> new DirtBlock(1));
    public static final RegistryObject<BaseBlock> DIRT_2 = register("dirt_2", () -> new DirtBlock(2));
    public static final RegistryObject<BaseBlock> DIRT_3 = register("dirt_3", () -> new DirtBlock(3));
    public static final RegistryObject<BaseBlock> DIRT_4 = register("dirt_4", () -> new DirtBlock(4));

    // Stone
    public static final RegistryObject<BaseBlock> STONE_1 = register("stone_1", () -> new StoneBlock(1));
    public static final RegistryObject<BaseBlock> STONE_2 = register("stone_2", () -> new StoneBlock(2));
    public static final RegistryObject<BaseBlock> STONE_3 = register("stone_3", () -> new StoneBlock(3));
    public static final RegistryObject<BaseBlock> STONE_4 = register("stone_4", () -> new StoneBlock(4));

    // Iron
    public static final RegistryObject<BaseBlock> IRON_1 = register("iron_1", () -> new IronBlock(1));
    public static final RegistryObject<BaseBlock> IRON_2 = register("iron_2", () -> new IronBlock(2));
    public static final RegistryObject<BaseBlock> IRON_3 = register("iron_3", () -> new IronBlock(3));
    public static final RegistryObject<BaseBlock> IRON_4 = register("iron_4", () -> new IronBlock(4));

    // Flint
    public static final RegistryObject<Block> FLINT_1 = register("flint_1", () -> new FlintBlock(1));
    public static final RegistryObject<Block> FLINT_2 = register("flint_2", () -> new FlintBlock(2));
    public static final RegistryObject<Block> FLINT_3 = register("flint_3", () -> new FlintBlock(3));
    public static final RegistryObject<Block> FLINT_4 = register("flint_4", () -> new FlintBlock(4));
    
    // Slime
    public static final RegistryObject<Block> SLIME_1 = register("slime_1", () -> new SlimeBlock(1));
    public static final RegistryObject<Block> SLIME_2 = register("slime_2", () -> new SlimeBlock(2));
    public static final RegistryObject<Block> SLIME_3 = register("slime_3", () -> new SlimeBlock(3));
    public static final RegistryObject<Block> SLIME_4 = register("slime_4", () -> new SlimeBlock(4));

    @SubscribeEvent
    public void onRegisterBlocks(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> registry = event.getRegistry();

        BLOCK_ENTRIES.stream().map(Supplier::get).forEach(registry::register);
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        return register(name, block, b -> () -> new BaseBlockItem(b.get(), p -> p.group(Xcompress.ITEM_GROUP)));
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block, Function<RegistryObject<T>, Supplier<? extends BlockItem>> item) {
        ResourceLocation loc = new ResourceLocation(Xcompress.MOD_ID, name);
        BLOCK_ENTRIES.add(() -> block.get().setRegistryName(loc));
        RegistryObject<T> reg = RegistryObject.of(loc, ForgeRegistries.BLOCKS);
        ModItems.BLOCK_ENTRIES.add(() -> item.apply(reg).get().setRegistryName(loc));
        return reg;
    }

    public static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> block) {
        ResourceLocation loc = new ResourceLocation(Xcompress.MOD_ID, name);
        BLOCK_ENTRIES.add(() -> block.get().setRegistryName(loc));
        return RegistryObject.of(loc, ForgeRegistries.BLOCKS);
    }
}