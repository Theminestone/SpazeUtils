package com.spazeutils.commands;

import com.spazeutils.Main;
import com.spazeutils.utils.Spaze64;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class InfoCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            if (args.length == 0) {
                sender.sendMessage(Main.prefix + ChatColor.RED + "Please use 'info <Player>'.");
            } else if (args.length == 1) {
                Player player = Bukkit.getPlayer(args[0]);
                if (player != null) {
                    Spaze64.PlayerConsoleOutput(player);
                } else sender.sendMessage(Main.prefix + ChatColor.RED + args[0] + " is not online");
            }
        } else {
            sender.sendMessage(Main.prefix + ChatColor.RED + "Error 404");
        }
        return false;
    }
}