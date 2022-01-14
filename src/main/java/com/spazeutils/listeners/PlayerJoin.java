package com.spazeutils.listeners;

import com.spazeutils.Main;
import com.spazeutils.utils.Spaze64;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(@NotNull PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(" §a>§2>§a> " + ChatColor.GRAY + player.getName());
        Spaze64.PlayerConsoleOutput(player);
        if (Spaze64.checkPlayerLoggedin(player)) {
            if (Spaze64.getPlayerLoggedin(player)) {
                savePlayer(player);
            }
        } else {
            savePlayer(player);
        }
        clearPlayer(player);
    }

    public void clearPlayer(@NotNull Player p) {
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
}