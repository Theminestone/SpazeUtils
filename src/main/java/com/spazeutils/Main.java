package com.spazeutils;

import com.spazeutils.commands.*;
import com.spazeutils.listeners.PlayerJoin;
import com.spazeutils.listeners.PlayerLogin;
import com.spazeutils.listeners.PlayerMove;
import com.spazeutils.listeners.PlayerQuit;
import com.spazeutils.logger.Logger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin {

    public static String prefix = "§1[§6SpazeUtils§1] ";
    private static Main plugin;
    private Logger logger;

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
        Objects.requireNonNull(getCommand("rules")).setExecutor(new InvSeeCommand());


    }

    private void registerListeners() {

        Bukkit.getPluginManager().registerEvents(new PlayerQuit(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerMove(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerLogin(), this);
    }
}
