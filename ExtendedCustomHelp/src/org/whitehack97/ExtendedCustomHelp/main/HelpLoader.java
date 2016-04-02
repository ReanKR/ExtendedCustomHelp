package org.whitehack97.ExtendedCustomHelp.main;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.whitehack97.ExtendedCustomHelp.api.Help;

public class HelpLoader
{
	public static boolean LoadHelpFile()
	{
		File file = new File("plugins/ExtendedCustomHelp/Help.yml");
		if(! file.exists())
		{
			ExtendedCustomHelp.plugin.saveResource("Help.yml", true);
		}
		YamlConfiguration fileSection = YamlConfiguration.loadConfiguration(file);
		Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "Loading Help.yml");
		Help Main = new Help("Main");
		if(fileSection.contains("Main"))
		{			
			if(fileSection.contains("Main.Text"))
			{
				Main.setText(fileSection.getStringList("Main.Text"));
			}
			else
			{
				Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ExtendedCustomHelp need Help.yml, But the file is not exist Main.Text method.");
				return false;
			}
		}
		else
		{
			Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ExtendedCustomHelp need Help.yml, But the file is not exist Main method.");
			return false;
		}
		ExtendedCustomHelp.HelpClass = Main;
		if(fileSection.contains("Children"))
		{
			for(String Children : fileSection.getConfigurationSection("Children").getKeys(false))
			{
				if(fileSection.contains("Children." + Children + ".Text"))
				{
					Help PrevChildrenPage = new Help(Children);
					PrevChildrenPage.ParentClass(ExtendedCustomHelp.HelpClass);
					PrevChildrenPage.setText(fileSection.getStringList("Children." + Children + ".Text"));
					if(fileSection.contains("Children." + Children + ".Need-Permission"))
					{
						PrevChildrenPage.setPermission(fileSection.getBoolean("Children." + Children + ".Need-Permission"));
						if(PrevChildrenPage.hasPermission()) Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Children permission registered: " + PrevChildrenPage.getPermission());
					}
					
					if(fileSection.contains("Children." + Children + ".Children"))
					{
						for(String Child : fileSection.getConfigurationSection("Children." + Children + ".Children").getKeys(false))
						{
							if(fileSection.contains("Children." + Children + ".Children." + Child))
							{
								Help ChildrenPage = new Help(Children + "." + Child);
								ChildrenPage.ParentClass(PrevChildrenPage);
								ChildrenPage.setText(fileSection.getStringList("Children." + Children + ".Children." + Child + ".Text"));
								if(fileSection.contains("Children." + Children + ".Children." + Child + ".Need-Permission"))
								{
									ChildrenPage.setPermission(fileSection.getBoolean("Children." + Children + ".Children." + Child + ".Need-Permission"));
									if(ChildrenPage.hasPermission()) Bukkit.getConsoleSender().sendMessage(ChatColor.GOLD + "Children permission registered: " + ChildrenPage.getPermission());
								}
								PrevChildrenPage.ChildrenClass(Child.toLowerCase(), ChildrenPage);
							}
						}
					}
					ExtendedCustomHelp.HelpClass.ChildrenClass(Children.toLowerCase(), PrevChildrenPage);
				}
			}
		}
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + String.valueOf(ExtendedCustomHelp.HelpClass.getChildrenClasses().size()) + " Help page(s) registered.");
		return true;
	}
}
