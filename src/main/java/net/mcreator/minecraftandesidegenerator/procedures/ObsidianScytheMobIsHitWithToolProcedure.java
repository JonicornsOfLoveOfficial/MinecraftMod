package net.mcreator.minecraftandesidegenerator.procedures;

import net.minecraft.world.World;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.minecraftandesidegenerator.entity.SoulEntity;
import net.mcreator.minecraftandesidegenerator.MinecraftAndesideGeneratorElements;

@MinecraftAndesideGeneratorElements.ModElement.Tag
public class ObsidianScytheMobIsHitWithToolProcedure extends MinecraftAndesideGeneratorElements.ModElement {
	public ObsidianScytheMobIsHitWithToolProcedure(MinecraftAndesideGeneratorElements instance) {
		super(instance, 17);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ObsidianScytheMobIsHitWithTool!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure ObsidianScytheMobIsHitWithTool!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure ObsidianScytheMobIsHitWithTool!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure ObsidianScytheMobIsHitWithTool!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure ObsidianScytheMobIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) == 0)) {
			if (!world.isRemote) {
				Entity entityToSpawn = new SoulEntity.CustomEntity(SoulEntity.entity, world);
				entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0);
				world.addEntity(entityToSpawn);
			}
		}
	}
}
