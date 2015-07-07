package emiya7.fate;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import emiya7.fate.blocks.ManaBlock;

@Mod(modid="fate", name="Fate World", version="1.0.0")
public class FateMain {
	
	/** Blocks */
	public static Block manaBlock;
	
	private void initBlocks() {
		manaBlock = new ManaBlock(Material.rock);
		manaBlock.setBlockName("manaBlock").setBlockTextureName("fate:block_mana")
		.setHardness(3.0F).setLightLevel(1.0F).setResistance(100F)
		.setStepSound(Block.soundTypeStone).setCreativeTab(CreativeTabs.tabBlock)
		.setHarvestLevel("pickaxe", 3);
		
	}
	
	@EventHandler
	public void preLoad(FMLPreInitializationEvent event){
		initBlocks();
	}
	 
	@EventHandler
	public void load(FMLInitializationEvent event){
		
	}
	 
	@EventHandler
	public void postLoad(FMLPostInitializationEvent event){
		
	}
	
}
