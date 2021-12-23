package com.spazeutils.logger;

import com.spazeutils.Main;
import org.bukkit.scheduler.BukkitRunnable;

public class Timer {
    public static int uptime_total;
    public static int uptime;

    public Timer() {
        uptime_total = Main.getPlugin().getConfig().getInt("stats.uptime_total");
        uptime = 0;
        run();
    }

    private void run() {
        new BukkitRunnable() {
            @Override
            public void run() {
                uptime_total += 1;
                uptime += 1;
            }
        }.runTaskTimer(Main.getPlugin(), 1200, 1200);
    }
}
