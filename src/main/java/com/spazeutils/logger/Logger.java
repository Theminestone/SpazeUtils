package com.spazeutils.logger;

import com.spazeutils.Main;
import org.bukkit.scheduler.BukkitRunnable;

public class Logger {
    Timer timer;

    public Logger() {
        timer = new Timer();
        saver();
    }

    public void save() {
        Main.getPlugin().getConfig().set("stats.uptime_total", Timer.uptime_total);
        Main.getPlugin().getConfig().set("stats.uptime", Timer.uptime);
        Main.getPlugin().saveConfig();
    }

    private void saver() {
        new BukkitRunnable() {
            @Override
            public void run() {
                save();
            }
        }.runTaskTimer(Main.getPlugin(), 0, 1200);
    }
}