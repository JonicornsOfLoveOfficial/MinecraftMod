package net.mcreator.minecraftandesidegenerator.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.minecraftandesidegenerator.MinecraftAndesideGeneratorElements;

import java.util.Random;

@MinecraftAndesideGeneratorElements.ModElement.Tag
public class FlyingPearlRightClickedInAirProcedure extends MinecraftAndesideGeneratorElements.ModElement {
	public FlyingPearlRightClickedInAirProcedure(MinecraftAndesideGeneratorElements instance) {
		super(instance, 19);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure FlyingPearlRightClickedInAir!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure FlyingPearlRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (entity instanceof PlayerEntity) {
			((PlayerEntity) entity).abilities.isFlying = (true);
			((PlayerEntity) entity).sendPlayerAbilities();
		}
		for (int index0 = 0; index0 < (int) (99); index0++) {
			if (itemstack.attemptDamageItem((int) 1, new Random(), null)) {
				itemstack.shrink(1);
				itemstack.setDamage(0);
			}
		}
		if (entity instanceof PlayerEntity) {
			((PlayerEntity) entity).abilities.isFlying = (false);
			((PlayerEntity) entity).sendPlayerAbilities();
		}
	}
}
