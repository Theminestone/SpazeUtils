package com.spazeutils.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.metadata.MetadataValue;

import java.util.List;

public class PlayerMove implements Listener {

    @EventHandler
    public void onPlayMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        List<MetadataValue> values = player.getMetadata("su_loggedin");
        if (!values.isEmpty() && !values.get(0).asBoolean()) {
            event.setCancelled(true);
        }
    }

}
