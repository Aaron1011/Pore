package net.amigocraft.pore.implementation.entity;

import com.google.common.collect.ImmutableMap;
import net.amigocraft.pore.util.converter.TypeConverter;
import net.amigocraft.pore.util.converter.ParentTypeConverter;
import org.bukkit.entity.Animals;
import org.spongepowered.api.entity.living.animal.Animal;

public class PoreAnimals extends PoreAgeable implements Animals {

	private static TypeConverter<Animal, PoreAnimals> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<Animal, PoreAnimals> getAnimalConverter() {
		if (converter == null) {
			converter = new ParentTypeConverter<Animal, PoreAnimals>(
					(ImmutableMap)ImmutableMap.builder() // generified for simplicity and readability
							.build()
			){
				@Override
				protected PoreAnimals convert(Animal handle) {
					return new PoreAnimals(handle);
				}
			};
		}
		return converter;
	}

	protected PoreAnimals(Animal handle) {
		super(handle);
	}

	@Override
	public Animal getHandle() {
		return (Animal)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreAnimals of(Animal handle){
		return converter.apply(handle);
	}

}
