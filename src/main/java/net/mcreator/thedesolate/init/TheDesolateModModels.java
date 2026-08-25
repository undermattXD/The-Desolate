/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thedesolate.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.thedesolate.client.model.ModelRupturedGazeV2;
import net.mcreator.thedesolate.client.model.ModelEVILVERITYYY;

@EventBusSubscriber(Dist.CLIENT)
public class TheDesolateModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelEVILVERITYYY.LAYER_LOCATION, ModelEVILVERITYYY::createBodyLayer);
		event.registerLayerDefinition(ModelRupturedGazeV2.LAYER_LOCATION, ModelRupturedGazeV2::createBodyLayer);
	}
}