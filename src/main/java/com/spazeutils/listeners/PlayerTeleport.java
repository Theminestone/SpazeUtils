package com.spazeutils.listeners;

import com.spazeutils.Main;
import com.spazeutils.utils.Spaze64;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class PlayerTeleport implements Listener {

    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent event) {
        Player player = event.getPlayer();
        if (!Spaze64.getPlayerLoggedin(player)) {
            event.setCancelled(true);
        }
    }
}
