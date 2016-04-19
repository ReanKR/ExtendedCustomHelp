package org.whitehack97.ExtendedCustomHelp.main;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.whitehack97.ExtendedCustomHelp.api.Help;
import org.whitehack97.ExtendedCustomHelp.file.FileUpdater;


public class ExtendedCustomHelp extends JavaPlugin implements Listener
{
	public static Help HelpClass;
	public static String Permission = "extendedcustomhelp";
	public static Plugin plugin;
	public static int Version = 2;
	
	@Override
	public void onEnable()
	{
		File file = new File("plugins/ExtendedCustomHelp/config.yml");
		if(! file.exists())
		{
			this.saveDefaultConfig();
		}
		plugin = this;
		FileUpdater.ChackYourConfig();
		if(HelpLoader.LoadHelpFile())
		{
			getServer().getPluginManager().registerEvents(this, this);
			Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&aExtendedCustomHelp now Enabled"));
		}
		else
		{
			Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&cExtendedCustomHelp cannot running."));
		}
	}
	
	@Override
	public void onDisable()
	{
		Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&cExtendedCustomHelp now Disabled"));
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		if(sender instanceof Player)
		{
			Player player = (Player) sender;
			String cmd = command.getName();
			if(cmd.equalsIgnoreCase("ExtendedCustomHelp.Reloaded"))
			{
				if(player.hasPermission("extendedcustomhelp.reload"))
				{
					boolean passed = HelpLoader.LoadHelpFile();
					if(passed)
					{
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("Reload-Complete")));
						return true;
					}
					else
					{
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', "ExtendedCustomHelp reload FAILED."));
						return true;
					}
				}
				else
				{
					String Message = getConfig().getString("Reload-Not-Permission");
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', Message));
					return false;
				}
			}
			else if(CheckHelp(cmd))
			{
				if(args.length < 1)
				{
					for(String Text : HelpClass.getText())
					{
						player.sendMessage(Text.replace("%player%", player.getName()));
					}
					return true;
				}
				else
				{
					if(args.length < 2)
					{
						if(HelpClass.getChildrenClasses().containsKey((args[0].toLowerCase())))
						{
							Help Class = HelpClass.getChildrenClasses().get(args[0].toLowerCase());
							if(player.hasPermission(Class.getPermission()))
							{
								for(String Text : Class.getText())
								{
									player.sendMessage(Text.replace("%player%", player.getName()));
								}
								return true;
							}
							else
							{
								if(! Class.hasPermission())
								{
									for(String Text : Class.getText())
									{
										player.sendMessage(Text.replace("%player%", player.getName()));
									}
									return true;
								}
								player.sendMessage(NotPermission(args[0], Class));
								return false;
							}
						}
						else
						{
							player.sendMessage(HelpNotFound(args[0]));
							return false;
						}
					}
					else
					{
						if(HelpClass.getChildrenClasses().containsKey((args[0].toLowerCase())))
						{
							if(HelpClass.getChildrenClasses().get((args[0].toLowerCase())).getChildrenClasses().containsKey(args[1].toLowerCase()))
							{
								Help Class = HelpClass.getChildrenClasses().get(args[0].toLowerCase()).getChildrenClasses().get(args[1].toLowerCase());
								if(player.hasPermission(Class.getPermission()))
								{
									for(String Text : Class.getText())
									{
										player.sendMessage(ChatColor.translateAlternateColorCodes('&', Text));
									}
									return true;
								}
								else
								{
									if(! Class.hasPermission())
									{
										for(String Text : Class.getText())
										{
											player.sendMessage(Text.replace("%player%", player.getName()));
										}
										return true;
									}
									player.sendMessage(NotPermission(args[0] + "." + args[1], Class));
									return false;
								}
							}
							else
							{
								player.sendMessage(HelpNotFound(args[0] + "." + args[1]));
								return false;
							}
						}
						else
						{
							player.sendMessage(HelpNotFound(args[0]));
							return false;
						}
					}
				}
			}
			return false;
		}
		else
		{
			String cmd = command.getName();
			if(cmd.equalsIgnoreCase("ExtendedCustomHelp.Reloaded"))
			{
				boolean passed = HelpLoader.LoadHelpFile();
				if(passed)
				{
					Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("Reload-Complete")));
					return true;
				}
				else
				{
					Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "ExtendedCustomHelp reload FAILED."));
					return true;
				}
			}
			else if(CheckHelp(cmd))
			{
				if(args.length < 1)
				{
					for(String Text : HelpClass.getText())
					{
						Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', Text));
					}
					return true;
				}
				else
				{
					if(args.length < 2)
					{
						if(HelpClass.getChildrenClasses().containsKey((args[0].toLowerCase())))
						{
							Help Class = HelpClass.getChildrenClasses().get(args[0].toLowerCase());
							for(String Text : Class.getText())
							{
								Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', Text));
							}
							return true;
						}
						else
						{
							Bukkit.getConsoleSender().sendMessage(HelpNotFound(args[0]));
							return false;
						}
					}
					else
					{
						if(HelpClass.getChildrenClasses().containsKey((args[0].toLowerCase())))
						{
							if(HelpClass.getChildrenClasses().get((args[0].toLowerCase())).getChildrenClasses().containsKey(args[1].toLowerCase()))
							{
								Help Class = HelpClass.getChildrenClasses().get(args[0].toLowerCase()).getChildrenClasses().get(args[1].toLowerCase());
								for(String Text : Class.getText())
								{
									Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', Text));
								}
								return true;
							}
							else
							{
								Bukkit.getConsoleSender().sendMessage(HelpNotFound(args[0] + "." + args[1]));
								return false;
							}
						}
						else
						{
							Bukkit.getConsoleSender().sendMessage(HelpNotFound(args[0]));
							return false;
						}
					}
				}
			}
			return false;
		}
	}
	
	public String NotPermission(String Pagename, Help Classname)
	{
		String Message = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Not-Permission"));
		Message = Message.replaceAll("%page%", "'" + Pagename + "'");
		Message = Message.replaceAll("%permission%", "'" + Classname.getPermission() + "'");
		return Message;
	}
	
	public String HelpNotFound(String Pagename)
	{
		String Message = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Help-Not-Found"));
		Message = Message.replaceAll("%page%", "'" + Pagename + "'");
		return Message;
	}
	
	public boolean CheckHelp(String command)
	{
		if(command.equalsIgnoreCase("help"))
		{
			return true;
		}
		
		else if(command.equalsIgnoreCase("?"))
		{
			return true;
		}
		return false;
	}
}

