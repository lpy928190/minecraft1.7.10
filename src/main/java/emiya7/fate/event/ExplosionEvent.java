package emiya7.fate.event;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.eventhandler.Event;

public class ExplosionEvent extends Event {
	
	public final EntityPlayer entityPlayer;
	
	public ExplosionEvent(EntityPlayer entity){
		super();
		this.entityPlayer = entity;
	}

}
