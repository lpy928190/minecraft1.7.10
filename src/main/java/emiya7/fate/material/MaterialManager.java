package emiya7.fate.material;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class MaterialManager {
	
	public static Material manaOre;
	
	public static void initMaterials(){
		manaOre = new ManaOreMaterial(MapColor.stoneColor);
	}
}
