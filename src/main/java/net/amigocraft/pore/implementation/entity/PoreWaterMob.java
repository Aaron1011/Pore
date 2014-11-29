package net.amigocraft.pore.implementation.entity;

import com.google.common.collect.ImmutableMap;
import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.WaterMob;
import org.spongepowered.api.entity.living.Agent;

public class PoreWaterMob extends PoreCreature implements WaterMob {

	// no corresponding Sponge interface

	private static TypeConverter<Agent, PoreWaterMob> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<Agent, PoreWaterMob> getWaterMobConverter() {
		if (converter == null) {
			converter = new TypeConverter<Agent, PoreWaterMob>(
					(ImmutableMap)ImmutableMap.builder() // generified for simplicity and readability
							.build()
			){
				@Override
				protected PoreWaterMob convert(Agent handle) {
					return new PoreWaterMob(handle);
				}
			};
		}
		return converter;
	}

	protected PoreWaterMob(Agent handle) {
		super(handle);
	}

	@Override
	public Agent getHandle() {
		return (Agent)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreWaterMob of(Agent handle) {
		return converter.apply(handle);
	}

}
