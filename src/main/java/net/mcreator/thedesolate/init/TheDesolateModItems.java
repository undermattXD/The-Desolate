/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thedesolate.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.thedesolate.TheDesolateMod;

import java.util.function.Function;

public class TheDesolateModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(TheDesolateMod.MODID);
	public static final DeferredItem<Item> COCKBLOCK;
	public static final DeferredItem<Item> EVILVERITY_SPAWN_EGG;
	static {
		COCKBLOCK = block(TheDesolateModBlocks.COCKBLOCK);
		EVILVERITY_SPAWN_EGG = register("evilverity_spawn_egg", properties -> new SpawnEggItem(properties.spawnEgg(TheDesolateModEntities.EVILVERITY.get())));
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
		return REGISTRY.registerItem(name, supplier, Item.Properties::new);
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.registerItem(block.getId().getPath(), prop -> new BlockItem(block.get(), prop), () -> properties);
	}
}