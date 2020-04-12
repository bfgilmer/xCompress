package me.dinnerbeef.compressium.blocks;

import net.minecraft.block.FallingBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.FallingBlockEntity;

public class Gravel extends FallingBlock {
    public Gravel(Integer number) {
        super(Properties.create(Material.SAND)
                .sound(SoundType.GROUND)
                .hardnessAndResistance(2.0f));
        setRegistryName("gravel_" + number);
    }
    protected void onStartFalling(FallingBlockEntity fallingEntity) {
        fallingEntity.setHurtEntities(true);
    }
}
