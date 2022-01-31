package com.ryuservers.api.utils;

import org.bukkit.ChatColor;

public class ConsoleDefaultMessages {
    public static void startHeader() {
        ConsoleMessage.empty();
        ConsoleMessage.sendConsoleMessage("------------------------------------------", ChatColor.GREEN);
        ConsoleMessage.sendConsoleMessage("Loading plugin", ChatColor.GREEN);
        ConsoleMessage.empty();
    }

    public static void startFooter(long time) {
        ConsoleMessage.empty();
        ConsoleMessage.sendConsoleMessage("Plugin loaded successfully in " + time + " ms!", ChatColor.GREEN);
        ConsoleMessage.sendConsoleMessage("------------------------------------------", ChatColor.GREEN);
        ConsoleMessage.empty();
    }
    public static void end() {
        ConsoleMessage.empty();
        ConsoleMessage.sendConsoleMessage("------------------------------------------", ChatColor.RED);
        ConsoleMessage.sendConsoleMessage("Plugin unloaded successfully!", ChatColor.RED);
        ConsoleMessage.sendConsoleMessage("------------------------------------------", ChatColor.RED);
        ConsoleMessage.empty();
    }
}
