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

import java.util.Objects;

public class PasswordCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            if (args.length == 0) {
                sender.sendMessage(Main.prefix + ChatColor.RED + "Please use '/pw set [username] [pw]' or '/pw remove [username]'.");
            } else if (args.length == 2 && Objects.equals(args[0], "remove")) {
                Player target = Bukkit.getPlayer(args[1]);
                if (target == null) {
                    sender.sendMessage(Main.prefix + ChatColor.RED + "No Player named '" + args[1] + "' found.");
                } else {
                    if (Spaze64.checkPlayerPassword(target)) {
                        Spaze64.removePlayerPassword(target);
                        Spaze64.removePlayerLoggedin(target);
                    } else {
                        sender.sendMessage(Main.prefix + ChatColor.RED + "Player " + args[1] + " has not registered yet.");
                    }
                }
            } else if (args.length == 3 && Objects.equals(args[0], "set")) {
                Player target = Bukkit.getPlayer(args[1]);
                if (Bukkit.getPlayer(args[1]) == null) {
                    sender.sendMessage(Main.prefix + ChatColor.RED + "No Player named '" + args[1] + "' found.");
                } else {
                    assert target != null;
                    Spaze64.setPlayerPassword(target, args[2]);
                }
            }
        } else sender.sendMessage(Main.prefix + ChatColor.RED + "This Command is Console-Only.");
        return false;
    }
}