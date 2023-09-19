package me.neovitalism.testlistener.listeners;

import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.api.events.CaptureEvent;
import me.neovitalism.testlistener.TestListenerPlugin;
import me.neovitalism.testlistener.util.HybridUtil;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class ExampleListener {
    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    public void enableListener() {
        HybridUtil.registerListener(TestListenerPlugin.inst(), Pixelmon.EVENT_BUS, this);
        enabled = true;
    }

    public void disableListener() {
        HybridUtil.unregisterListener(TestListenerPlugin.inst(), Pixelmon.EVENT_BUS, this);
        enabled = false;
    }

    @SubscribeEvent
    public void onCapture(CaptureEvent.SuccessfulCapture event) {
        Bukkit.broadcastMessage(ChatColor.GOLD + "CaptureEvent.SuccessfulCapture fired.");
    }
}
