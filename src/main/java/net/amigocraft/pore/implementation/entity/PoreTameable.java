package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Creature;
import org.spongepowered.api.entity.living.animal.Animal;

public class PoreTameable extends PoreAnimals implements org.bukkit.entity.Tameable, Creature {

	//TODO: hierarchy does not match Sponge's
	// Bukkit: Tameable -> Animals -> Ageable -> Creature -> LivingEntity -> Entity
	// Sponge: Tameable -> Agent -> Living -> Entity

	protected PoreTameable(Animal handle) {
		super(handle);
	}

	/*private static TypeConverter<Tameable, PoreTameable> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<Tameable, PoreTameable> getTameableConverter() {
		if (converter == null) {
			converter = new TypeConverter<Tameable, PoreTameable>(){
				@Override
				protected PoreTameable convert(Tameable handle) {
					return new PoreTameable(handle);
				}
			};
		}
		return converter;
	}

	protected PoreTameable(Tameable handle) {
		super(handle);
		throw new NotImplementedException();
	}

	@Override
	public Tameable getHandle() {
		return (Tameable)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	/*public static PoreTameable of(Tameable handle) {
		return converter.apply(handle);
	}*/

	//TODO: bridge

	@Override
	public boolean isTamed() {
		throw new NotImplementedException();
	}

	@Override
	public void setTamed(boolean tame) {
		throw new NotImplementedException();
	}

	@Override
	public AnimalTamer getOwner() {
		throw new NotImplementedException();
	}

	@Override
	public void setOwner(AnimalTamer tamer) {
		throw new NotImplementedException();
	}
}
