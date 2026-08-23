/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thedesolate.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.thedesolate.client.renderer.EvilverityRenderer;

@EventBusSubscriber(Dist.CLIENT)
public class TheDesolateModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(TheDesolateModEntities.EVILVERITY.get(), EvilverityRenderer::new);
	}
}