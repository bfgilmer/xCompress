package me.bfgilmer.xcompress.blocks;


import net.minecraft.block.SoulSandBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderType;


public class Soulsand extends SoulSandBlock {
    public Soulsand(Integer number) {
        super(Properties.create(Material.SAND)
                .sound(SoundType.SAND).hardnessAndResistance(2.0f));
        setRegistryName("soul_" + number);
    }

}