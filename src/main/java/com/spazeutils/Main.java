package com.spazeutils;

import com.spazeutils.commands.Enderchest;
import com.spazeutils.commands.Workbench;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin {

    public static String prefix = "§7[§6SpazeUtils§7] ";

    @Override
    public void onEnable() {
        // Plugin startup logic

        Bukkit.getConsoleSender().sendMessage(Main.prefix + "loaded!");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void register() {
        Objects.requireNonNull(getCommand("wb")).setExecutor(new Workbench());
        Objects.requireNonNull(getCommand("ec")).setExecutor(new Enderchest());
    }
}
