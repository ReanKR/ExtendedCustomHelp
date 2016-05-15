package com.gmail.whitehack97.ExtendedCustomHelp.api;

import java.util.UUID;

import org.bukkit.Sound;

public class Page implements Inheritance
{
	protected Sound sound = null;
	protected String name = UUID.randomUUID().toString().replaceAll("-", "");
	protected String Prefix;
	private Page ParentPage = null;
	
	public Page(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setSound(Sound sound)
	{
		this.sound  = sound;
	}
	
	public Sound getSound()
	{
		return this.sound;
	}

	public void setParentPage(Page page)
	{
		this.ParentPage  = page;
	}

	public Page getParentPage()
	{
		return this.ParentPage;
	}
}
