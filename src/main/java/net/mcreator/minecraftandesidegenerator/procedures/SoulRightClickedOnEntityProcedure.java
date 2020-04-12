package net.mcreator.minecraftandesidegenerator.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.minecraftandesidegenerator.item.ObsidianScytheItem;
import net.mcreator.minecraftandesidegenerator.MinecraftAndesideGeneratorElements;

@MinecraftAndesideGeneratorElements.ModElement.Tag
public class SoulRightClickedOnEntityProcedure extends MinecraftAndesideGeneratorElements.ModElement {
	public SoulRightClickedOnEntityProcedure(MinecraftAndesideGeneratorElements instance) {
		super(instance, 18);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SoulRightClickedOnEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(ObsidianScytheItem.block, (int) (1)).getItem())) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, (int) 1, (int) 3, (false), (false)));
		}
	}
}
