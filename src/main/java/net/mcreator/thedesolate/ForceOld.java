package net.mcreator.thedesolate;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.PackType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.AddPackFindersEvent;

@EventBusSubscriber(
        modid = "indomitable",
        value = Dist.CLIENT
)
public class ForceOld {

    @SubscribeEvent
    public static void addPack(AddPackFindersEvent event) {
        if (event.getPackType() != PackType.CLIENT_RESOURCES) return;

        event.addPackFinders(
                Identifier.fromNamespaceAndPath("indomitable", "resourcepacks/myresourcepack"),
                PackType.CLIENT_RESOURCES,
                Component.literal("nostalgia pack"),
                net.minecraft.server.packs.repository.PackSource.BUILT_IN,
                true,
                net.minecraft.server.packs.repository.Pack.Position.TOP
        );
    }
}