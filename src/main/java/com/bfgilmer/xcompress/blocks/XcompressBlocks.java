package com.bfgilmer.xcompress.blocks;

import static com.bfgilmer.xcompress.Xcompress.MODID;

import java.util.function.Supplier;

import com.bfgilmer.xcompress.Xcompress;


import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import com.bfgilmer.xcompress.item.XcompressItems;

import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class XcompressBlocks {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final Item.Properties ITEM_PROPERTIES = new Item.Properties().tab(Xcompress.ITEM_GROUP);

    public static void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(bus);
    }
    
	// Soulsand
	public static final RegistryObject<Block> SOULSAND_1 = register("soulsand_1", () -> new SoulsandBlock(1));
	public static final RegistryObject<Block> SOULSAND_2 = register("soulsand_2", () -> new SoulsandBlock(2));
	public static final RegistryObject<Block> SOULSAND_3 = register("soulsand_3", () -> new SoulsandBlock(3));
	public static final RegistryObject<Block> SOULSAND_4 = register("soulsand_4", () -> new SoulsandBlock(4));

	// Snow
	public static final RegistryObject<Block> SNOW_1 = register("snow_1", () -> new SnowBlock(1));
	public static final RegistryObject<Block> SNOW_2 = register("snow_2", () -> new SnowBlock(2));
	public static final RegistryObject<Block> SNOW_3 = register("snow_3", () -> new SnowBlock(3));
	public static final RegistryObject<Block> SNOW_4 = register("snow_4", () -> new SnowBlock(4));

	// Netherrack
	public static final RegistryObject<Block> NETHERRACK_1 = register("netherrack_1", () -> new NetherrackBlock(1));
	public static final RegistryObject<Block> NETHERRACK_2 = register("netherrack_2", () -> new NetherrackBlock(2));
	public static final RegistryObject<Block> NETHERRACK_3 = register("netherrack_3", () -> new NetherrackBlock(3));
	public static final RegistryObject<Block> NETHERRACK_4 = register("netherrack_4", () -> new NetherrackBlock(4));

	// Clay
	public static final RegistryObject<Block> CLAY_1 = register("clay_1", () -> new ClayBlock(1));
	public static final RegistryObject<Block> CLAY_2 = register("clay_2", () -> new ClayBlock(2));
	public static final RegistryObject<Block> CLAY_3 = register("clay_3", () -> new ClayBlock(3));
	public static final RegistryObject<Block> CLAY_4 = register("clay_4", () -> new ClayBlock(4));

	// Cobblestone
	public static final RegistryObject<Block> COBBLESTONE_1 = register("cobblestone_1",
			() -> new CobblestoneBlock(1));
	public static final RegistryObject<Block> COBBLESTONE_2 = register("cobblestone_2",
			() -> new CobblestoneBlock(2));
	public static final RegistryObject<Block> COBBLESTONE_3 = register("cobblestone_3",
			() -> new CobblestoneBlock(3));
	public static final RegistryObject<Block> COBBLESTONE_4 = register("cobblestone_4",
			() -> new CobblestoneBlock(4));

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
	public static final RegistryObject<Block> DIRT_1 = register("dirt_1", () -> new DirtBlock(1));
	public static final RegistryObject<Block> DIRT_2 = register("dirt_2", () -> new DirtBlock(2));
	public static final RegistryObject<Block> DIRT_3 = register("dirt_3", () -> new DirtBlock(3));
	public static final RegistryObject<Block> DIRT_4 = register("dirt_4", () -> new DirtBlock(4));

	// dirt stair
	public static final RegistryObject<Block> DIRTSTAIR_1 = register("dirt_stairs",
			() -> new DirtStairBlock(1));

	// Stone
	public static final RegistryObject<Block> STONE_1 = register("stone_1", () -> new StoneBlock(1));
	public static final RegistryObject<Block> STONE_2 = register("stone_2", () -> new StoneBlock(2));
	public static final RegistryObject<Block> STONE_3 = register("stone_3", () -> new StoneBlock(3));
	public static final RegistryObject<Block> STONE_4 = register("stone_4", () -> new StoneBlock(4));

	// Iron
	public static final RegistryObject<Block> IRON_1 = register("iron_1", () -> new IronBlock(1));
	public static final RegistryObject<Block> IRON_2 = register("iron_2", () -> new IronBlock(2));
	public static final RegistryObject<Block> IRON_3 = register("iron_3", () -> new IronBlock(3));
	public static final RegistryObject<Block> IRON_4 = register("iron_4", () -> new IronBlock(4));

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

	// Glazed Slime
	public static final RegistryObject<Block> GLAZED_SLIME = register("glazed_slime", () -> new GlazedSlimeBlock());

	// Eggs
	public static final RegistryObject<Block> EGGS = register("eggs", () -> new EggBlock());

	// Zinc
	public static final RegistryObject<Block> ZINC = register("zinc_block", () -> new Block(Properties.of(Material.CLAY).sound(SoundType.STONE).strength(0.6f, 0.6f)));
	public static final RegistryObject<Block> ALUMINUM = register("aluminum_block", () -> new Block(Properties.of(Material.CLAY).sound(SoundType.STONE).strength(0.6f, 0.6f)));
	
    public static RegistryObject<Block> register(String name, final Supplier<? extends Block> sup) {
    	RegistryObject<Block> block = BLOCKS.register(name, sup);
        XcompressItems.ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), ITEM_PROPERTIES));
    	return block; 
    }
    
    public static boolean always(BlockState state, BlockGetter reader, BlockPos pos) {
        return true;
    }

    public static boolean never(BlockState state, BlockGetter reader, BlockPos pos) {
        return false;
    }

    public static boolean always(BlockState state, BlockGetter reader, BlockPos pos, EntityType<?> entityType) {
        return true;
    }

    public static boolean never(BlockState state, BlockGetter reader, BlockPos pos, EntityType<?> entityType) {
        return false;
    }
}