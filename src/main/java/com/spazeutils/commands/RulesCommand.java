package com.spazeutils.commands;

import com.spazeutils.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RulesCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "1. no Hacking");
            player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "2. no Cheating");
            player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "3. Killing players is forbidden");
            player.sendMessage(ChatColor.GOLD + "-------- " + ChatColor.RESET + Main.prefix + ChatColor.GOLD + "--------" + ChatColor.RESET);
            player.sendMessage("" +
                    "All players must have appropriate usernames that are not offensive.\n" +
                    "Griefing is strictly prohibited and will result in a permanent ban.\n" +
                    "Going into another player’s base without permission is trespassing.\n" +
                    "Do not kill pets, animals, or any name-tagged mob of another player.\n" +
                    "Do not ask for free stuff or beg for items.\n" +
                    "Do not hack or cheat to gain an advantage that would not normally be available in regular gameplay.\n" +
                    "Do not build any type of farm with the purpose to overwhelm or cause a negative impact on the server.\n" +
                    "Modifications that control your player or automate actions are prohibited.\n" +
                    "Malicious threats of any kind towards other players are not permitted.\n" +
                    "Do not send any personal information without the owner’s consent.\n" +
                    "Do not attempt to use our server for the purpose of scamming other players.\n" +
                    "Any threat or attempt to DOX/DDoS/SWAT another player or server will result in a permanent ban.\n" +
                    "Do not send any link that is deemed inappropriate or malicious.\n" +
                    "If you encounter any disrespectful players, please report them to a staff member.\n" +
                    "If you are not sure if something is against the rules, please ask a staff member.\n" +
                    "Any link that is deemed inappropriate or malicious is not allowed.\n" +
                    "Keep the chat civil and appropriate for everyone.\n" +
                    "Saying something to confuse or mislead other players is not allowed.\n" +
                    "Do not talk or joke about inappropriate subjects.\n" +
                    "Bypassing filtered words is prohibited.\n" +
                    "Abusing a bug or a glitch in the server to gain an unfair advantage is prohibited.\n" +
                    "Using an alternate account to bypass a ban is not allowed.\n" +
                    "Do not use any form of automated programs or scripts.\n" +
                    "You are not allowed to advertise anything that is not related to the server.\n" +
                    "Do not spam commands that negatively affect other players.\n" +
                    "Do not use items that are not typically obtainable in-game on any other server. \n" +
                    "You cannot use alternate accounts to spam chat, commands, or other communication methods.\n" +
                    "Doing anything considered to be illegal is not allowed on the server.\n" +
                    "Do not send links to any other Discord server in public chat.\n" +
                    "Discussing anything inappropriate in public chat is not allowed.\n" +
                    "Please replant trees whenever you destroy them.\n" +
                    "Crafting or using TNT in the server is not allowed.\n" +
                    "Stealing other player’s items is not allowed.\n" +
                    "Teleport trapping is prohibited.\n" +
                    "Cobble monstering to create large structures are not allowed.\n" +
                    " All clicks must be done manually (on a mouse) without rebinding.\n" +
                    "Do not repeatedly ask or beg for mod status.\n" +
                    "Do not encourage other players to break rules.\n" +
                    "Excessive Caps Lock in the chat is not allowed.\n" +
                    "Do not criticize the server or any players.\n" +
                    "Please build 100 blocks away from another player’s build.\n" +
                    "Do not place unwanted lava or water around the map.\n" +
                    "The use of stolen or hacked accounts is not permitted.\n" +
                    "Do not use any derogatory terms on the server.\n" +
                    "Any form of hate speech is prohibited.\n" +
                    "Be polite and show respect to each other.\n" +
                    "Do not loot another player’s death location.\n" +
                    "Do not modify other players’ builds without their consent.\n" +
                    "After you’ve harvested the crops of a farm, please replant them.");
        }
        return false;
    }
}
