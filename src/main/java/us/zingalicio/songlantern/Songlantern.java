package us.zingalicio.songlantern;

import us.zingalicio.songlantern.commands.ChatCommand;
import us.zingalicio.songlantern.commands.SonglanternCommand;
import us.zingalicio.songlantern.events.ChatListener;
import us.zingalicio.songlantern.events.JoinListener;
import us.zingalicio.zinglib.plugin.ZingPlugin;

public class Songlantern extends ZingPlugin
{
	private ChatCommand chatCommand;
	private SonglanternCommand slCommand;
	private ChatListener chatListener;
	private JoinListener joinListener;

	public Songlantern()
	{
		super();
	}
	
	public void onEnable()
	{
		this.chatCommand = new ChatCommand(this);
		this.slCommand = new SonglanternCommand(this);
		registerCommands();
		registerListeners();
	}
	
	private void registerCommands()
	{
		getCommand("message").setExecutor(chatCommand);
		getCommand("reply").setExecutor(chatCommand);
		getCommand("broadcast").setExecutor(chatCommand);
		getCommand("say").setExecutor(chatCommand);
		getCommand("sayas").setExecutor(chatCommand);
		getCommand("songlantern").setExecutor(slCommand);
	}
	
	private void registerListeners()
	{
		chatListener = new ChatListener(this);
		joinListener = new JoinListener(this);
		getServer().getPluginManager().registerEvents(chatListener, this);
		getServer().getPluginManager().registerEvents(joinListener, this);
	}
	
}
