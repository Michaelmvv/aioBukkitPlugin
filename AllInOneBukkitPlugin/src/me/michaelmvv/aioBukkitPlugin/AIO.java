package me.michaelmvv.aioBukkitPlugin;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class AIO extends JavaPlugin {
	public final Logger logger = Logger.getLogger("minecraft");

	public void onEnable() {

	}

	public void onDisable() {

	}

	public boolean onCommand(CommandSender sender, Command cmd, String lable,
			String[] args) {
		Player player = (Player) sender;
		
		//TODO Make Plugin.yml
		//TODO Add Hunger
		
		//hunger starts
		if (lable.equalsIgnoreCase("Hunger")) {
			if (args.length == 0) {
				player.sendMessage(ChatColor.GREEN + "Your Hunger is: "
						+ ChatColor.GOLD + player.getFoodLevel());

			} else if (args.length == 1) {
				if (player.getServer().getPlayer(args[0]) != null) {
					Player targetplayer = player.getServer().getPlayer(args[0]);
					logger.info(args[0]);
					player.sendMessage(ChatColor.GREEN + args[0] + "'s "
							+ ChatColor.WHITE + "Hunger level is: "
							+ ChatColor.GOLD + targetplayer.getFoodLevel());
				} else {
					player.sendMessage(args[0] + " Is not online");
				}

			}
		}
		//hunger ends
		//start health
		//TODO Add health to plugin.yml
		if (lable.equalsIgnoreCase("health")) {
			if (args.length == 0) {
				double playerHealth = player.getHealth();
				player.sendMessage(ChatColor.GREEN + "Your health Level is: "
						+ ChatColor.RED + playerHealth);
			} else if (args.length == 1) {
				if (player.getServer().getPlayer(args[0]) != null) {
					Player targetplayer = player.getServer().getPlayer(args[0]);
					logger.info(args[0]);
					player.sendMessage(ChatColor.GREEN + args[0] + "'s"
							+ ChatColor.WHITE + " Health is " + ChatColor.GOLD
							+ targetplayer.getHealth());

				} else {
					player.sendMessage(args[0] + " Is not online");
				}
			}

		}
		//end
		
		return false;
	}

}
