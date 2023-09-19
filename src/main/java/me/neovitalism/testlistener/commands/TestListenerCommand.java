package me.neovitalism.testlistener.commands;

import me.neovitalism.testlistener.TestListenerPlugin;
import me.neovitalism.testlistener.events.ExampleEvent;
import me.neovitalism.testlistener.listeners.ExampleListener;
import net.minecraftforge.common.MinecraftForge;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class TestListenerCommand extends NeoCommand {
    public TestListenerCommand() {
        super("testlistener");
    }

    @Override
    protected CommandExecutor getCommand() {
        return (commandSender, command, s, args) -> {
            if(args.length == 1) {
                if(args[0].equals("toggle-listener")) {
                    ExampleListener exampleListener = TestListenerPlugin.inst().exampleListener;
                    if (exampleListener.isEnabled()) {
                        exampleListener.disableListener();
                        Bukkit.broadcastMessage(ChatColor.RED + "ExampleListener is now " + ChatColor.BOLD + "DISABLED");
                    } else {
                        exampleListener.enableListener();
                        Bukkit.broadcastMessage(ChatColor.GREEN + "ExampleListener is now " + ChatColor.BOLD + "ENABLED");
                    }
                } else if(args[0].equals("fire-event")) {
                    MinecraftForge.EVENT_BUS.post(new ExampleEvent());
                }
            }
            return true;
        };
    }

    @Override
    protected TabCompleter getTabCompleter() {
        return (commandSender, command, s, args) -> {
            List<String> arguments = new ArrayList<>();
            if(args.length == 1) {
                arguments.add("toggle-listener");
                arguments.add("fire-event");
            }
            return StringUtil.copyPartialMatches(args[args.length-1], arguments, new ArrayList<>());
        };
    }
}
