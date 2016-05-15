package com.gmail.whitehack97.ExtendedCustomHelp.util;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;

public class MsgManager
{
	public static String RepColor(String Str)
	{
		return ChatColor.translateAlternateColorCodes('&', Str);
	}

	public static void Cmsg(Server server, String Prefix, String Str)
	{
		String p = Prefix;
		
		if(Prefix == null)
		{
			p = "";
		}
		server.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', p + Str));
	}

	public static void Cmsg(Server server, String Str)
	{
		server.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', Str));
	}

	public static void msg(Player player, String Str)
	{
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', Str));
	}

	public static void msg(Player player, String Prefix, String Str)
	{
		String p = Prefix;
		
		if(Prefix == null)
		{
			p = "";
		}
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', p + Str));
	}
}
