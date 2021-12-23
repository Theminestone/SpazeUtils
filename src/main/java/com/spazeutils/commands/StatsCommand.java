package com.spazeutils.commands;

import com.spazeutils.Main;
import net.minecraft.server.MinecraftServer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;

public class StatsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(Main.prefix + "Total Uptime: " + Main.getPlugin().getConfig().getInt("stats.uptime_total") + " Minutes");
        sender.sendMessage(Main.prefix + "Uptime: " + Main.getPlugin().getConfig().getInt("stats.uptime") + " Minutes");
        sender.sendMessage(Main.prefix + "TPS: " + Arrays.toString(MinecraftServer.getServer().recentTps));
        sender.sendMessage(Main.prefix + "Memory Usage: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
        sender.sendMessage(Main.prefix + "Available Processors: " + Runtime.getRuntime().availableProcessors());
        return false;
    }
}