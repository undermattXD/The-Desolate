package net.mcreator.thedesolate.client.renderer;

import net.minecraft.resources.Identifier;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.thedesolate.entity.EvilverityEntity;
import net.mcreator.thedesolate.client.model.ModelEVILVERITYYY;

public class EvilverityRenderer extends MobRenderer<EvilverityEntity, LivingEntityRenderState, ModelEVILVERITYYY> {
	private final Identifier entityTexture = Identifier.parse("the_desolate:textures/entities/steve.png");

	public EvilverityRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelEVILVERITYYY(context.bakeLayer(ModelEVILVERITYYY.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}

	@Override
	public void extractRenderState(EvilverityEntity entity, LivingEntityRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
	}

	@Override
	public Identifier getTextureLocation(LivingEntityRenderState state) {
		return entityTexture;
	}
}