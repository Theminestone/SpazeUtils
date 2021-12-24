package com.spazeutils.commands;

import com.spazeutils.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.io.BukkitObjectInputStream;

import java.io.ByteArrayInputStream;
import java.util.Base64;
import java.util.List;

public class LoginCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                player.sendMessage(Main.prefix + ChatColor.RED + "Please use '/login [password]' or '/login [old pw] [new pw]'.");
            } else if (args.length == 1) {
                if (player.hasMetadata("spazeutils_password")) {
                    List<MetadataValue> values = player.getMetadata("spazeutils_password");
                    if (!values.isEmpty() && values.get(0).asString().equals(args[0])) {
                        player.sendMessage(Main.prefix + ChatColor.GREEN + "Successfully logged in.");
                        player.sendMessage(ChatColor.AQUA + "Welcome back, " + ChatColor.BOLD + player.getDisplayName());
                        loginPlayer(player);
                    } else {
                        player.sendMessage(Main.prefix + ChatColor.RED + "Incorrect password. Try again!");
                    }
                } else {
                    player.setMetadata("spazeutils_password", new FixedMetadataValue(Main.getPlugin(), args[0]));
                    player.sendMessage(Main.prefix + ChatColor.GREEN + "Successfully registered " + player.getDisplayName());
                    player.sendMessage(ChatColor.AQUA + "Welcome, " + ChatColor.BOLD + player.getDisplayName());
                    loginPlayer(player);
                }
            } else if (args.length == 2) {
                if (player.hasMetadata("spazeutils_password")) {
                    List<MetadataValue> values = player.getMetadata("spazeutils_password");
                    if (!values.isEmpty() && values.get(0).asString().equals(args[0])) {
                        player.setMetadata("spazeutils_password", new FixedMetadataValue(Main.getPlugin(), args[1]));
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
        p.setMetadata("su_loggedin", new FixedMetadataValue(Main.getPlugin(), true));
        p.removePotionEffect(PotionEffectType.BLINDNESS);
        p.removePotionEffect(PotionEffectType.SLOW);
        p.teleport(new Location(p.getWorld(), p.getMetadata("su_locx").get(0).asFloat(), p.getMetadata("su_locy").get(0).asFloat(), p.getMetadata("su_locz").get(0).asFloat()));
        p.setGameMode(GameMode.SURVIVAL);

        // https://bukkit.org/threads/encoding-inventory-with-base64.457805/
        try {
            ByteArrayInputStream stream = new ByteArrayInputStream(Base64.getDecoder().decode(p.getMetadata("su_inv").get(0).asString()));
            BukkitObjectInputStream data = new BukkitObjectInputStream(stream);
            for (int i = 0; i < p.getInventory().getSize(); i++) {
                p.getInventory().setItem(i, (ItemStack) data.readObject());
            }
            data.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
