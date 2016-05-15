package com.gmail.whitehack97.ExtendedCustomHelp.api;

import java.util.ArrayList;
import java.util.List;

import com.gmail.whitehack97.ExtendedCustomHelp.main.ExtendedCustomHelp;
import com.gmail.whitehack97.ExtendedCustomHelp.util.MsgManager;

public class GenericPage extends Page
{
	protected List<String> Text = new ArrayList<String>();
	
	public GenericPage(String name)
	{
		super(name);
	}
    /**
     * @deprecated Method setText is deprecated
     */

	public void setText(String Str)
	{
		Text = new ArrayList<String>();
		this.Text.add(Str);
	}
	
	public void setText(String[] ArrayStr)
	{
		Text = new ArrayList<String>();
		for(int i = 0; i < ArrayStr.length; i++)
		{
			this.Text.add(ArrayStr[i]);
		}
	}

	public void setText(List<String> ListStr)
	{
		this.Text = ListStr;
	}
	
	public void addText(String Str)
	{
		this.Text.add(Str);
	}
	
	public void addText(String[] ArrayStr)
	{
		for(int i = 0; i < ArrayStr.length; i++)
		{
			this.Text.add(ArrayStr[i]);
		}
	}
	
	public void addText(List<String> ListStr)
	{
		this.Text.addAll(ListStr);
	}
	
	public void setPrefix(String Str)
	{
		if(Str.contains("$")) this.Prefix = ExtendedCustomHelp.PrefixList.get(Str.replace("$", ""));
		else this.Prefix = MsgManager.RepColor(Str);
	}
	
	public String getPrefix(String Str)
	{
		return this.Prefix;
	}
}
