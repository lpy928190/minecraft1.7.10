package emiya7.fate.items;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import emiya7.fate.items.tools.ManaCollector;
import emiya7.fate.items.tools.ManaWand;
import emiya7.fate.items.weapeon.IceBow;

public class ItemManager {
	
//	public static ToolMaterial TOOL_ICE = EnumHelper.addToolMaterial("ICE", 0, 32, 1.0F, 3.5F, 5);
	
	public static Item manaIgnot;
	public static Item manaCollector;
	public static Item manaWand;
	public static Item iceBow;
	
	public static void registerItems(){
		manaIgnot = new ManaIgnot();
		manaCollector = new ManaCollector();
		manaWand = new ManaWand();
		iceBow = new IceBow();
		
		registerItem(manaIgnot);
		registerItem(manaCollector);
		registerItem(manaWand);
		registerItem(iceBow);
	}

	private static void registerItem(Item item){
		GameRegistry.registerItem(item, item.getUnlocalizedName(), "fate");
	}
	
}
