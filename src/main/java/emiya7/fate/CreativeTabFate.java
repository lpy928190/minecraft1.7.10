package emiya7.fate;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class CreativeTabFate extends CreativeTabs{

	public CreativeTabFate(String lable) {
		super(lable);
	}

	@Override
	public Item getTabIconItem() {
		return Items.diamond_sword;
	}

}
