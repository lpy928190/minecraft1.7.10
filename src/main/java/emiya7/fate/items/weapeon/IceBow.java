package emiya7.fate.items.weapeon;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.world.World;
import emiya7.fate.FateMain;
import emiya7.fate.entity.IceArrow;

public class IceBow extends BowBase{

	public IceBow(){
		setTextureName("fate:item_ice_bow");
		setCreativeTab(FateMain.creativeTab);
	}

	protected EntityArrow getArrow(World world, EntityPlayer entityPlayer, float velocity)  {
		return new IceArrow(world, entityPlayer, velocity);
	}

}
