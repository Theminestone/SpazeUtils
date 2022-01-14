package com.spazeutils.commands;

import com.spazeutils.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InvSeeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("spazecraft.invseecommand.use")) {
                if (args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target != null) {
                        if (target != player) {
                            player.openInventory(target.getInventory());
                        } else player.openInventory(player.getInventory());
                    } else {
                        assert false;
                        player.sendMessage(Main.prefix + ChatColor.RED + "Player " + target.getName() + " is not online");
                    }
                } else player.sendMessage(Main.prefix + ChatColor.RED + "/invsee <Player>");
            } else player.sendMessage(Main.prefix + ChatColor.RED + "Error 404");
        } else sender.sendMessage(Main.prefix + ChatColor.RED + "Not a Player");
        return false;
    }
}