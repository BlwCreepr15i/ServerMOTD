package com.blwcreepr.servermotd.listener;

import com.blwcreepr.servermotd.ConfigManager;
import com.blwcreepr.servermotd.ServerMOTD;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.util.Random;

public class PingServerListener implements Listener {

    @EventHandler
    public void onProxyPing(ProxyPingEvent e) {

        Random random = new Random();
        int r = random.nextInt(ConfigManager.getMaxPlayerCount()*2);


        ServerPing ping = e.getResponse();
        ping.setDescription(ConfigManager.getMOTDTitle() + '\n' + ConfigManager.getMOTDSubtitle());
        ping.setPlayers(new ServerPing.Players(ConfigManager.getPlayerLimit(),
                ConfigManager.getMaxPlayerCount()==ConfigManager.getMinPlayerCount() ? ConfigManager.getMinPlayerCount() : r/2+ConfigManager.getMinPlayerCount()
                , ping.getPlayers().getSample()));
        ping.setVersion(new ServerPing.Protocol(ConfigManager.getVersionMessage(), 759));

        ping.setFavicon(ServerMOTD.getFavicon());

        e.setResponse(ping);
    }
}
