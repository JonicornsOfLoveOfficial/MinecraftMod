
package net.mcreator.minecraftandesidegenerator.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.util.DamageSource;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.minecraftandesidegenerator.procedures.SoulRightClickedOnEntityProcedure;
import net.mcreator.minecraftandesidegenerator.MinecraftAndesideGeneratorElements;

@MinecraftAndesideGeneratorElements.ModElement.Tag
public class SoulEntity extends MinecraftAndesideGeneratorElements.ModElement {
	public static EntityType entity = null;
	public SoulEntity(MinecraftAndesideGeneratorElements instance) {
		super(instance, 16);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("soul")
						.setRegistryName("soul");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -1, -1, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("soul"));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(CustomEntity.class, renderManager -> {
			return new MobRenderer(renderManager, new Modeltest(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("minecraftandesidegenerator:textures/oul.png");
				}
			};
		});
	}
	public static class CustomEntity extends CreatureEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 5;
			setNoAI(true);
			enablePersistence();
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public boolean canDespawn(double distanceToClosestPlayer) {
			return false;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public boolean processInteract(PlayerEntity entity, Hand hand) {
			super.processInteract(entity, hand);
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			ItemStack itemstack = entity.getHeldItem(hand);
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				SoulRightClickedOnEntityProcedure.executeProcedure($_dependencies);
			}
			return true;
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
		}
	}

	// Made with Blockbench
	// Paste this code into your mod.
	// Make sure to generate all required imports
	public static class Modeltest extends EntityModel<Entity> {
		private final RendererModel bb_main;
		public Modeltest() {
			textureWidth = 16;
			textureHeight = 16;
			bb_main = new RendererModel(this);
			bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
			bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -6.0F, -15.0F, -7.0F, 12, 13, 13, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			bb_main.render(f5);
		}

		public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4, float f5) {
			super.setRotationAngles(e, f, f1, f2, f3, f4, f5);
			this.bb_main.rotateAngleY = f2 / 20.f;
		}
	}
}
