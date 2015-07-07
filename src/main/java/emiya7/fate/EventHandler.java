package emiya7.fate;

import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import emiya7.fate.event.ExplosionEvent;

public class EventHandler {

	@SubscribeEvent(priority = EventPriority.HIGH)
	public void testFalling(LivingFallEvent event) {
		if(event.entityLiving instanceof EntityPlayerMP ) {
			EntityPlayer entityPlayer = (EntityPlayer)event.entityLiving;
			entityPlayer.addChatMessage(new ChatComponentText("Falling Star! You fell "+event.distance+ " meters.That's cool, man!"));
		}
	}

	@SubscribeEvent
	public void letsrock(ServerChatEvent event) {
		if(event.message.equals("KABOOM")) {
			event.setCanceled(true);//截获玩家的指令并不让它显示在屏幕上,用来模拟游戏指令(Command)
			EntityPlayer player = event.player;
			ExplosionEvent ExplosionEvent = new ExplosionEvent(player);//初始化一个事件
			MinecraftForge.EVENT_BUS.post(ExplosionEvent);//发布它
			if(ExplosionEvent.getResult() == Result.ALLOW) {
				//这个长的让人发指的东西是获取玩家附近的生物
				List list = player.worldObj.getEntitiesWithinAABB(EntityLiving.class, AxisAlignedBB.getBoundingBox(player.posX-30D, player.posY-20D, player.posZ-30D, player.posX+30D, player.posY+20D, player.posZ+30D));
				//值得一提的是我这里使用的是遍历器,传统的下标遍历因为无法锁定资源可能导致ConcurrentModificationException...
				for(Iterator iterator = list.iterator();iterator.hasNext();) {
					EntityLiving entity = (EntityLiving)iterator.next();
					if(entity.equals(player)) { //别把自己也给炸了...
						player.worldObj.createExplosion(player, entity.posX, entity.posY, entity.posZ, 0f, true);
						continue;
					}
					player.worldObj.createExplosion(player, entity.posX, entity.posY, entity.posZ, 4f, true);
				}
			}
		}
	}

	@SubscribeEvent
	public void goodbyeRenko(ExplosionEvent event) {
		event.entityPlayer.addChatMessage(new ChatComponentText("Have a nice day, Renko Usami."));//欢迎来到冥界,宇佐见莲子.
		event.setResult(Result.ALLOW);
	}
}
