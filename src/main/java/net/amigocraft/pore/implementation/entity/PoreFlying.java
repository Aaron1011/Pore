package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Flying;

public class PoreFlying extends PoreLivingEntity implements Flying {

	//TODO: make constructor as specific as possible
	protected PoreFlying(org.spongepowered.api.entity.living.Living handle){
		super(handle);
	}

	public static PoreFlying of(org.spongepowered.api.entity.Entity handle){
		throw new NotImplementedException();
	}
}
