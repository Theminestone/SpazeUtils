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
        player.getInventory().clear();
        player.setGameMode(GameMode.SPECTATOR);
        player.teleport(new Location(player.getWorld(), 0.5, 300, 0.5));
        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, Integer.MAX_VALUE, 256));
        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 256));
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1f, 1f);
        player.sendMessage(Main.prefix + ChatColor.DARK_AQUA + "Log in via '/login [password]'");
    }

    public void savePlayer(Player p) {
        Spaze64.setPlayerLoggedin(p, false);
        Spaze64.savePlayerLoc(p);
        Spaze64.savePlayerInv(p);
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