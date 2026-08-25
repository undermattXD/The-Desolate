package net.mcreator.thedesolate.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class GazeAttatckProcedure {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		Entity ChargeTarget = null;
		if (entity.getPersistentData().getBooleanOr("IsCharging", false) == true) {
			entity.getPersistentData().putDouble("ChargeTimer", (entity.getPersistentData().getDoubleOr("ChargeTimer", 0) + 1));
			if (entity.getPersistentData().getDoubleOr("ChargeTimer", 0) >= 140) {
				if (!entity.level().isClientSide())
					entity.discard();
			} else {
				ChargeTarget = findEntityInWorldRange(world, Player.class, (entity.getX()), (entity.getY()), (entity.getZ()), 60);
				if (ChargeTarget == null) {
					if (!entity.level().isClientSide())
						entity.discard();
				} else {
					if (entity instanceof Mob _entity)
						_entity.getNavigation().moveTo((ChargeTarget.getX()), (ChargeTarget.getY()), (ChargeTarget.getZ()), 2);
					if ((entity.position()).distanceTo((ChargeTarget.position())) <= 1) {
						if (ChargeTarget instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 200, 2));
						if (ChargeTarget instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 200, 2));
						if (ChargeTarget instanceof LivingEntity _entity)
							_entity.setHealth(1);
						if (!entity.level().isClientSide())
							entity.discard();
					}
				}
			}
		}
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}
}