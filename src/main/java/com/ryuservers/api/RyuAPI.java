package com.ryuservers.api;

import com.ryuservers.api.commands.Commands;
import com.ryuservers.api.commands.MainCommand;
import com.ryuservers.api.utils.ConsoleDefaultMessages;
import com.ryuservers.api.utils.ConsoleMessage;
import com.ryuservers.api.utils.http.RyuAPIConfiguration;
import com.ryuservers.api.utils.http.SparkIntegrator;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class RyuAPI extends JavaPlugin {
    public static FileConfiguration config;
    public static String pluginPrefix = "§f[§cRyu§7API§f] ";
    public static String prefix;

    private RyuAPIConfiguration configuration;
    private SparkIntegrator integrator;

    private static RyuAPI instance;
    public static RyuAPI getInstance() {
        return RyuAPI.instance;
    }

    public RyuAPI() {
        RyuAPI.instance = this;
    }

    @Override
    public void onEnable() {
        RyuAPI.config = this.getConfig();
        RyuAPI.prefix = this.config.getString("prefix").replaceAll("&", "§");

        long startTime = System.currentTimeMillis();
        ConsoleDefaultMessages.startHeader();

        ConsoleMessage.sendConsoleMessage("Setting configs...", ChatColor.YELLOW);
        setupConfigs();
        this.configuration = new RyuAPIConfiguration(RyuAPI.config, this);
        this.configuration.registerDefaults();
        this.configuration.saveDefaultConfigIfNotExist();
        this.configuration.saveDefaultEntryPoints();

        ConsoleMessage.sendConsoleMessage("Setting listeners...", ChatColor.YELLOW);
        setupListeners();

        ConsoleMessage.sendConsoleMessage("Setting integrators...", ChatColor.YELLOW);
        this.integrator = SparkIntegrator.getInstance();
//        this.integrator.configureFromConfig(configuration);

        ConsoleMessage.sendConsoleMessage("Setting commands...", ChatColor.YELLOW);
        String command = RyuAPI.config.getString("mainCommand");
        ConsoleMessage.sendConsoleMessage("The plugin's default command is " + command);
        Commands.registerCommand(command, new MainCommand(command));

        long endTime = System.currentTimeMillis() - startTime;
        ConsoleDefaultMessages.startFooter(endTime);
    }


    @Override
    public void onDisable() {
        ConsoleDefaultMessages.end();
    }

    private void setupConfigs() {
        saveDefaultConfig();
    }

    private void setupListeners() {
        //Bukkit.getPluginManager().registerEvents(, this);
    }

    private void setupCommands() {}

    public void setPluginEnabled(boolean enabled) {
        this.setEnabled(enabled);
    }
}
