package com.spazeutils.listeners;

import com.spazeutils.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import java.util.ArrayList;
import java.util.Objects;

public class PlayerLogin implements Listener {

    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event) {
        Player player = event.getPlayer();
        boolean is_whitelisted = false;
        if (Main.getPlugin().getConfig().getList("whitelist") != null) {
            ArrayList whitelist = (ArrayList) Main.getPlugin().getConfig().getList("whitelist");

            for (int i = 0; i < Objects.requireNonNull(whitelist).size(); i++) {
                if (whitelist.get(i).equals(player.getDisplayName())) is_whitelisted = true;
            }
            if (!is_whitelisted) event.disallow(PlayerLoginEvent.Result.KICK_WHITELIST, "You are not whitelisted.");
        }
    }
}