package emiya7.fate.items;

import emiya7.fate.FateMain;
import net.minecraft.item.Item;

public class ManaIgnot extends Item {
	
	public ManaIgnot(){
		super();
		setUnlocalizedName("manaIgnot");
		setTextureName("fate:item_mana_ignot");
		setMaxStackSize(64);
		setCreativeTab(FateMain.creativeTab);
	}
	
}
