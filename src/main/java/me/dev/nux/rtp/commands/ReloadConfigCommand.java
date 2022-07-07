package me.dev.nux.rtp.commands;

import me.dev.nux.rtp.RTP;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadConfigCommand implements CommandExecutor {

    RTP main;

    public ReloadConfigCommand(RTP main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length != 1) {
            sender.sendMessage(main.getConfigManager().getReloadUsage());
            return false;
        }

        if (args[0].equalsIgnoreCase("reload")) {
            main.reloadConfig();
            sender.sendMessage(main.getConfigManager().getConfigReloadMessage());
        }
        else {
            sender.sendMessage(main.getConfigManager().getReloadUsage());
            return false;
        }

        return false;
    }
}
