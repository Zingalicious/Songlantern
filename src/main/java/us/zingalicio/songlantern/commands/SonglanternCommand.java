package us.zingalicio.songlantern.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginManager;

import us.zingalicio.songlantern.Songlantern;
import us.zingalicio.cordstone.util.ConfigUtil;
import us.zingalicio.cordstone.util.MessageUtil;
import us.zingalicio.cordstone.util.PermissionsUtil;

public class SonglanternCommand implements CommandExecutor
{
	private Songlantern plugin;
	
	public SonglanternCommand(Songlantern plugin)
	{
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label,
			String[] args) 
	{
		if(args.length == 0)
		{
			return false;
		}
		switch(args[0])
		{
			case "reload":
				return reload(sender, args);
			case "version":
				MessageUtil.sendMessage(plugin, sender, plugin.getDescription().getVersion());
				return true;
			default:
				return false;
		}
	}
	
	public boolean reload(CommandSender sender, String[] args)
	{
		try
		{
			if(PermissionsUtil.checkPermission(sender, "songlantern.reload", false))
			{
				ConfigUtil.loadYaml(plugin.getConfig(), plugin.getConfigFile());
				ConfigUtil.loadYaml(plugin.getMaterials(), plugin.getMaterialFile());
				ConfigUtil.loadYaml(plugin.getItems(), plugin.getItemFile());
				PluginManager pluginManager = Bukkit.getPluginManager();
				pluginManager.disablePlugin(plugin);
				pluginManager.enablePlugin(plugin);
				MessageUtil.sendMessage(plugin, sender, "Reloaded.");
			}
			return true;
		}
		catch(Throwable t)
		{
			MessageUtil.sendError(plugin, sender, "Failed to reload.");
			return false;
		}
	}
}
