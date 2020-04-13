package net.mcreator.minecraftandesidegenerator.procedures;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.minecraftandesidegenerator.item.FlyingpearltoolItem;
import net.mcreator.minecraftandesidegenerator.MinecraftAndesideGeneratorVariables;
import net.mcreator.minecraftandesidegenerator.MinecraftAndesideGeneratorElements;

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
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure FlyingPearlRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(FlyingpearltoolItem.block, (int) (1)).getItem())) {
			MinecraftAndesideGeneratorVariables.MapVariables
					.get(world).sense = (double) ((MinecraftAndesideGeneratorVariables.MapVariables.get(world).sense) + 1);
			MinecraftAndesideGeneratorVariables.MapVariables.get(world).syncData(world);
		}
	}
}
