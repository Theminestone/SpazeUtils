package com.spazeutils;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        Bukkit.getConsoleSender().sendMessage("Menga");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
