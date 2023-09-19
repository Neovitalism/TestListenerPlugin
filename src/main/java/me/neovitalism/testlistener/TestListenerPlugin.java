package me.neovitalism.testlistener;

import me.neovitalism.testlistener.commands.TestListenerCommand;
import me.neovitalism.testlistener.events.ExampleEvent;
import me.neovitalism.testlistener.listeners.ExampleListener;
import me.neovitalism.testlistener.util.HybridUtil;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class TestListenerPlugin extends JavaPlugin {
    private static TestListenerPlugin instance;
    public ExampleListener exampleListener = new ExampleListener();

    @Override
    public void onEnable() {
        instance = this;
        HybridUtil.checkPlatform();
        new TestListenerCommand();
        HybridUtil.registerListener(this, MinecraftForge.EVENT_BUS, this);
    }

    @Override
    public void onDisable() {
        exampleListener.disableListener();
        HybridUtil.unregisterListener(this, MinecraftForge.EVENT_BUS, this);
    }

    public static TestListenerPlugin inst() {
        return instance;
    }

    @SubscribeEvent
    public void onExampleEvent(ExampleEvent event) {
        Bukkit.broadcastMessage(ChatColor.GOLD + "ExampleEvent fired.");
    }
}
