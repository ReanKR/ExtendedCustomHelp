package org.whitehack97.ExtendedCustomHelp.file;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

public class FileUpdater
{
	public static void ChackYourConfig()
	{
		FileConfiguration Config = ExtendedCustomHelp.plugin.getConfig();
		if(Config.contains("Config-Version"))
		{
			if(Config.getInt("Config-Version") <= ExtendedCustomHelp.Version)
			{
				if(Config.contains("Reload-Not-Permission"))
				{
					Config.set("Config-Version", ExtendedCustomHelp.Version);
					Config.set("Reload-Not-Permission", "&cYou cannot access to reload this plugin.");
					Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&eUpgrating config.yml..."));
				}
			}
		}
		else
		{
			return;
		}
		ExtendedCustomHelp.plugin.saveConfig();
		Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&eDone!"));
	}
}
