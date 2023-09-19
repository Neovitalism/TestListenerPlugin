package me.neovitalism.testlistener.util;

import io.izzel.arclight.api.Arclight;
import net.minecraftforge.eventbus.api.IEventBus;
import org.bukkit.plugin.java.JavaPlugin;

public final class HybridUtil {
    private static boolean arclight = false;

    private static boolean mohist = false;

    public static void checkPlatform() {
        try {
            Class.forName("io.izzel.arclight.api.Arclight");
            arclight = true;
            return;
        } catch(ClassNotFoundException ignored) {}
        try {
            Class.forName("com.mohistmc.MohistMC");
            mohist = true;
        } catch(ClassNotFoundException ignored) {}
    }

    public static void registerListener(JavaPlugin plugin, IEventBus eventBus, Object target) {
        if(arclight) {
            Arclight.registerForgeEvent(plugin, eventBus, target);
        } else if(mohist) {
            plugin.registerForgeEvent(eventBus, target);
        } else eventBus.register(target);
    }

    public static void unregisterListener(JavaPlugin plugin, IEventBus eventBus, Object target) {
        if(mohist) {
            plugin.unregisterForgeEvents(eventBus, target);
        } else eventBus.unregister(target);
    }
}
