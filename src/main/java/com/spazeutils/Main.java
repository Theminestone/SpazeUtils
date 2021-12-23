package com.spazeutils;

import com.spazeutils.commands.EnderchestCommand;
import com.spazeutils.commands.LoginCommand;
import com.spazeutils.commands.TimerCommand;
import com.spazeutils.commands.WorkbenchCommand;
import com.spazeutils.listeners.PlayerJoin;
import com.spazeutils.listeners.PlayerMove;
import com.spazeutils.listeners.PlayerQuit;
import com.spazeutils.timer.Config;
import com.spazeutils.timer.Timer;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin {

    public static String prefix = "§7[§6SpazeUtils§7] ";
    private static Main plugin;
    private static Main instance;
    private Timer timer;
    private Config config;

    @Override
    public void onLoad() {
        instance = this;
        config = new Config();
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        System.out.println();
        System.out.println();
        Bukkit.getConsoleSender().sendMessage(Main.prefix + "loaded!");
        System.out.println();
        System.out.println();

        registerCommands();
        registerListeners();
        timer = new Timer();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        timer.save();
        config.save();
    }

    public static Main getPlugin() {
        return plugin;
    }

    public static Main getInstance() {
        return instance;
    }

    public Config getConfiguration() {
        return config;
    }

    public Timer getTimer() {
        return timer;
    }

    private void registerCommands() {
        Objects.requireNonNull(getCommand("wb")).setExecutor(new WorkbenchCommand());
        Objects.requireNonNull(getCommand("ec")).setExecutor(new EnderchestCommand());
        Objects.requireNonNull(getCommand("login")).setExecutor(new LoginCommand());
        Objects.requireNonNull(getCommand("timer")).setExecutor(new TimerCommand());
    }

    private void registerListeners() {
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerQuit(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerMove(), this);
    }
}
