package emiya7.fate.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import emiya7.fate.material.MaterialManager;
import net.minecraft.block.Block;

public class BlockManager {
	
	public static Block manaOre;
	
	public static void registerBlocks(){
		manaOre = new ManaOre(MaterialManager.manaOre);
		manaOre.setHarvestLevel("ManaCollector", 0);
		
		registerBlock(manaOre);
	}
	
	private static void registerBlock(Block block){
		GameRegistry.registerBlock(block, block.getUnlocalizedName());
	}
}
