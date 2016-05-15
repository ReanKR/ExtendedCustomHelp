package com.gmail.whitehack97.ExtendedCustomHelp.util;

import org.bukkit.Server;
import org.bukkit.entity.Player;

public interface ChatSubstitution
{
	public abstract String RepColor(String Str);
	
	public abstract void Cmsg(Server server, String Str);
	
	public abstract void Cmsg(Server server, String Prefix, String Str);
	
	public abstract void msg(Player player, String Str);
	
	public abstract void msg(Player player, String Prefix, String Str);
}
