package com.spazeutils.commands;

import com.spazeutils.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Enderchest implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                player.openInventory(player.getEnderChest());
            } else player.sendMessage(Main.prefix + ChatColor.RED + "Bitte nur /wb eingeben");
        } else sender.sendMessage(Main.prefix + "Dieser Befehl funktioniert nur bei Spieler!");

        return false;
    }
}
