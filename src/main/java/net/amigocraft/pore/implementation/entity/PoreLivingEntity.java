package net.amigocraft.pore.implementation.entity;

import com.google.common.collect.ImmutableMap;
import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;
import org.spongepowered.api.entity.living.Agent;
import org.spongepowered.api.entity.living.Human;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.living.complex.ComplexLiving;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class PoreLivingEntity extends PoreEntity implements LivingEntity {
	private static TypeConverter<Living, PoreLivingEntity> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<Living, PoreLivingEntity> getLivingEntityConverter() {
		if (converter == null) {
			converter = new TypeConverter<Living, PoreLivingEntity>(
					(ImmutableMap)ImmutableMap.builder()
							//.put(Living.class, PoreAmbient.getAmbientConverter())
							.put(ComplexLiving.class, PoreComplexLivingEntity.getComplexLivingEntityConverter())
							//.put(Living.class, PoreFlying.getFlyingConverter())
							.put(Human.class, PoreHumanEntity.getHumanEntityConverter())
							.put(Slime.class, PoreSlime.getSlimeConverter())
							.put(Agent.class, PoreCreature.getCreatureConverter())
							.build()
			) {
				@Override
				protected PoreLivingEntity convert(Living handle) {
					return new PoreLivingEntity(handle);
				}
			};
		}

		return converter;
	}

	protected PoreLivingEntity(org.spongepowered.api.entity.living.Living handle) {
		super(handle);
	}

	@Override
	public Living getHandle() {
		return (Living) super.getHandle();
	}

	public static PoreLivingEntity of(Living handle) {
		return getLivingEntityConverter().apply(handle);
	}

	//TODO: bridge

	@Override
	public double getEyeHeight() {
		throw new NotImplementedException();
	}

	@Override
	public double getEyeHeight(boolean ignoreSneaking) {
		throw new NotImplementedException();
	}

	@Override
	public Location getEyeLocation() {
		throw new NotImplementedException();
	}

	@Override
	public List<Block> getLineOfSight(HashSet<Byte> transparent, int maxDistance) {
		throw new NotImplementedException();
	}

	@Override
	public Block getTargetBlock(HashSet<Byte> transparent, int maxDistance) {
		throw new NotImplementedException();
	}

	@Override
	public List<Block> getLastTwoTargetBlocks(HashSet<Byte> transparent, int maxDistance) {
		throw new NotImplementedException();
	}

	@Override
	public Egg throwEgg() {
		throw new NotImplementedException();
	}

	@Override
	public Snowball throwSnowball() {
		throw new NotImplementedException();
	}

	@Override
	public Arrow shootArrow() {
		throw new NotImplementedException();
	}

	@Override
	public int getRemainingAir() {
		throw new NotImplementedException();
	}

	@Override
	public void setRemainingAir(int ticks) {
		throw new NotImplementedException();
	}

	@Override
	public int getMaximumAir() {
		throw new NotImplementedException();
	}

	@Override
	public void setMaximumAir(int ticks) {
		throw new NotImplementedException();
	}

	@Override
	public int getMaximumNoDamageTicks() {
		throw new NotImplementedException();
	}

	@Override
	public void setMaximumNoDamageTicks(int ticks) {
		throw new NotImplementedException();
	}

	@Override
	public double getLastDamage() {
		throw new NotImplementedException();
	}

	@Override
	public int _INVALID_getLastDamage() {
		throw new NotImplementedException();
	}

	@Override
	public void setLastDamage(double damage) {
		throw new NotImplementedException();
	}

	@Override
	public void _INVALID_setLastDamage(int damage) {
		throw new NotImplementedException();
	}

	@Override
	public int getNoDamageTicks() {
		throw new NotImplementedException();
	}

	@Override
	public void setNoDamageTicks(int ticks) {
		throw new NotImplementedException();
	}

	@Override
	public Player getKiller() {
		throw new NotImplementedException();
	}

	@Override
	public boolean addPotionEffect(PotionEffect effect) {
		throw new NotImplementedException();
	}

	@Override
	public boolean addPotionEffect(PotionEffect effect, boolean force) {
		throw new NotImplementedException();
	}

	@Override
	public boolean addPotionEffects(Collection<PotionEffect> effects) {
		throw new NotImplementedException();
	}

	@Override
	public boolean hasPotionEffect(PotionEffectType type) {
		throw new NotImplementedException();
	}

	@Override
	public void removePotionEffect(PotionEffectType type) {
		throw new NotImplementedException();
	}

	@Override
	public Collection<PotionEffect> getActivePotionEffects() {
		throw new NotImplementedException();
	}

	@Override
	public boolean hasLineOfSight(Entity other) {
		throw new NotImplementedException();
	}

	@Override
	public boolean getRemoveWhenFarAway() {
		throw new NotImplementedException();
	}

	@Override
	public void setRemoveWhenFarAway(boolean remove) {
		throw new NotImplementedException();
	}

	@Override
	public EntityEquipment getEquipment() {
		throw new NotImplementedException();
	}

	@Override
	public void setCanPickupItems(boolean pickup) {
		throw new NotImplementedException();
	}

	@Override
	public boolean getCanPickupItems() {
		throw new NotImplementedException();
	}

	@Override
	public void setCustomName(String name) {
		throw new NotImplementedException();
	}

	@Override
	public String getCustomName() {
		throw new NotImplementedException();
	}

	@Override
	public void setCustomNameVisible(boolean flag) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isCustomNameVisible() {
		throw new NotImplementedException();
	}

	@Override
	public boolean isLeashed() {
		throw new NotImplementedException();
	}

	@Override
	public Entity getLeashHolder() throws IllegalStateException {
		throw new NotImplementedException();
	}

	@Override
	public boolean setLeashHolder(Entity holder) {
		throw new NotImplementedException();
	}

	@Override
	public void damage(double amount) {
		getHandle().damage(amount);
	}

	@Override
	public void _INVALID_damage(int amount) {
		getHandle().damage((double) amount);
	}

	@Override
	public void damage(double amount, Entity source) {
		throw new NotImplementedException();
	}

	@Override
	public void _INVALID_damage(int amount, Entity source) {
		throw new NotImplementedException();
	}

	@Override
	public double getHealth() {
		return getHandle().getHealth();
	}

	@Override
	public int _INVALID_getHealth() {
		return (int)getHandle().getHealth();
	}

	@Override
	public void setHealth(double health) {
		getHandle().setHealth(health);
	}

	@Override
	public void _INVALID_setHealth(int health) {
		getHandle().setHealth(health);
	}

	@Override
	public double getMaxHealth() {
		throw new NotImplementedException();
	}

	@Override
	public int _INVALID_getMaxHealth() {
		throw new NotImplementedException();
	}

	@Override
	public void setMaxHealth(double health) {
		throw new NotImplementedException();
	}

	@Override
	public void _INVALID_setMaxHealth(int health) {
		throw new NotImplementedException();
	}

	@Override
	public void resetMaxHealth() {
		throw new NotImplementedException();
	}

	@Override
	public <T extends Projectile> T launchProjectile(Class<? extends T> projectile) {
		throw new NotImplementedException();
	}

	@Override
	public <T extends Projectile> T launchProjectile(Class<? extends T> projectile, Vector velocity) {
		throw new NotImplementedException();
	}
}
