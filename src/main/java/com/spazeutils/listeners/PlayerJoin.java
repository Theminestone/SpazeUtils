package com.spazeutils.listeners;

import com.spazeutils.Main;
import com.spazeutils.utils.Spaze64;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(" §a>§2>§a> " + ChatColor.GRAY + player.getName());
        PlayerConsoleOutput(player);
        if (Spaze64.checkPlayerLoggedin(player)) {
            if (Spaze64.getPlayerLoggedin(player)) {
                savePlayer(player);
            }
        } else {
            savePlayer(player);
        }
        clearPlayer(player);
    }

    public void clearPlayer(Player p) {
        p.getInventory().clear();
        p.setGameMode(GameMode.SPECTATOR);
        p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, Integer.MAX_VALUE, 256));
        p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 256));
        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1f, 1f);
        p.sendMessage(Main.prefix + ChatColor.DARK_AQUA + "Log in via '/login [password]'");
        Spaze64.setPlayerLoggedin(p, true);
        p.teleport(new Location(p.getWorld(), 0.5, 300, 0.5));
        Spaze64.setPlayerLoggedin(p, false);
    }

    public void savePlayer(Player p) {
        Spaze64.savePlayerLoc(p);
        Spaze64.savePlayerInv(p);
    }

    public void PlayerConsoleOutput(Player p) {
        Bukkit.getConsoleSender().sendMessage("");

        Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "Player " + p.getName() + " has joined the Server.");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "Here's some information: ");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "Location: " + "X: " + p.getLocation().getX() + ", Y: " + p.getLocation().getY() + ", Z: " + p.getLocation().getZ());
        Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "Health: " + Math.round(p.getHealth()));
        Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "FoodLevel: " + p.getFoodLevel());
        Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "BedSpawnLocation: " + p.getBedSpawnLocation());
        Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "Exp: " + p.getExp());
        Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "TotalExperience: " + p.getTotalExperience());
        Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "World: " + p.getWorld().getName());
        Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "View Distance: " + p.getClientViewDistance());
        Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "Velocity: " + p.getVelocity());
        Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "Fly speed: " + p.getFlySpeed());
        Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "Player Time Offset: " + p.getPlayerTimeOffset());
        Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "Walk speed: " + p.getWalkSpeed());
        Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "Server: " + p.getServer());

        Bukkit.getConsoleSender().sendMessage("");
    }
}