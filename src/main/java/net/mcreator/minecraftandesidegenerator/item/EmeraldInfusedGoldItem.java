
package net.mcreator.minecraftandesidegenerator.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.minecraftandesidegenerator.MinecraftAndesideGeneratorElements;

@MinecraftAndesideGeneratorElements.ModElement.Tag
public class EmeraldInfusedGoldItem extends MinecraftAndesideGeneratorElements.ModElement {
	@ObjectHolder("minecraftandesidegenerator:emeraldinfusedgold")
	public static final Item block = null;
	public EmeraldInfusedGoldItem(MinecraftAndesideGeneratorElements instance) {
		super(instance, 6);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MATERIALS).maxStackSize(64));
			setRegistryName("emeraldinfusedgold");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
