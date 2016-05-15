package com.gmail.whitehack97.ExtendedCustomHelp.api;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;

import net.milkbowl.vault.economy.Economy;

public class PluginLoader
{
	public static WorldEditPlugin getWorldEdit()
	{
		Plugin p = Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");
		if(p instanceof WorldEditPlugin) return (WorldEditPlugin) p;
		else return null;
	}
	
	public static Economy getEconomy()
	{
	    Economy ecoHook = null;

	    RegisteredServiceProvider<Economy> economyProvider = Bukkit.getServer().getServicesManager().getRegistration(Economy.class);
	    if (economyProvider != null)
	    {
	      ecoHook = (Economy)economyProvider.getProvider();
	    }
	    return ecoHook;	
	}
}
