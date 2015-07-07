package emiya7.fate;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import emiya7.fate.blocks.ManaOre;
import emiya7.fate.items.ManaIgnot;
import emiya7.fate.items.tools.ManaCollector;
import emiya7.fate.items.tools.ManaWand;
import emiya7.fate.material.ManaOreMaterial;

@Mod(modid="fate", name="Fate World", version="0.0.1 Beta")
public class FateMain {
	
	/** Blocks */
	public static Block manaOre;
	
	/** Items */
	public static Item manaIgnot;
	public static Item manaCollector;
	public static Item manaWand;
	
	/** Material */
	public static Material manaOreMaterial;
	
	private void initBlocks() {
		manaOre = new ManaOre(manaOreMaterial);
		manaOre.setBlockName("manaOre").setBlockTextureName("fate:block_mana_ore")
			.setHardness(3.0F).setLightLevel(0.2F).setResistance(100F)
			.setStepSound(Block.soundTypeStone).setCreativeTab(CreativeTabs.tabBlock)
			.setHarvestLevel("ManaCollector", 0);
		GameRegistry.registerBlock(manaOre,"manaOre");
	}
	
	private void initItems(){
		manaIgnot = new ManaIgnot();
		manaIgnot.setUnlocalizedName("manaIgnot").setTextureName("fate:item_mana_ignot")
			.setMaxStackSize(64).setCreativeTab(CreativeTabs.tabMaterials);
		GameRegistry.registerItem(manaIgnot, "manaIgnot");
		manaCollector = new ManaCollector();
		manaCollector.setUnlocalizedName("ManaCollector").setTextureName("fate:item_mana_collector")
			.setCreativeTab(CreativeTabs.tabTools).setHarvestLevel("ManaCollector", 0);
		GameRegistry.registerItem(manaCollector, "manaCollector");
		manaWand = new ManaWand();
		manaWand.setUnlocalizedName("manaWand").setTextureName("fate:item_mana_wand")
			.setCreativeTab(CreativeTabs.tabTools).setMaxDamage(100);
		GameRegistry.registerItem(manaWand, "manaWand");
	}
	
	private void initMaterial(){
		manaOreMaterial = new ManaOreMaterial(MapColor.stoneColor);
	}
	
	private void initRecipe(){
		GameRegistry.addRecipe(new ItemStack(manaCollector, 1), new Object[] {" # ", "#X#", " Y ", '#', Items.emerald, 'X', Items.diamond, 'Y', Items.iron_ingot});
	}
	
	@EventHandler
	public void preLoad(FMLPreInitializationEvent event){
		initMaterial();
		initBlocks();
		initItems();
	}
	 
	@EventHandler
	public void load(FMLInitializationEvent event){
		initRecipe();
		GameRegistry.addSmelting(manaOre, new ItemStack(manaIgnot), 1f);
	}
	 
	@EventHandler
	public void postLoad(FMLPostInitializationEvent event){
		
	}
	
}
