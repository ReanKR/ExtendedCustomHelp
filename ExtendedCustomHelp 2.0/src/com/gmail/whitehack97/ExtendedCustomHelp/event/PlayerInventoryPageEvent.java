package com.gmail.whitehack97.ExtendedCustomHelp.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

import com.gmail.whitehack97.ExtendedCustomHelp.api.InventoryPage;

public class PlayerInventoryPageEvent extends PlayerEvent implements Cancellable
{

	private InventoryPage inventoryPage;
	private HandlerList handlers;
	private boolean cancel;

	PlayerInventoryPageEvent(Player player, InventoryPage page)
	{
		super(player);
		this.inventoryPage = page;
	}
	
	public InventoryPage getInventoryPage()
	{
		return this.inventoryPage;
	}
	
	public void setInventoryPage(InventoryPage page)
	{
		this.inventoryPage = page;
	}
	

	public boolean isCancelled()
	{
		return cancel;
	}

	public void setCancelled(boolean cancel)
	{
		this.cancel = cancel;
	}

	public HandlerList getHandlers()
	{
		return handlers;
	}
}
