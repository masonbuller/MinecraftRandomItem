package org.maseunknown.plugins.randomitem2;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class RandomItem2 extends JavaPlugin {
    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getServer().getPluginCommand("randomizer").setExecutor(new RandomItemCommand(this));
        this.getCommand("randomizer").setTabCompleter(new RandomItemCompleter());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
