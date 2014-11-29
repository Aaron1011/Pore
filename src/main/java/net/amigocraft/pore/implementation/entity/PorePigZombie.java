package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.PigZombie;
import org.spongepowered.api.entity.living.monster.ZombiePigman;

public class PorePigZombie extends PoreZombie implements PigZombie {

	private static TypeConverter<ZombiePigman, PorePigZombie> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<ZombiePigman, PorePigZombie> getPigZombieConverter() {
		if (converter == null) {
			converter = new TypeConverter<ZombiePigman, PorePigZombie>(){
				@Override
				protected PorePigZombie convert(ZombiePigman handle) {
					return new PorePigZombie(handle);
				}
			};
		}
		return converter;
	}

	protected PorePigZombie(ZombiePigman handle) {
		super(handle);
	}

	@Override
	public ZombiePigman getHandle() {
		return (ZombiePigman)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PorePigZombie of(ZombiePigman handle) {
		return converter.apply(handle);
	}

	//TODO: bridge

	@Override
	public EntityType getType(){
		return EntityType.PIG_ZOMBIE;
	}

	@Override
	public int getAnger() {
		throw new NotImplementedException();
	}

	@Override
	public void setAnger(int level) {
		throw new NotImplementedException();
	}

	@Override
	public void setAngry(boolean angry) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isAngry() {
		throw new NotImplementedException();
	}
}
