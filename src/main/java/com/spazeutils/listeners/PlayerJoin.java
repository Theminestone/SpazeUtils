package com.spazeutils.listeners;

import com.spazeutils.Main;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();
        event.setJoinMessage(" §a>§2>§a> " + ChatColor.GRAY + player.getName());
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1f, 1f);
        player.setMetadata("su_locx", new FixedMetadataValue(Main.getPlugin(), player.getLocation().getX()));
        player.setMetadata("su_locy", new FixedMetadataValue(Main.getPlugin(), player.getLocation().getY()));
        player.setMetadata("su_locz", new FixedMetadataValue(Main.getPlugin(), player.getLocation().getZ()));

        player.setMetadata("su_loggedin", new FixedMetadataValue(Main.getPlugin(), false));
        player.setGameMode(GameMode.SPECTATOR);
        player.teleport(new Location(Bukkit.getWorld("world"), 0.5, 300, 0.5));
        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, Integer.MAX_VALUE, 256));
        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 256));
    }
}