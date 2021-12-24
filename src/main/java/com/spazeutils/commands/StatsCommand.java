package com.spazeutils.commands;

import com.spazeutils.Main;
import net.minecraft.server.MinecraftServer;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class StatsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

//        sender.sendMessage(ChatColor.GOLD + "-------- " + ChatColor.RESET + Main.prefix + ChatColor.GOLD + "--------");
//        sender.sendMessage("Total Uptime: " + Main.getPlugin().getConfig().getInt("stats.uptime_total") + " Minutes");
//        sender.sendMessage("Uptime: " + Main.getPlugin().getConfig().getInt("stats.uptime") + " Minutes");
//        sender.sendMessage("TPS: " + MinecraftServer.TPS + " Ticks per Second");
//        sender.sendMessage("Free Memory: " + (Runtime.getRuntime().freeMemory() / 1000000) + " MB"); // or 1024000 ?
//        sender.sendMessage("Total Memory: " + (Runtime.getRuntime().totalMemory() / 1000000) + " MB"); // or 1024000 ?
//        sender.sendMessage("Used Memory: " + (((int) Runtime.getRuntime().totalMemory() - (int) Runtime.getRuntime().freeMemory()) / 1000000) + " MB"); // or 1024000 ?
//        sender.sendMessage("Available Processors: " + Runtime.getRuntime().availableProcessors());

        //TODO edit Design
        sender.sendMessage(ChatColor.GOLD + "------" + ChatColor.RESET + Main.prefix + ChatColor.GOLD + "-----\n" + ChatColor.AQUA +
                "Total Uptime: " + ChatColor.BOLD + Main.getPlugin().getConfig().getInt("stats.uptime_total") + ChatColor.AQUA + " Minutes\n" +
                "Uptime: " + ChatColor.BOLD + Main.getPlugin().getConfig().getInt("stats.uptime") + ChatColor.AQUA + " Minutes\n" +
                "TPS: " + ChatColor.BOLD + MinecraftServer.TPS + ChatColor.AQUA + " Ticks per Second\n" +
                "Free Memory: " + ChatColor.BOLD + (Runtime.getRuntime().freeMemory() / 1000000) + ChatColor.AQUA + " MB\n" +
                "Total Memory: " + ChatColor.BOLD + (Runtime.getRuntime().totalMemory() / 1000000) + ChatColor.AQUA + " MB\n" +
                "Used Memory: " + ChatColor.BOLD + (((int) Runtime.getRuntime().totalMemory() - (int) Runtime.getRuntime().freeMemory()) / 1000000) + ChatColor.AQUA + " MB\n" +
                "Available Processors: " + ChatColor.BOLD + Runtime.getRuntime().availableProcessors());

        return false;
    }
}