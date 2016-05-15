package com.gmail.whitehack97.ExtendedCustomHelp.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

import com.gmail.whitehack97.ExtendedCustomHelp.api.GenericPage;

public class PlayerGenericPageEvent extends PlayerEvent implements Cancellable
{
	private HandlerList handlers;
	private boolean cancel;
	private GenericPage gerericPage;

	PlayerGenericPageEvent(Player player, GenericPage page)
	{
		super(player);
		this.gerericPage = page;
	}
	
	public GenericPage getGenericPage()
	{
		return this.gerericPage;
	}
	
	public void setGenericPage(GenericPage page)
	{
		this.gerericPage = page;
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
