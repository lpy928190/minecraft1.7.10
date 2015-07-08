package emiya7.fate.items.weapeon;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.world.World;
import emiya7.fate.entity.IceArrow;

public class IceBow extends BowBase{

	public IceBow(){
		setTextureName("TwilightForest:icebow");
		setCreativeTab(CreativeTabs.tabTools);
//		func_77637_a(TFItems.creativeTab);
	}

	protected EntityArrow getArrow(World world, EntityPlayer entityPlayer, float velocity)  {
		return new IceArrow(world, entityPlayer, velocity);
	}

}
