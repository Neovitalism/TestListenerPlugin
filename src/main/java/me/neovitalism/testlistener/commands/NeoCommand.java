package me.neovitalism.testlistener.commands;

import me.neovitalism.testlistener.TestListenerPlugin;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;

import java.util.Objects;

public abstract class NeoCommand {
    public NeoCommand(String commandName) {
        Objects.requireNonNull(TestListenerPlugin.inst().getCommand(commandName)).setExecutor(getCommand());
        Objects.requireNonNull(TestListenerPlugin.inst().getCommand(commandName)).setTabCompleter(getTabCompleter());
    }

    protected abstract CommandExecutor getCommand();
    protected abstract TabCompleter getTabCompleter();
}
