package com.gmail.whitehack97.ExtendedCustomHelp.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.gmail.whitehack97.ExtendedCustomHelp.api.GenericPage;
import com.gmail.whitehack97.ExtendedCustomHelp.api.InventoryPage;
import com.gmail.whitehack97.ExtendedCustomHelp.event.PlayerGenericPageEvent;
import com.gmail.whitehack97.ExtendedCustomHelp.event.PlayerInventoryPageEvent;

public class PlayerOpenEvent implements Listener
{
	@EventHandler
	public void PlayerGenericPage(PlayerGenericPageEvent event)
	{
		GenericPage page = event.getGenericPage();
	}
	
	@EventHandler
	public void PlayerInventoryPage(PlayerInventoryPageEvent event)
	{
		InventoryPage page = event.getInventoryPage();
	}
}
