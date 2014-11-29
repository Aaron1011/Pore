package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.TNTPrimed;
import org.spongepowered.api.entity.explosive.PrimedTNT;

public class PoreTNTPrimed extends PoreEntity implements TNTPrimed {

	private static TypeConverter<PrimedTNT, PoreTNTPrimed> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<PrimedTNT, PoreTNTPrimed> getTNTPrimedConverter() {
		if (converter == null) {
			converter = new TypeConverter<PrimedTNT, PoreTNTPrimed>(){
				@Override
				protected PoreTNTPrimed convert(PrimedTNT handle) {
					return new PoreTNTPrimed(handle);
				}
			};
		}
		return converter;
	}

	protected PoreTNTPrimed(PrimedTNT handle) {
		super(handle);
	}

	@Override
	public PrimedTNT getHandle() {
		return (PrimedTNT)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreTNTPrimed of(PrimedTNT handle) {
		return converter.apply(handle);
	}

	//TODO: bridge

	@Override
	public EntityType getType(){
		return EntityType.PRIMED_TNT;
	}

	@Override
	public void setFuseTicks(int fuseTicks) {
		throw new NotImplementedException();
	}

	@Override
	public int getFuseTicks() {
		throw new NotImplementedException();
	}

	@Override
	public Entity getSource() {
		throw new NotImplementedException();
	}

	@Override
	public void setYield(float yield) {
		throw new NotImplementedException();
	}

	@Override
	public float getYield() {
		throw new NotImplementedException();
	}

	@Override
	public void setIsIncendiary(boolean isIncendiary) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isIncendiary() {
		throw new NotImplementedException();
	}
}
