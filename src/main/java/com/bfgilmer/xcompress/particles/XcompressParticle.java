/**
 * 
 */
package com.bfgilmer.xcompress.particles;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import com.bfgilmer.xcompress.Xcompress;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

/**
 * @author bfgil
 *
 */
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class XcompressParticle {	
	public static final List<Supplier<? extends ParticleType<?>>> PARTICLE_ENTRIES = new ArrayList<>();

	
	@SubscribeEvent
	public void onRegisterItems(RegistryEvent.Register<ParticleType<?>> event) {
		IForgeRegistry<ParticleType<?>> registry = event.getRegistry();

		PARTICLE_ENTRIES.stream().map(Supplier::get).forEach(registry::register);
	}

	private static <T extends ParticleType<?>> RegistryObject<ParticleType<?>> register(String name, Supplier<? extends BasicParticleType> particle) {
		ResourceLocation loc = new ResourceLocation(Xcompress.MOD_ID, name);
		PARTICLE_ENTRIES.add(() -> particle.get().setRegistryName(loc));

		return RegistryObject.of(loc, ForgeRegistries.PARTICLE_TYPES);
	}

	public static final RegistryObject<ParticleType<?>> SMOKE_PUFF = register("example_smoke_puff",
			() -> new BasicParticleType(false));

   
}
