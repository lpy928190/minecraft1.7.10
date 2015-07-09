package emiya7.fate.blocks;

import emiya7.fate.FateMain;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ManaOre extends Block{

	public ManaOre(Material material) {
		super(material);
		setBlockName("manaOre");
		setBlockTextureName("fate:block_mana_ore");
		setHardness(3.0F).setLightLevel(0.2F).setResistance(100F);
		setStepSound(Block.soundTypeStone);
		setCreativeTab(FateMain.creativeTab);
	}

}
