package net.amigocraft.pore.implementation.entity;

import com.google.common.collect.ImmutableMap;
import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Ageable;
import org.spongepowered.api.entity.living.animal.Animal;
import org.spongepowered.api.entity.living.villager.Villager;

public class PoreAgeable extends PoreCreature implements Ageable {

	private static TypeConverter<org.spongepowered.api.entity.living.Ageable, PoreAgeable> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<org.spongepowered.api.entity.living.Ageable, PoreAgeable> getAgeableConverter() {
		if (converter == null) {
			converter = new TypeConverter<org.spongepowered.api.entity.living.Ageable, PoreAgeable>(
					(ImmutableMap)ImmutableMap.builder() // generified for simplicity and readability
							.put(Animal.class, PoreAnimals.getAnimalConverter())
							.put(Villager.class, PoreVillager.getVillagerConverter())
							.build()
			){
				@Override
				protected PoreAgeable convert(org.spongepowered.api.entity.living.Ageable handle) {
					return new PoreAgeable(handle);
				}
			};
		}
		return converter;
	}

	//TODO: bridge

	protected PoreAgeable(org.spongepowered.api.entity.living.Ageable handle) {
		super(handle);
	}

	@Override
	public org.spongepowered.api.entity.living.Ageable getHandle() {
		return (org.spongepowered.api.entity.living.Ageable)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreAgeable of(org.spongepowered.api.entity.living.Ageable handle) {
		return converter.apply(handle);
	}

	@Override
	public int getAge() {
		throw new NotImplementedException();
	}

	@Override
	public void setAge(int age) {
		throw new NotImplementedException();
	}

	@Override
	public void setAgeLock(boolean lock) {
		throw new NotImplementedException();
	}

	@Override
	public boolean getAgeLock() {
		throw new NotImplementedException();
	}

	@Override
	public void setBaby() {
		throw new NotImplementedException();
	}

	@Override
	public void setAdult() {
		throw new NotImplementedException();
	}

	@Override
	public boolean isAdult() {
		throw new NotImplementedException();
	}

	@Override
	public boolean canBreed() {
		throw new NotImplementedException();
	}

	@Override
	public void setBreed(boolean breed) {
		throw new NotImplementedException();
	}
}
