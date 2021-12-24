package com.spazeutils.commands;

import com.spazeutils.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PingCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                player.sendMessage(Main.prefix + ChatColor.GREEN + "Your Ping is: " + ChatColor.BOLD + player.getPing() + ChatColor.GREEN + " ms");
            } else if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target != null) {
                    player.sendMessage(Main.prefix + ChatColor.GREEN + target.getName() + " Ping is: " + ChatColor.BOLD + target.getPing() + ChatColor.GREEN + " ms");
                } else player.sendMessage(ChatColor.RED + "Player doesnt exist");
            }
        } else sender.sendMessage(ChatColor.RED + "Not a Player");
        return false;
    }
}
