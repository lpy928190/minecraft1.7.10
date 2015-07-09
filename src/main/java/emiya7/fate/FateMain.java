package emiya7.fate;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import emiya7.fate.blocks.BlockManager;
import emiya7.fate.blocks.ManaOre;
import emiya7.fate.items.ItemManager;
import emiya7.fate.items.ManaIgnot;
import emiya7.fate.items.tools.ManaCollector;
import emiya7.fate.items.tools.ManaWand;
import emiya7.fate.items.weapeon.IceBow;
import emiya7.fate.material.ManaOreMaterial;
import emiya7.fate.material.MaterialManager;

@Mod(modid="fate", name="Fate World", version="0.0.1 Beta")
public class FateMain {
	
//	public static CreativeTabs creativeTab = new CreativeTabFate("Fate World");
	public static CreativeTabs creativeTab = CreativeTabs.tabMaterials;
	
	private void initRecipe(){
		GameRegistry.addRecipe(new ItemStack(ItemManager.manaCollector, 1), new Object[] {" # ", "#X#", " Y ", '#', Items.iron_ingot, 'X', Items.diamond, 'Y', Items.emerald});
	}
	
	@EventHandler
	public void preLoad(FMLPreInitializationEvent event){
		MaterialManager.initMaterials();
		BlockManager.registerBlocks();
		ItemManager.registerItems();
	}
	 
	@EventHandler
	public void load(FMLInitializationEvent event){
		initRecipe();
		GameRegistry.addSmelting(BlockManager.manaOre, new ItemStack(ItemManager.manaIgnot), 1f);
		MinecraftForge.EVENT_BUS.register(new emiya7.fate.EventHandler());
	}
	 
	@EventHandler
	public void postLoad(FMLPostInitializationEvent event){
		
	}
	
}
