package emiya7.fate.entity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.world.World;

public class IceArrow extends EntityArrow{
	public IceArrow(World par1World) {
		super(par1World);
	}

	public IceArrow(World world, EntityPlayer player, float velocity) {
		super(world, player, velocity);
	}

	public void entityInit() {
		super.entityInit();
	}
}
