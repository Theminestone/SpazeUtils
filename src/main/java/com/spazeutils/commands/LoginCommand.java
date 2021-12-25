package com.spazeutils.commands;

import com.spazeutils.Main;
import com.spazeutils.utils.Spaze64;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class LoginCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                player.sendMessage(Main.prefix + ChatColor.RED + "Please use '/login [password]' or '/login [old pw] [new pw]'.");
            } else if (args.length == 1) {
                if (Spaze64.checkPlayerPassword(player)) {
                    if (Spaze64.comparePlayerPassword(player, args[0])) {
                        player.sendMessage(Main.prefix + ChatColor.GREEN + "Successfully logged in.");
                        player.sendMessage(ChatColor.AQUA + "Welcome back, " + ChatColor.BOLD + player.getDisplayName());
                        loginPlayer(player);
                    } else {
                        player.sendMessage(Main.prefix + ChatColor.RED + "Incorrect password. Try again!");
                    }
                } else {
                    Spaze64.setPlayerPassword(player, args[0]);
                    player.sendMessage(Main.prefix + ChatColor.GREEN + "Successfully registered " + player.getDisplayName());
                    player.sendMessage(ChatColor.AQUA + "Welcome, " + ChatColor.BOLD + player.getDisplayName());
                    loginPlayer(player);
                }
            } else if (args.length == 2) {
                if (Spaze64.checkPlayerPassword(player)) {
                    if (Spaze64.comparePlayerPassword(player, args[0])) {
                        Spaze64.setPlayerPassword(player, args[1]);
                        player.sendMessage(Main.prefix + ChatColor.GREEN + "Successfully changed password for " + player.getDisplayName());
                    } else {
                        player.sendMessage(Main.prefix + ChatColor.RED + "Incorrect password. Try again!");
                    }
                } else {
                    player.sendMessage(Main.prefix + ChatColor.RED + "Cannot change password of unregistered user.");
                }
            } else {
                player.sendMessage(Main.prefix + ChatColor.RED + "Please use '/login [password]' or '/login [old pw] [new pw]'.");
            }
        } else sender.sendMessage(Main.prefix + "Not a Player");
        return false;
    }

    public void loginPlayer(Player p) {
        Spaze64.setPlayerLoggedin(p, true);
        p.removePotionEffect(PotionEffectType.BLINDNESS);
        p.removePotionEffect(PotionEffectType.SLOW);
        Spaze64.loadPlayerLoc(p);
        p.setGameMode(GameMode.SURVIVAL);
        Spaze64.loadPlayerInv(p);
    }
}
