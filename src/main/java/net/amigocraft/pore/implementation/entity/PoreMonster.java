package net.amigocraft.pore.implementation.entity;

import com.google.common.collect.ImmutableMap;
import net.amigocraft.pore.util.converter.TypeConverter;
import net.amigocraft.pore.util.converter.ParentTypeConverter;
import org.spongepowered.api.entity.living.monster.Monster;

public class PoreMonster extends PoreCreature implements org.bukkit.entity.Monster {

	private static TypeConverter<Monster, PoreMonster> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<Monster, PoreMonster> getMonsterConverter() {
		if (converter == null) {
			converter = new ParentTypeConverter<Monster, PoreMonster>(
					(ImmutableMap)ImmutableMap.builder() // generified for simplicity and readability
							.build()
			){
				@Override
				protected PoreMonster convert(Monster handle) {
					return new PoreMonster(handle);
				}
			};
		}
		return converter;
	}

	protected PoreMonster(Monster handle) {
		super(handle);
	}

	@Override
	public Monster getHandle() {
		return (Monster)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreMonster of(Monster handle) {
		return converter.apply(handle);
	}

}
