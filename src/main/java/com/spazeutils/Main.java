package com.spazeutils;

import com.spazeutils.commands.EnderchestCommand;
import com.spazeutils.commands.LoginCommand;
import com.spazeutils.commands.StatsCommand;
import com.spazeutils.commands.WorkbenchCommand;
import com.spazeutils.listeners.PlayerJoin;
import com.spazeutils.listeners.PlayerLogin;
import com.spazeutils.listeners.PlayerMove;
import com.spazeutils.listeners.PlayerQuit;
import com.spazeutils.logger.Logger;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin {

    public static String prefix = "§7[§6SpazeUtils§7] ";
    private static Main plugin;
    private Logger logger;

    @Override
    public void onLoad() {
        plugin = this;
    }

    @Override
    public void onEnable() {

        Bukkit.getConsoleSender().sendMessage(Main.prefix + "loaded!");

        registerCommands();
        registerListeners();

        logger = new Logger();
        plugin.saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        logger.save();
    }

    public static Main getPlugin() {
        return plugin;
    }

    private void registerCommands() {
        Objects.requireNonNull(getCommand("wb")).setExecutor(new WorkbenchCommand());
        Objects.requireNonNull(getCommand("ec")).setExecutor(new EnderchestCommand());
        Objects.requireNonNull(getCommand("login")).setExecutor(new LoginCommand());
        Objects.requireNonNull(getCommand("stats")).setExecutor(new StatsCommand());
    }

    private void registerListeners() {

        Bukkit.getPluginManager().registerEvents(new PlayerQuit(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerMove(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerLogin(), this);
    }
}
