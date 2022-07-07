package me.dev.nux.rtp.commands;

import me.dev.nux.rtp.RTP;
import me.dev.nux.rtp.console.ConsoleManager;
import me.dev.nux.rtp.teleport.TeleportManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
public class RandomTeleportCommand implements CommandExecutor {

    RTP main;
    public RandomTeleportCommand(RTP main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("[RTP] Only players can run this command.");
            return false;
        }

        if (args.length > 0) {
            sender.sendMessage(main.getConfigManager().getWrongUsageMessage());
            return false;
        }

        Player p = (Player)sender;

        TeleportManager tpManager = new TeleportManager(main);

        Location randomLoc = tpManager.calculateRandomLocation(p);

        if (randomLoc == null) {
            p.sendMessage(main.getConfigManager().getFailMessage());
            return false;
        }

        randomLoc.getChunk().load();

        p.sendMessage(ChatColor.GREEN + "Teleporting to a random location in 3 seconds...");

        Bukkit.getScheduler().runTaskLater(main, new Runnable() {
            @Override
            public void run() {

                p.teleport(randomLoc);

                p.sendMessage(main.getConfigManager().getSuccessMessage());

                ConsoleManager cManager = main.getConsoleManager();

                cManager.sendLog(ChatColor.GREEN + "[RTP INFO] " + p.getName() + " teleported to a random location.");

            }
        }, 60);

        return false;
    }
}
