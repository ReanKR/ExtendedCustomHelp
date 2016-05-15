package com.gmail.whitehack97.ExtendedCustomHelp.api;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.inventory.Inventory;

public class InventoryPage extends Page
{
	public InventoryPage(String name)
	{
		super(name);
		Inventory inventory = Bukkit.createInventory(null, 9, null);
	}
	
	public void setSound(Sound sound)
	{
		this.sound  = sound;
	}
	
	public Sound getSound()
	{
		return this.sound;
	}
}
