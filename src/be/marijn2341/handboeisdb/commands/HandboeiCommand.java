package be.marijn2341.handboeisdb.commands;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nl.minetopiasdb.api.playerdata.PlayerManager;
import nl.minetopiasdb.api.playerdata.objects.SDBPlayer;


public class HandboeiCommand implements CommandExecutor {
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		  if (sender instanceof Player) {
			  if (args.length == 1) {
				  if (sender.hasPermission("handboei.use")) {
					  Player target = Bukkit.getPlayer(args[0]);
					  if (target != null) {
						  UUID uuid = target.getUniqueId();
						  SDBPlayer player = PlayerManager.getOnlinePlayer(uuid);
						  if (player.isHandCuffed()) {
							  player.unhandcuffPlayer();
							  sender.sendMessage(ChatColor.DARK_AQUA + "Unhandcuffed: " + ChatColor.WHITE + target.getName() + ChatColor.DARK_AQUA + "!");
						  } else {
							  player.handcuffPlayer(uuid);
							  sender.sendMessage(ChatColor.DARK_AQUA + "handcuffed: " + ChatColor.WHITE + target.getName() + ChatColor.DARK_AQUA + "!");
						  }
					  } else {
						  sender.sendMessage(ChatColor.RED + "Deze speler bestaat niet!");
					  }
				  } else {
					  sender.sendMessage(ChatColor.DARK_RED + "Je hebt geen permissie voor deze command.");
				  }
			  } else {
				  sender.sendMessage(ChatColor.DARK_RED + "Usage: /handboei <player>");
			  }
		  }
		return false;
	  }
}
