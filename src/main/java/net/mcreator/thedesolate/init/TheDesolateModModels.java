/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thedesolate.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.thedesolate.client.model.ModelRupturedGaze;
import net.mcreator.thedesolate.client.model.ModelEVILVERITYYY;

@EventBusSubscriber(Dist.CLIENT)
public class TheDesolateModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelEVILVERITYYY.LAYER_LOCATION, ModelEVILVERITYYY::createBodyLayer);
		event.registerLayerDefinition(ModelRupturedGaze.LAYER_LOCATION, ModelRupturedGaze::createBodyLayer);
	}
}