package com.spazeutils.commands;

import com.spazeutils.Main;
import com.spazeutils.timer.Timer;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TimerCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                sendUsage(player);
                return true;
            }

            switch (args[0].toLowerCase()) {
                case "resume": {
                    Timer timer = Main.getInstance().getTimer();

                    if (timer.isRunning()) {
                        player.sendMessage(ChatColor.RED + "Der Timer läuft bereits.");
                        break;
                    }

                    timer.setRunning(true);
                    player.sendMessage(ChatColor.GRAY + "Der Timer wurde gestartet.");
                    break;
                }
                case "pause": {
                    Timer timer = Main.getInstance().getTimer();

                    if (!timer.isRunning()) {
                        player.sendMessage(ChatColor.RED + "Der Timer läuft nicht.");
                        break;
                    }

                    timer.setRunning(false);
                    player.sendMessage(ChatColor.GRAY + "Der Timer wurde gestoppt.");
                    break;
                }
                case "time": {
                    if (args.length != 2) {
                        player.sendMessage(ChatColor.GRAY + "Verwendung" + ChatColor.DARK_GRAY + ": " + ChatColor.BLUE + "/timer time <Zeit>");
                        return true;
                    }

                    try {
                        Timer timer = Main.getInstance().getTimer();

                        timer.setRunning(false);
                        timer.setTime(Integer.parseInt(args[1]));
                        player.sendMessage(ChatColor.GRAY + "Die Zeit wurde auf " + args[1] + " gesetzt.");
                    } catch (NumberFormatException e) {
                        player.sendMessage(ChatColor.RED + "Dein Parameter 2 muss eine Zahl sein.");
                    }
                    break;
                }
                case "reset": {
                    Timer timer = Main.getInstance().getTimer();

                    timer.setRunning(false);
                    timer.setTime(0);
                    player.sendMessage(ChatColor.GRAY + "Der Timer wurde zurückgesetzt.");
                    break;
                }
                default:
                    sendUsage(player);
                    break;
            }
        } else sender.sendMessage("Error Code 404");
        return false;
    }

    private void sendUsage(CommandSender player) {
        player.sendMessage(ChatColor.GRAY + "Verwendung" + ChatColor.DARK_GRAY + ": " + ChatColor.BLUE + "/timer resume, /timer pause, /timer time <Zeit>, /timer reset");
    }
}