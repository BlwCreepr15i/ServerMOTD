# ServerMOTD
A Minecraft Bungeecord plugin displays fancy text when client pings the multiplayer menu. <br>
Many servers use the similar way this plugin does in order to make its glowing and shiny MOTD on the multiplayer menu. <br>
The following Server MOTD is made possible using this plugin: <br>
![](https://media.discordapp.net/attachments/880425820861132810/1010684857581572166/unknown.png?width=976&height=141)
# Get Started
Just like other Bungeecord plugins, after downloading the file, putting it into the plugin folder of your Bungeecord server.
It is not the plugin folder of the sub-servers, but the Bungeecord that manages all the sub-servers. <br>
### config.yml
Some configurations are needed to make it looks more personal and pretty. There are detailed explanation in the `config.yml` too and most of those are self-explanatory, so you do not have to follow this guide to get started.<br>

`title` and `subtitle` - To customize the title and subtitle of the displayed MOTD, put it as in String format using single quotation marks surround it. 
Because the text does not automatically get centered, so some spaces or tabs might be needed to make it centered.
Minecraft color codes also work, instead of using color sign `§`, replace it with `&`. For example, `&a` would display green text after it. <br>

`player-count` - The maximum player the server would handle. <br>

`min-player-count` - The minimum online player the MOTD page would show. <br>
`max-player-count` - The maximum online player the MOTD page would show. <br> 
(Please note that if you want the MOTD menu to show the accurate online player at the moment, put 0 for both min and max. You may not leave them empty!) <br>

`version-message` - The message that a player would see when pinging the MOTD menu with the wrong version. <br> 
(Note: This is bugged currently, and player would see it even when connecting with the right minecraft version)
#
