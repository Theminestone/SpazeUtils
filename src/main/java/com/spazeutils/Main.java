package com.spazeutils;

import com.spazeutils.commands.*;
import com.spazeutils.listeners.*;
import com.spazeutils.logger.Logger;
import com.spazeutils.utils.Spaze64;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Objects;

public final class Main extends JavaPlugin {

    public static String prefix = "§1[§6SpazeUtils§1] ";
    public static Spaze64 data;
    private static Main plugin;
    private Logger logger;
    public static HashMap<String, String> passwords;
    public static HashMap<String, Location> locations;
    public static HashMap<String, Boolean> loggedins;
    public static HashMap<String, String> inventories;

    @Override
    public void onLoad() {
        plugin = this;
    }

    @Override
    public void onEnable() {

        System.out.println();
        Bukkit.getConsoleSender().sendMessage(Main.prefix + ChatColor.GREEN + "loaded!");
        System.out.println();
        registerCommands();
        registerListeners();
        logger = new Logger();
        plugin.saveDefaultConfig();
        Spaze64.load();
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
        Objects.requireNonNull(getCommand("ping")).setExecutor(new PingCommand());
        Objects.requireNonNull(getCommand("pw")).setExecutor(new PasswordCommand());
        Objects.requireNonNull(getCommand("rules")).setExecutor(new RulesCommand());
        Objects.requireNonNull(getCommand("invsee")).setExecutor(new InvSeeCommand());
        Objects.requireNonNull(getCommand("info")).setExecutor(new InfoCommand());
    }

    private void registerListeners() {
        Bukkit.getPluginManager().registerEvents(new PlayerQuit(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerMove(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerLogin(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerTeleport(), this);
    }
}
