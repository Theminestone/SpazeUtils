package com.spazeutils.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    public void onPlayerQuit(PlayerQuitEvent event) {

        Player player = event.getPlayer();
        event.setQuitMessage(" §4<§c<§4< " + ChatColor.GRAY + player.getName());
    }
}
