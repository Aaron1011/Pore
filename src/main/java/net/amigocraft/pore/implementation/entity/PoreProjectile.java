package net.amigocraft.pore.implementation.entity;

import com.google.common.collect.ImmutableMap;
import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.*;
import org.bukkit.projectiles.ProjectileSource;
import org.spongepowered.api.entity.projectile.Arrow;
import org.spongepowered.api.entity.projectile.Egg;
import org.spongepowered.api.entity.projectile.EnderPearl;
import org.spongepowered.api.entity.projectile.Projectile;
import org.spongepowered.api.entity.projectile.Snowball;
import org.spongepowered.api.entity.projectile.ThrownExpBottle;
import org.spongepowered.api.entity.projectile.ThrownPotion;

public class PoreProjectile extends PoreEntity implements org.bukkit.entity.Projectile {

	private static TypeConverter<Projectile, PoreProjectile> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<Projectile, PoreProjectile> getProjectileConverter() {
		if (converter == null) {
			converter = new TypeConverter<Projectile, PoreProjectile>(
					(ImmutableMap)ImmutableMap.builder() // generified for simplicity and readability
							.put(Arrow.class, PoreArrow.getArrowConverter())
							.put(Egg.class, PoreEgg.getEggConverter())
							.put(EnderPearl.class, PoreEnderPearl.getEnderPearlConverter())
							.put(Snowball.class, PoreSnowball.getSnowballConverter())
							.put(ThrownExpBottle.class, PoreThrownExpBottle.getThrownExpBottleConverter())
							.put(ThrownPotion.class, PoreThrownPotion.getThrownPotionConverter())
							.build()
			){
				@Override
				protected PoreProjectile convert(Projectile handle) {
					return new PoreProjectile(handle);
				}
			};
		}

		return converter;
	}

	//TODO: bridge

	protected PoreProjectile(Projectile handle) {
		super(handle);
	}

	@Override
	public Projectile getHandle() {
		return (Projectile)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreProjectile of(Projectile handle) {
		return converter.apply(handle);
	}

	@Override
	public LivingEntity _INVALID_getShooter() {
		throw new NotImplementedException();
	}

	@Override
	public ProjectileSource getShooter() {
		throw new NotImplementedException();
	}

	@Override
	public void _INVALID_setShooter(LivingEntity shooter) {
		throw new NotImplementedException();
	}

	@Override
	public void setShooter(ProjectileSource source) {
		throw new NotImplementedException();
	}

	@Override
	public boolean doesBounce() {
		throw new NotImplementedException();
	}

	@Override
	public void setBounce(boolean doesBounce) {
		throw new NotImplementedException();
	}
}
