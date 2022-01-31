package com.ryuservers.api.utils;

import com.ryuservers.api.RyuAPI;
import org.bukkit.ChatColor;

public class ConsoleMessage {
    public static void sendConsoleMessage(String message, ChatColor color) {
          RyuAPI.getInstance().getServer().getConsoleSender().sendMessage(color + RyuAPI.pluginPrefix + message);
    }

    public static void sendConsoleMessage(String message) {
        RyuAPI.getInstance().getServer().getConsoleSender().sendMessage(  RyuAPI.pluginPrefix + message);
    }

    public static void empty() {
        RyuAPI.getInstance().getServer().getConsoleSender().sendMessage(" ");
    }
}
