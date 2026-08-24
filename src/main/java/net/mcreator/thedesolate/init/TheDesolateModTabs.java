/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thedesolate.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.thedesolate.TheDesolateMod;

@EventBusSubscriber
public class TheDesolateModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TheDesolateMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> DESOLATE = REGISTRY.register("desolate",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.the_desolate.desolate")).icon(() -> new ItemStack(Blocks.POLISHED_BLACKSTONE)).displayItems((parameters, tabData) -> {
				tabData.accept(TheDesolateModBlocks.WODNER_LAND_PORTAL.get().asItem());
			}).withSearchBar().build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(TheDesolateModItems.EVILVERITY_SPAWN_EGG.get());
		}
	}
}