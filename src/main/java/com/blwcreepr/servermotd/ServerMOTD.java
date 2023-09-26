package com.blwcreepr.servermotd;

import com.blwcreepr.servermotd.commands.ServerMOTDCommand;
import com.blwcreepr.servermotd.listener.PingServerListener;
import net.md_5.bungee.api.Favicon;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public final class ServerMOTD extends Plugin {

    private static ServerMOTD instance;
    private static Favicon favicon;

    @Override
    public void onEnable() {

        instance = this;

        try {
            ConfigManager.setupConfig(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read Favicon
        try {
            favicon = Favicon.create(ImageIO.read(new File("icon.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("ServerMOTD has loaded!");

        // Command Registration
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new ServerMOTDCommand());

        // Listener Registration
        ProxyServer.getInstance().getPluginManager().registerListener(this, new PingServerListener());
    }

    @Override
    public void onDisable() {
        getLogger().warning("ServerMOTD has been disabled!");
    }

    public static ServerMOTD getInstance() { return instance; }

    public static Favicon getFavicon() {
        return favicon;
    }
}
