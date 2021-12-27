package com.spazeutils.commands;

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
                sender.sendMessage(ChatColor.RED + "Please use 'info <Player>'.");
            } else if (args.length == 1) {
                Player player = Bukkit.getPlayer(args[0]);
                if (player != null) {
                    //Aufruf von PlayerConsoleOutput in PlayerJoin

                    PlayerConsoleOutput(player);


                } else sender.sendMessage("Player off");
            }
        }
        return false;
    }

    public void PlayerConsoleOutput(Player p) {
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "Player " + p.getName() + " has joined the Server.");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "Here a few Informations: ");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "Location: " + "X: " + p.getLocation().getX() + ", Y: " + p.getLocation().getY() + ", Z: " + p.getLocation().getZ());
        Bukkit.getConsoleSender().sendMessage("Health: " + Math.round(p.getHealth()));
        Bukkit.getConsoleSender().sendMessage("FoodLevel: " + p.getFoodLevel());
        Bukkit.getConsoleSender().sendMessage("BedSpawnLocation: " + p.getBedSpawnLocation());
        Bukkit.getConsoleSender().sendMessage("Exp: " + p.getExp());
        Bukkit.getConsoleSender().sendMessage("TotalExperience: " + p.getTotalExperience());
        Bukkit.getConsoleSender().sendMessage("World: " + p.getWorld().getName());
        Bukkit.getConsoleSender().sendMessage("World: " + p.getClientViewDistance());
        Bukkit.getConsoleSender().sendMessage("World: " + p.getVelocity());
        Bukkit.getConsoleSender().sendMessage("World: " + p.getFlySpeed());
        Bukkit.getConsoleSender().sendMessage("World: " + p.getPlayerTimeOffset());
        Bukkit.getConsoleSender().sendMessage("World: " + p.getWalkSpeed());
        Bukkit.getConsoleSender().sendMessage("World: " + p.getServer());

        Bukkit.getConsoleSender().sendMessage("");
    }
}
