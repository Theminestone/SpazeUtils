package com.spazeutils.listeners;

import com.spazeutils.utils.Spaze64;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.jetbrains.annotations.NotNull;

public class PlayerMove implements Listener {

    @EventHandler
    public void onPlayMove(@NotNull PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (!Spaze64.getPlayerLoggedin(player)) {
            event.setCancelled(true);
        }
    }
}
