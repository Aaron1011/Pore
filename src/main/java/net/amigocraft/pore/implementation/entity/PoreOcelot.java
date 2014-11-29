package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.entity.living.animal.Ocelot;

public class PoreOcelot extends PoreTameable implements org.bukkit.entity.Ocelot {

	private static TypeConverter<Ocelot, PoreOcelot> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<Ocelot, PoreOcelot> getOcelotConverter() {
		if (converter == null) {
			converter = new TypeConverter<Ocelot, PoreOcelot>(){
				@Override
				protected PoreOcelot convert(Ocelot handle) {
					return new PoreOcelot(handle);
				}
			};
		}
		return converter;
	}

	protected PoreOcelot(Ocelot handle) {
		super(handle);
	}

	@Override
	public Ocelot getHandle() {
		return (Ocelot)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreOcelot of(Ocelot handle) {
		return converter.apply(handle);
	}

	//TODO: bridge

	@Override
	public EntityType getType(){
		return EntityType.OCELOT;
	}

	@Override
	public Type getCatType() {
		throw new NotImplementedException();
	}

	@Override
	public void setCatType(Type type) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isSitting() {
		throw new NotImplementedException();
	}

	@Override
	public void setSitting(boolean sitting) {
		throw new NotImplementedException();
	}
}
