/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thedesolate.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

import net.mcreator.thedesolate.block.PenisblockBlock;
import net.mcreator.thedesolate.block.CockblockBlock;
import net.mcreator.thedesolate.TheDesolateMod;

import java.util.function.Function;

public class TheDesolateModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(TheDesolateMod.MODID);
	public static final DeferredBlock<Block> COCKBLOCK;
	public static final DeferredBlock<Block> PENISBLOCK;
	static {
		COCKBLOCK = register("cockblock", CockblockBlock::new);
		PENISBLOCK = register("penisblock", PenisblockBlock::new);
	}

	// Start of user code block custom blocks
	// End of user code block custom blocks
	private static <B extends Block> DeferredBlock<B> register(String name, Function<BlockBehaviour.Properties, ? extends B> supplier) {
		return REGISTRY.registerBlock(name, supplier);
	}
}