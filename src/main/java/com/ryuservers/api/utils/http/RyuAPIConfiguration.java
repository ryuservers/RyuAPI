package com.ryuservers.api.utils.http;

import com.google.gson.Gson;
import com.ryuservers.api.RyuAPI;
import org.bukkit.Color;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.*;
import java.util.List;
import java.util.logging.Logger;

public class RyuAPIConfiguration {
    private FileConfiguration config;
    private RyuAPI context;


    public RyuAPIConfiguration(FileConfiguration config, RyuAPI aThis) {
        this.config = config;
        this.context = aThis;
    }

    public void registerDefaults() {
        for(DefaultConfigurationEntry entry: DefaultConfigurationEntry.values()) {
            config.addDefault(entry.getName(), entry.getObject());
        }
    }

    public void saveDefaultConfigIfNotExist() {
        config.options().copyDefaults(true);
        if(!context.getDataFolder().exists()) {
            context.getDataFolder().mkdirs();
        }
        if(!new File(context.getDataFolder(), "config.yml").exists()) {
            context.saveConfig();
        }
    }

    public void saveDefaultEntryPoints() {
        config.options().copyDefaults(true);
        if(!context.getDataFolder().exists()) {
            context.getDataFolder().mkdirs();
        }
        if(!new File(context.getDataFolder(), getString(DefaultConfigurationEntry.CALLS)).exists()) {
            Gson gson = Utils.getStandardGsonInstance();
            try {
                try (FileWriter writer = new FileWriter(new File(context.getDataFolder(), getString(DefaultConfigurationEntry.CALLS)))) {
                    writer.write(gson.toJson(DefaultConfigurationEntry.getDefaultCallbacks()));
                }
            } catch (IOException ex) {
            }
        }
    }

    public Entrypoint[] deserializeEntrypoints() {
        FileInputStream fis = null;
        Entrypoint[] rets = new Entrypoint[0];
        try {
            File file = new File(context.getDataFolder(), getString(DefaultConfigurationEntry.CALLS));
            fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();
            String str = new String(data, "UTF-8");
            rets = Utils.getStandardGsonInstance().fromJson(str, Entrypoint[].class);

        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        return rets;
    }

    public Object get(DefaultConfigurationEntry path) {
        return config.get(path.getName());
    }

    public int getInt(DefaultConfigurationEntry path) {
        return config.getInt(path.getName());
    }

    public boolean getBoolean(DefaultConfigurationEntry path) {
        return config.getBoolean(path.getName());
    }

    public double getDouble(DefaultConfigurationEntry path) {
        return config.getDouble(path.getName());
    }

    public List<Boolean> getBooleanList(DefaultConfigurationEntry path) {
        return config.getBooleanList(path.getName());
    }

    public List<Byte> getByteList(DefaultConfigurationEntry path) {
        return config.getByteList(path.getName());
    }

    public List<Character> getCharacterList(DefaultConfigurationEntry path) {
        return config.getCharacterList(path.getName());
    }

    public Color getColor(DefaultConfigurationEntry path) {
        return config.getColor(path.getName());
    }

    public String getString(DefaultConfigurationEntry path) {
        return config.getString(path.getName());
    }
}
