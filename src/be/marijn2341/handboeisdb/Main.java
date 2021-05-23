package be.marijn2341.handboeisdb;

import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import be.marijn2341.handboeisdb.commands.HandboeiCommand;

public class Main extends JavaPlugin implements Listener {
	  public void onEnable() {
		  System.out.println("Handboei plugin enabled");
		  System.out.println("By: Marijn2341");
		  getCommand("handboei").setExecutor((CommandExecutor) new HandboeiCommand());
	}
}