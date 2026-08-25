package net.mcreator.thedesolate.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.thedesolate.network.TheDesolateModVariables;
import net.mcreator.thedesolate.init.TheDesolateModEntities;

import javax.annotation.Nullable;

@EventBusSubscriber
public class SpawnGazeProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!(world instanceof Level _lvl0 && _lvl0.isBrightOutside())) {
			if (TheDesolateModVariables.MapVariables.get(world).Has_Gaze_sapwned_tonight == false) {
				if (Math.random() <= 0.001) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDesolateModEntities.RUPTURED_GAZE.get().spawn(_level,
								BlockPos.containing(entity.getX() + entity.getLookAngle().x * (-15),
										world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (entity.getX() + entity.getLookAngle().x * (-15)), (int) (entity.getZ() + entity.getLookAngle().z * (-15))) + 1,
										entity.getZ() + entity.getLookAngle().z * (-15)),
								EntitySpawnReason.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(entity.getYRot());
							entityToSpawn.setYBodyRot(entity.getYRot());
							entityToSpawn.setYHeadRot(entity.getYRot());
							entityToSpawn.setXRot(entity.getXRot());
							entityToSpawn.setDeltaMovement(0, 0, 0);
						}
					}
				}
				TheDesolateModVariables.MapVariables.get(world).Has_Gaze_sapwned_tonight = true;
				TheDesolateModVariables.MapVariables.get(world).markSyncDirty();
			}
		} else {
			TheDesolateModVariables.MapVariables.get(world).Has_Gaze_sapwned_tonight = false;
			TheDesolateModVariables.MapVariables.get(world).markSyncDirty();
		}
	}
}