package com.gmail.whitehack97.ExtendedCustomHelp.main;

import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.whitehack97.ExtendedCustomHelp.listener.PlayerCommandListener;
import com.sk89q.worldedit.bukkit.selections.Selection;

public class ExtendedCustomHelp extends JavaPlugin implements Listener
{
	public static Plugin plugin;
	public static Map<String, String> PrefixList;
	public Selection S;
	
	@Override
	public void onEnable()
	{
		Bukkit.getPluginManager().registerEvents(new PlayerCommandListener(), this);
	}
}