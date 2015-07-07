package emiya7.fate.items.tools;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ManaWand extends Item{
	public boolean hitEntity(ItemStack usingItem,EntityLivingBase attacked,EntityLivingBase attacktor){
		usingItem.damageItem(1, attacktor);
		if (attacktor.worldObj.isRemote){
			return true;
		}
		float Angle = (attacktor.rotationYaw/ 180F) * 3.141593F;
		float x = 3f * -MathHelper.sin(Angle);
		float y = 1f;
		float z = 3f * MathHelper.cos(Angle);
		attacked.setVelocity(x, y, z);
		return true;
	}

	//	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,EntityPlayer par3EntityPlayer){
	//		if(!par2World.isRemote){
	//			EntityTNTPrimed entity = new EntityTNTPrimed(par2World, par3EntityPlayer.posX, par3EntityPlayer.posY + par3EntityPlayer.getEyeHeight(), par3EntityPlayer.posZ, par3EntityPlayer);//getEyeHeight方法是获取物体的"眼高",即头部到脚底的距离
	//			float angle = (par3EntityPlayer.rotationYaw/ 180F) * 3.141593F; //水平方向的角度
	//			float angle2 = (-par3EntityPlayer.rotationPitch/ 180F) * 3.141593F; //垂直方向的仰角
	//			final float speed = 2f; //TNT飞行速度 - 抱歉我卖了个萌
	//			entity.motionY = speed * MathHelper.sin(angle2); //算出三个方向上的速度,为了方便阅读我先计算的Y轴分速度
	//			entity.motionX = speed * MathHelper.cos(angle2) * -MathHelper.sin(angle); //根据仰角算出速度在XZ平面上的投影,再正交分解投影
	//			entity.motionZ = speed * MathHelper.cos(angle2) * MathHelper.cos(angle);
	//			par2World.spawnEntityInWorld(entity); //放置实体咯
	//		}
	//		return par1ItemStack;
	//	}

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,EntityPlayer par3EntityPlayer){
		par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
		return par1ItemStack;
	}

	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.block; //让使用动作为格挡
	}

	public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer, int par4) {
		if(!par2World.isRemote){
			EntityTNTPrimed entity = new EntityTNTPrimed(par2World,
					par3EntityPlayer.posX, par3EntityPlayer.posY + par3EntityPlayer.getEyeHeight(), par3EntityPlayer.posZ, par3EntityPlayer);
			float angle = (par3EntityPlayer.rotationYaw/ 180F) * 3.141593F;
			float angle2 = (-par3EntityPlayer.rotationPitch/ 180F) * 3.141593F;
			int duration = this.getMaxItemUseDuration(par1ItemStack) - par4; //计算真正的使用持续时间
			float speed = duration > 50 ? 5f : 0.5f+0.09f*duration;
			entity.motionY = speed * MathHelper.sin(angle2);
			entity.motionX = speed * MathHelper.cos(angle2) * -MathHelper.sin(angle);
			entity.motionZ = speed * MathHelper.cos(angle2) * MathHelper.cos(angle);
			par2World.spawnEntityInWorld(entity);
		}
	}

	public int getMaxItemUseDuration(ItemStack par1ItemStack) {
		return 100000; //最大使用时间为100000tick - 这个数多少都行,别爆了Int32的上限就好...
	}
}
