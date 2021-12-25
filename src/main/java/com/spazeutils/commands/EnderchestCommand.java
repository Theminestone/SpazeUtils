package com.spazeutils.commands;

import com.spazeutils.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EnderchestCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("spazeutils.enderchestcommand.use")) {
                if (args.length == 0) {
                    player.openInventory(player.getEnderChest());
                } else if (args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target != null) {
                        player.openInventory(target.getEnderChest());
                    } else player.sendMessage(Main.prefix + ChatColor.RED + "Der Spieler " + target.getName() + " ist nicht Online!");
                } else player.sendMessage(Main.prefix + ChatColor.RED + "/ec <Spieler>");
            } else if (args.length == 0) {
                player.openInventory(player.getEnderChest());
            } else player.sendMessage(Main.prefix + ChatColor.RED + "Bitte nur /ec");
        } else sender.sendMessage(Main.prefix + ChatColor.RED + "Dieser Befehlt geht nur bei Spieler!");
        return false;
    }
}
