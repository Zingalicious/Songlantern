package us.zingalicio.songlantern.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import us.zingalicio.songlantern.Songlantern;
import us.zingalicio.zinglib.util.ChatUtil;

public class JoinListener implements Listener
{
	Songlantern plugin;
	
	public JoinListener(Songlantern plugin)
	{
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event)
	{
		Player player = event.getPlayer();
		PermissionUser user = PermissionsEx.getUser(player);
		if(!user.getOption("displayname").equals(""))
		{
			player.setDisplayName(user.getOption("displayname"));
		}
		if(!user.getOption("joinmessage").equals(""))
		{
			event.setJoinMessage(ChatUtil.formatMessage(event.getPlayer(), user.getOption("displayname")));
		}
		else
		{
			user.setOption("joinmessage", "&6%player &6has entered the fringe.");
		}
	}
}
