package com.spazeutils.commands;

import com.spazeutils.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class StatsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(Main.prefix + "Total uptime: " + Main.getPlugin().getConfig().getInt("stats.uptime_total") + " Minutes");
        sender.sendMessage(Main.prefix + "Uptime: " + Main.getPlugin().getConfig().getInt("stats.uptime") + " Minutes");
        return false;
    }
}
