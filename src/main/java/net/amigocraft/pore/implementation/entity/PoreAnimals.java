package net.amigocraft.pore.implementation.entity;

import com.google.common.collect.ImmutableMap;
import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.Animals;
import org.spongepowered.api.entity.living.animal.Animal;
import org.spongepowered.api.entity.living.animal.Chicken;
import org.spongepowered.api.entity.living.animal.Sheep;

public class PoreAnimals extends PoreAgeable implements Animals {

	private static TypeConverter<Animal, PoreAnimals> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<Animal, PoreAnimals> getAnimalConverter() {
		if (converter == null) {
			converter = new TypeConverter<Animal, PoreAnimals>(
					(ImmutableMap)ImmutableMap.builder() // generified for simplicity and readability
							.put(Chicken.class, PoreChicken.getChickenConverter())
							.put(Chicken.class, PoreCow.getCowConverter())
							.put(Chicken.class, PoreHorse.getHorseConverter())
							.put(Chicken.class, PorePig.getPigConverter())
							.put(Sheep.class, PoreSheep.getSheepConverter())
							//.put(Tameable.class, PoreTameable.getTameableConverter()) //TODO
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
