package com.spazeutils.commands;

import com.spazeutils.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class WorkbenchCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                player.openInventory(Objects.requireNonNull(player.openWorkbench(null, true)));
            } else player.sendMessage(Main.prefix + ChatColor.RED + "Please use /wb");
        } else sender.sendMessage(Main.prefix + "Not a Player");

        return false;
    }
}
