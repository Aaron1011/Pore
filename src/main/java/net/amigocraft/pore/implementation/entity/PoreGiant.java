package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Giant;

public class PoreGiant extends PoreMonster implements Giant {

	//TODO: make constructor as specific as possible
	protected PoreGiant(org.spongepowered.api.entity.living.Living handle){
		super(handle);
	}

	public static PoreGiant of(org.spongepowered.api.entity.Entity handle){
		throw new NotImplementedException();
	}

	@Override
	public EntityType getType(){
		return EntityType.GIANT;
	}

}
