package me.dinnerbeef.compressium.blocks;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import com.blakebr0.cucumber.block.BaseBlock;
import com.blakebr0.cucumber.item.BaseBlockItem;
import me.dinnerbeef.compressium.Compressium;
import me.dinnerbeef.compressium.item.ModItems;
import net.minecraft.block.Block;
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
    public static final RegistryObject<Block> SOULSAND_1 = register("soulsand_1", () -> new Soulsand(1));
    public static final RegistryObject<Block> SOULSAND_2 = register("soulsand_2", () -> new Soulsand(2));
    public static final RegistryObject<Block> SOULSAND_3 = register("soulsand_3", () -> new Soulsand(3));
    public static final RegistryObject<Block> SOULSAND_4 = register("soulsand_4", () -> new Soulsand(4));

    // Snow
    public static final RegistryObject<BaseBlock> SNOW_1 = register("snow_1", () -> new Snow(1));
    public static final RegistryObject<BaseBlock> SNOW_2 = register("snow_2", () -> new Snow(2));
    public static final RegistryObject<BaseBlock> SNOW_3 = register("snow_3", () -> new Snow(3));
    public static final RegistryObject<BaseBlock> SNOW_4 = register("snow_4", () -> new Snow(4));

    // Netherrack
    public static final RegistryObject<BaseBlock> NETHERRACK_1 = register("netherrack_1", () -> new Netherrack(1));
    public static final RegistryObject<BaseBlock> NETHERRACK_2 = register("netherrack_2", () -> new Netherrack(2));
    public static final RegistryObject<BaseBlock> NETHERRACK_3 = register("netherrack_3", () -> new Netherrack(3));
    public static final RegistryObject<BaseBlock> NETHERRACK_4 = register("netherrack_4", () -> new Netherrack(4));
   
    // Clay
    public static final RegistryObject<BaseBlock> CLAY_1 = register("clay_1", () -> new Clay(1));
    public static final RegistryObject<BaseBlock> CLAY_2 = register("clay_2", () -> new Clay(2));
    public static final RegistryObject<BaseBlock> CLAY_3 = register("clay_3", () -> new Clay(3));
    public static final RegistryObject<BaseBlock> CLAY_4 = register("clay_4", () -> new Clay(4));

    // Cobblestone
    public static final RegistryObject<BaseBlock> COBBLESTONE_1 = register("cobblestone_1", () -> new Cobblestone(1));
    public static final RegistryObject<BaseBlock> COBBLESTONE_2 = register("cobblestone_2", () -> new Cobblestone(2));
    public static final RegistryObject<BaseBlock> COBBLESTONE_3 = register("cobblestone_3", () -> new Cobblestone(3));
    public static final RegistryObject<BaseBlock> COBBLESTONE_4 = register("cobblestone_4", () -> new Cobblestone(4));

    // Sand
    public static final RegistryObject<Block> SAND_1 = register("sand_1", () -> new Sand(1));
    public static final RegistryObject<Block> SAND_2 = register("sand_2", () -> new Sand(2));
    public static final RegistryObject<Block> SAND_3 = register("sand_3", () -> new Sand(3));
    public static final RegistryObject<Block> SAND_4 = register("sand_4", () -> new Sand(4));

    // Gravel
    public static final RegistryObject<Block> GRAVEL_1 = register("gravel_1", () -> new Gravel(1));
    public static final RegistryObject<Block> GRAVEL_2 = register("gravel_2", () -> new Gravel(2));
    public static final RegistryObject<Block> GRAVEL_3 = register("gravel_3", () -> new Gravel(3));
    public static final RegistryObject<Block> GRAVEL_4 = register("gravel_4", () -> new Gravel(4));

    // dirt
    public static final RegistryObject<BaseBlock> DIRT_1 = register("dirt_1", () -> new Dirt(1));
    public static final RegistryObject<BaseBlock> DIRT_2 = register("dirt_2", () -> new Dirt(2));
    public static final RegistryObject<BaseBlock> DIRT_3 = register("dirt_3", () -> new Dirt(3));
    public static final RegistryObject<BaseBlock> DIRT_4 = register("dirt_4", () -> new Dirt(4));

    // Stone
    public static final RegistryObject<BaseBlock> STONE_1 = register("stone_1", () -> new Stone(1));
    public static final RegistryObject<BaseBlock> STONE_2 = register("stone_2", () -> new Stone(2));
    public static final RegistryObject<BaseBlock> STONE_3 = register("stone_3", () -> new Stone(3));
    public static final RegistryObject<BaseBlock> STONE_4 = register("stone_4", () -> new Stone(4));

    // Iron
    public static final RegistryObject<BaseBlock> IRON_1 = register("iron_1", () -> new Iron(1));
    public static final RegistryObject<BaseBlock> IRON_2 = register("iron_2", () -> new Iron(2));
    public static final RegistryObject<BaseBlock> IRON_3 = register("iron_3", () -> new Iron(3));
    public static final RegistryObject<BaseBlock> IRON_4 = register("iron_4", () -> new Iron(4));
    
    @SubscribeEvent
    public void onRegisterBlocks(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> registry = event.getRegistry();

        BLOCK_ENTRIES.stream().map(Supplier::get).forEach(registry::register);
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        return register(name, block, b -> () -> new BaseBlockItem(b.get(), p -> p.group(Compressium.ITEM_GROUP)));
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block, Function<RegistryObject<T>, Supplier<? extends BlockItem>> item) {
        ResourceLocation loc = new ResourceLocation(Compressium.MOD_ID, name);
        BLOCK_ENTRIES.add(() -> block.get().setRegistryName(loc));
        RegistryObject<T> reg = RegistryObject.of(loc, ForgeRegistries.BLOCKS);
        ModItems.BLOCK_ENTRIES.add(() -> item.apply(reg).get().setRegistryName(loc));
        return reg;
    }

    public static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> block) {
        ResourceLocation loc = new ResourceLocation(Compressium.MOD_ID, name);
        BLOCK_ENTRIES.add(() -> block.get().setRegistryName(loc));
        return RegistryObject.of(loc, ForgeRegistries.BLOCKS);
    }
}