package com.ryuservers.api.commands;

import com.ryuservers.api.RyuAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.command.defaults.BukkitCommand;

import java.lang.reflect.Field;

public class Commands {
    public static void registerCommand(String command, BukkitCommand bukkitCommand) {
        try {
            final Field bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            bukkitCommandMap.setAccessible(true);

            CommandMap commandMap = (CommandMap) bukkitCommandMap.get(Bukkit.getServer());
            commandMap.register(command, bukkitCommand);
        } catch (Exception error) {
            RyuAPI.getInstance().setPluginEnabled(false);
            throw new RuntimeException("Failed to register RyuVIP commands", error);
        }
    }

    public static void unregisterCommand(String command) {
        try {
            final Field bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            bukkitCommandMap.setAccessible(true);
            CommandMap commandMap = (CommandMap) bukkitCommandMap.get(Bukkit.getServer());
            RyuAPI.getInstance().getCommand(command).unregister(commandMap);
        } catch (Exception error) {
            RyuAPI.getInstance().setPluginEnabled(false);
            throw new RuntimeException("Failed to unregister RyuVIP commands", error);
        }
    }
}
