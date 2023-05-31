package com.blwcreepr.servermotd.commands;

import com.blwcreepr.servermotd.ConfigManager;
import com.blwcreepr.servermotd.ServerMOTD;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ServerMOTDCommand extends Command {

    public ServerMOTDCommand() {
        super("servermotd");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            System.out.println(ChatColor.RED + "You may not use this command.");
            return;
        }

        ProxiedPlayer player = (ProxiedPlayer) sender;

        if (args.length >= 1) {
            switch (args[0].toLowerCase()) {
                case "motd":
                    player.sendMessage(ChatColor.GREEN + "Current Server MOTD: ");
                    player.sendMessage(ConfigManager.getMOTDTitle());
                    player.sendMessage(ConfigManager.getMOTDSubtitle());
                    break;
                case "player":
                    player.sendMessage(ChatColor.GOLD + "Server Player Limit: "
                            + ChatColor.GREEN + ConfigManager.getPlayerLimit());
                    player.sendMessage(ChatColor.GOLD + "Current Online Players: "
                            + ChatColor.GREEN + ServerMOTD.getInstance().getProxy().getOnlineCount());
                    break;
                default:
                    player.sendMessage(ChatColor.RED + "Invalid Arguments! /servermotd for help.");
            }

        } else {
            player.sendMessage(ChatColor.RED + "Missing Arguments!");
            player.sendMessage(ChatColor.GREEN + "List:");
            player.sendMessage(ChatColor.WHITE + "- " + ChatColor.GREEN + "/servermotd motd");
            player.sendMessage(ChatColor.WHITE + "- " + ChatColor.GREEN + "/servermotd player");
            return;
        }

    }
}
