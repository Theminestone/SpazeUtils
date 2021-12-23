package com.spazeutils.commands;

import com.spazeutils.Main;
import net.minecraft.server.MinecraftServer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class StatsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("--------" + Main.prefix + "--------");
        sender.sendMessage("Total Uptime: " + Main.getPlugin().getConfig().getInt("stats.uptime_total") + " Minutes");
        sender.sendMessage("Uptime: " + Main.getPlugin().getConfig().getInt("stats.uptime") + " Minutes");
        sender.sendMessage("TPS: " + MinecraftServer.TPS);
        sender.sendMessage("Memory Usage: " + Runtime.getRuntime().freeMemory());
        sender.sendMessage("Available Processors: " + Runtime.getRuntime().availableProcessors());
        return false;
    }
}