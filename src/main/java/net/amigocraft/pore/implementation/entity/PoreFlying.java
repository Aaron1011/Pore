package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.Flying;
import org.spongepowered.api.entity.living.Living;

public class PoreFlying extends PoreLivingEntity implements Flying {

	// Flying has no corresponding interface in SpongeAPI, defines no methods, and is only implemented by Ghast

	private static TypeConverter<Living, PoreFlying> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<Living, PoreFlying> getFlyingConverter() {
		if (converter == null) {
			converter = new TypeConverter<Living, PoreFlying>(){
				@Override
				protected PoreFlying convert(Living handle) {
					return new PoreFlying(handle);
				}
			};
		}
		return converter;
	}

	protected PoreFlying(Living handle) {
		super(handle);
	}

	@Override
	public Living getHandle() {
		return (Living)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreFlying of(Living handle) {
		return converter.apply(handle);
	}

}
