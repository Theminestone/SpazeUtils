package com.spazeutils.commands;

import com.spazeutils.Main;
import net.minecraft.server.MinecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class StatsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        sender.sendMessage(ChatColor.GOLD + "-------- " + ChatColor.RESET + Main.prefix + ChatColor.GOLD + "--------" + ChatColor.RESET);
        sender.sendMessage(ChatColor.AQUA + "Total Uptime:    " + ChatColor.GREEN + Main.getPlugin().getConfig().getInt("stats.uptime_total") + " Minutes");
        sender.sendMessage(ChatColor.AQUA + "Uptime:            " + ChatColor.GREEN + Main.getPlugin().getConfig().getInt("stats.uptime") + " Minutes");
        sender.sendMessage(ChatColor.AQUA + "TPS:               " + ChatColor.GREEN + MinecraftServer.TPS + " Ticks");
        sender.sendMessage(ChatColor.AQUA + "Free Memory:   " + ChatColor.GREEN + (Runtime.getRuntime().freeMemory() / 1000000) + " MB"); // or 1024000 ?
        sender.sendMessage(ChatColor.AQUA + "Total Memory:   " + ChatColor.GREEN + (Runtime.getRuntime().totalMemory() / 1000000) + " MB"); // or 1024000 ?
        sender.sendMessage(ChatColor.AQUA + "Used Memory:   " + ChatColor.GREEN + (((int) Runtime.getRuntime().totalMemory() - (int) Runtime.getRuntime().freeMemory()) / 1000000) + " MB"); // or 1024000 ?
        sender.sendMessage(ChatColor.AQUA + "Processors:    " + ChatColor.GREEN + Runtime.getRuntime().availableProcessors());
        sender.sendMessage(ChatColor.AQUA + "Online " + Bukkit.getServer().getOnlinePlayers().size());

        return false;
    }
}