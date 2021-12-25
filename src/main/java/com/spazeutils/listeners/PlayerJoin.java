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
        if (Spaze64.checkPlayerLoggedin(player)) {
            if (Spaze64.getPlayerLoggedin(player)) {
                savePlayer(player);
            }
        }
        else {
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
}