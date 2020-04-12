package me.dinnerbeef.compressium.blocks;

import net.minecraft.block.FallingBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.FallingBlockEntity;

public class Sand extends FallingBlock {
    public Sand(Integer number) {
        super(Properties.create(Material.SAND)
                .sound(SoundType.SAND)
                .hardnessAndResistance(2.0f));
                setRegistryName("sand_" + number);
    }
    protected void onStartFalling(FallingBlockEntity fallingEntity) {
        fallingEntity.setHurtEntities(true);
    }
    
}