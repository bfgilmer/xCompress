package me.dinnerbeef.compressium.blocks.Stone;


import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class Stone_5 extends Block {

    public Stone_5() {
        super(Properties.create(Material.ROCK)
                .sound(SoundType.STONE)
                .hardnessAndResistance(2.0f)


        );
        setRegistryName("stone_5");

    }
}
