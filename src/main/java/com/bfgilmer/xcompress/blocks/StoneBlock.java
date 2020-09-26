package com.bfgilmer.xcompress.blocks;

import com.blakebr0.cucumber.block.BaseBlock;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.entity.monster.MonsterEntity;

public class StoneBlock extends BaseBlock {

	private Integer level;
    public static final DamageSource STONE_DAMAGE = new DamageSource("Compressium");
	
    public StoneBlock(Integer number) {
        super(Material.ROCK,  p -> p.sound(SoundType.STONE).hardnessAndResistance(2.0f*number.floatValue(), (float) Math.pow(6.0f, number.doubleValue())));
        setLevel(number);
    }

	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        if (entityIn instanceof MonsterEntity) {
	        entityIn.attackEntityFrom(STONE_DAMAGE, 2*level*level);
        }
		super.onEntityWalk(worldIn, pos, entityIn);
	}

	public Integer getLevel() {
		return level;
	}

	private void setLevel(Integer level) {
		this.level = level;
	}
}




