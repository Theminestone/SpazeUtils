package com.spazeutils.utils;

import com.spazeutils.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;
import java.util.HashMap;

// I am unbelievably proud about that pun

public class Spaze64 {

    public static void loadPlayerInv(Player p) {
        loadInventories();
        String inventoryData = Main.inventories.get(p.getDisplayName());
        try {
            ByteArrayInputStream stream = new ByteArrayInputStream(Base64.getDecoder().decode(inventoryData));
            BukkitObjectInputStream data = new BukkitObjectInputStream(stream);
            for (int i = 0; i < p.getInventory().getSize(); i++) {
                p.getInventory().setItem(i, (ItemStack) data.readObject());
            }
            data.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void savePlayerInv(Player p) {
        try {
            ByteArrayOutputStream str = new ByteArrayOutputStream();
            BukkitObjectOutputStream data = new BukkitObjectOutputStream(str);
            for (int i = 0; i < p.getInventory().getSize(); i++) {
                data.writeObject(p.getInventory().getItem(i));
            }
            data.close();
            Main.inventories.put(p.getDisplayName(), Base64.getEncoder().encodeToString(str.toByteArray()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        saveInventories();
    }
    public static void loadPlayerLoc(Player p) {
        loadLocations();
        p.teleport( Main.locations.get(p.getDisplayName()));
    }
    public static void savePlayerLoc(Player p) {
        Main.locations.put(p.getDisplayName(), p.getLocation());
        saveLocations();
    }
    public static boolean getPlayerLoggedin(Player p) {
        loadLoggedins();
        return  Main.loggedins.get(p.getDisplayName());
    }
    public static void setPlayerLoggedin(Player p, boolean value) {
        Main.loggedins.put(p.getDisplayName(), value);
        saveLoggedins();
    }
    public static boolean checkPlayerLoggedin(Player p) {
        loadLoggedins();
        return  Main.loggedins.containsKey(p.getDisplayName());
    }
    public static void removePlayerLoggedin(Player p) {
        Main.loggedins.remove(p.getDisplayName());
        saveLoggedins();
    }
    public static String getPlayerPassword(Player p) {
        loadPasswords();
        return  Main.passwords.get(p.getDisplayName());
    }
    public static void setPlayerPassword(Player p, String value) {
        Main.passwords.put(p.getDisplayName(), value);
        savePasswords();
    }
    public static boolean checkPlayerPassword(Player p) {
        loadPasswords();
        return Main.passwords.containsKey(p.getDisplayName());
    }
    public static boolean comparePlayerPassword(Player p, String password) {
        return Main.passwords.get(p.getDisplayName()).equals(password);
    }
    public static void removePlayerPassword(Player p) {
        Main.passwords.remove(p.getDisplayName());
        savePasswords();
    }
    public static void load() {
        loadPasswords();
        if (Main.passwords == null) {
            Main.passwords = new HashMap<String, String>();
        }
        loadLocations();
        if (Main.locations == null) {
            Main.locations = new HashMap<String, Location>();
        }
        loadLoggedins();
        if (Main.loggedins == null) {
            Main.loggedins = new HashMap<String, Boolean>();
        }
        loadInventories();
        if (Main.inventories == null) {
            Main.inventories = new HashMap<String, String>();
        }
    }


    private static void loadPasswords() {
        Main.passwords = stringToStrHashmap(Main.getPlugin().getConfig().getString("passwords"));
    }
    private static void savePasswords() {
        Main.getPlugin().getConfig().set("passwords", strHashmapToString(Main.passwords));
        Main.getPlugin().saveConfig();
    }
    private static void loadLocations() {
        Main.locations = stringToLocHashmap(Main.getPlugin().getConfig().getString("locations"));
    }
    private static void saveLocations() {
        Main.getPlugin().getConfig().set("locations", locHashmapToString(Main.locations));
        Main.getPlugin().saveConfig();
    }
    private static void loadLoggedins() {
        Main.loggedins = stringToBoolHashmap(Main.getPlugin().getConfig().getString("loggedins"));
    }
    private static void saveLoggedins() {
        Main.getPlugin().getConfig().set("loggedins", boolHashmapToString( Main.loggedins));
        Main.getPlugin().saveConfig();
    }
    private static void loadInventories() {
        Main.inventories = stringToStrHashmap(Main.getPlugin().getConfig().getString("inventories"));
    }
    private static void saveInventories() {
        Main.getPlugin().getConfig().set("inventories", strHashmapToString(Main.inventories));
        Main.getPlugin().saveConfig();
    }


    private static String locHashmapToString(HashMap<String, Location> hashmap) {
        try {
            ByteArrayOutputStream str = new ByteArrayOutputStream();
            BukkitObjectOutputStream data = new BukkitObjectOutputStream(str);
            data.writeObject(hashmap);
            data.close();
            return Base64.getEncoder().encodeToString(str.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    private static HashMap<String, Location> stringToLocHashmap(String string) {
        try {
            ByteArrayInputStream stream = new ByteArrayInputStream(Base64.getDecoder().decode(string));
            BukkitObjectInputStream data = new BukkitObjectInputStream(stream);
            HashMap<String, Location> hashmap = (HashMap<String, Location>) data.readObject();
            data.close();
            return hashmap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private static String boolHashmapToString(HashMap<String, Boolean> hashmap) {
        try {
            ByteArrayOutputStream str = new ByteArrayOutputStream();
            ObjectOutputStream data = new ObjectOutputStream(str);
            data.writeObject(hashmap);
            data.close();
            return Base64.getEncoder().encodeToString(str.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    private static HashMap<String, Boolean> stringToBoolHashmap(String string) {
        try {
            ByteArrayInputStream stream = new ByteArrayInputStream(Base64.getDecoder().decode(string));
            ObjectInputStream data = new ObjectInputStream(stream);
            HashMap<String, Boolean> hashmap = (HashMap<String, Boolean>) data.readObject();
            data.close();
            return hashmap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private static String strHashmapToString(HashMap<String, String> hashmap) {
        try {
            ByteArrayOutputStream str = new ByteArrayOutputStream();
            ObjectOutputStream data = new ObjectOutputStream(str);
            data.writeObject(hashmap);
            data.close();
            return Base64.getEncoder().encodeToString(str.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    private static HashMap<String, String> stringToStrHashmap(String string) {
        try {
            ByteArrayInputStream stream = new ByteArrayInputStream(Base64.getDecoder().decode(string));
            ObjectInputStream data = new ObjectInputStream(stream);
            HashMap<String, String> hashmap = (HashMap<String, String>) data.readObject();
            data.close();
            return hashmap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
