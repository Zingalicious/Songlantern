package us.zingalicio.songlantern.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import us.zingalicio.songlantern.Songlantern;

public final class ChatCommand implements CommandExecutor
{
	Songlantern plugin;
	
	public ChatCommand(Songlantern plugin)
	{
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2,
			String[] arg3) {
		// TODO Auto-generated method stub
		return false;
	}

}
