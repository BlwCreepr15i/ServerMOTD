package com.blwcreepr.servermotd;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManager {

    private static Configuration config;

    public static void setupConfig(ServerMOTD serverMOTD) throws IOException {
        ConfigManager.config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(serverMOTD.getDataFolder(), "config.yml"));
        ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, new File(serverMOTD.getDataFolder(), "config.yml"));
    }

    // Get Server MOTD
    public static String getMOTDTitle() { return ChatColor.translateAlternateColorCodes('&', config.getString("server-motd.title")); }
    public static String getMOTDSubtitle() { return ChatColor.translateAlternateColorCodes('&', config.getString("server-motd.subtitle")); }

    // Get Player Count
    public static int getPlayerLimit() { return config.getInt("player-limit"); }

    public static int getMinPlayerCount() {
        int count = config.getInt("min-player-count");
        return count == -1 ? ServerMOTD.getInstance().getProxy().getOnlineCount() : count;
    }

    public static int getMaxPlayerCount() {
        int count = config.getInt("max-player-count");
        return count == -1 ? ServerMOTD.getInstance().getProxy().getOnlineCount() : count;
    }

    public static String getVersionMessage() { return config.getString("version-message"); }
}
