package net.mcreator.thedesolate.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.permissions.LevelBasedPermissionSet;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.Identifier;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.thedesolate.network.TheDesolateModVariables;
import net.mcreator.thedesolate.TheDesolateMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class MansionSpawnProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (TheDesolateModVariables.MapVariables.get(world).firstload) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, new Vec3(2024, 0, 720), Vec2.ZERO, _level, LevelBasedPermissionSet.OWNER, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"forceload add 2024 720 2024 720");
			TheDesolateMod.queueServerWork(200, () -> {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(Identifier.fromNamespaceAndPath("the_desolate", "mansionv1"));
					if (template != null) {
						template.placeInWorld(_serverworld, new BlockPos(2024, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, 2024, 720), 720),
								new BlockPos(2024, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, 2024, 720), 720), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
								_serverworld.getRandom(), 3);
					}
				}
				TheDesolateModVariables.MapVariables.get(world).firstload = false;
				TheDesolateModVariables.MapVariables.get(world).markSyncDirty();
			});
		}
	}
}