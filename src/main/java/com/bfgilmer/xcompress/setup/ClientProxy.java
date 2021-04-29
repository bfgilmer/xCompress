package com.bfgilmer.xcompress.setup;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class ClientProxy implements IProxy {

	@Override
	public void init() {

	}

	@SuppressWarnings("resource")
	@Override
	public World getClientWorld() {
		return Minecraft.getInstance().level;
	}

	@Override
	public PlayerEntity getClientPlayer() {
		return null;
	}
}
