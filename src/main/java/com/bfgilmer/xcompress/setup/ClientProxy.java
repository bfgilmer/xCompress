package com.bfgilmer.xcompress.setup;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class ClientProxy implements IProxy {

	@Override
	public void init() {

	}

	@SuppressWarnings("resource")
	@Override
	public Level getClientWorld() {
		return Minecraft.getInstance().level;
	}

	@Override
	public Player getClientPlayer() {
		return null;
	}
}
