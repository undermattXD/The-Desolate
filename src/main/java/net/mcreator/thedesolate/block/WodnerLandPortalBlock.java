package net.mcreator.thedesolate.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.thedesolate.procedures.WodnerLandPortalEntityCollidesInTheBlockProcedure;

public class WodnerLandPortalBlock extends Block {
	public WodnerLandPortalBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.BONE_BLOCK).strength(1f, 10f).lightLevel(blockstate -> 15).noCollision().postProcess((bs, br, bp) -> bp).emissiveRendering((bs, br, bp) -> true));
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity, InsideBlockEffectApplier insideBlockEffectApplier, boolean isPrecise) {
		super.entityInside(blockstate, world, pos, entity, insideBlockEffectApplier, isPrecise);
		WodnerLandPortalEntityCollidesInTheBlockProcedure.execute(entity);
	}
}