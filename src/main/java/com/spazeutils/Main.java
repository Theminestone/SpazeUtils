package com.spazeutils;

import com.spazeutils.commands.Enderchest;
import com.spazeutils.commands.Login;
import com.spazeutils.commands.Workbench;
import com.spazeutils.listeners.PlayerMove;
import com.spazeutils.listeners.PlayerJoin;
import com.spazeutils.listeners.PlayerQuit;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.Objects;

public final class Main extends JavaPlugin {

    public static String prefix = "§7[§6SpazeUtils§7] ";
    private static Main plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        Bukkit.getConsoleSender().sendMessage(Main.prefix + "loaded!");
        registerCommands();
        registerListeners();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Main getPlugin() {
        return plugin;
    }

    private void registerCommands() {
        Objects.requireNonNull(getCommand("wb")).setExecutor(new Workbench());
        Objects.requireNonNull(getCommand("ec")).setExecutor(new Enderchest());
        Objects.requireNonNull(getCommand("login")).setExecutor(new Login());
    }

    private void registerListeners() {
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerQuit(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerMove(), this);
    }
}
