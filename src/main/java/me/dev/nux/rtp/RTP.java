package me.dev.nux.rtp;

import me.dev.nux.rtp.commands.RandomTeleportCommand;
import me.dev.nux.rtp.commands.ReloadConfigCommand;
import me.dev.nux.rtp.config.ConfigManager;
import me.dev.nux.rtp.console.ConsoleManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class RTP extends JavaPlugin {

    private ConfigManager configManager;
    private ConsoleManager consoleManager;
    @Override
    public void onEnable() {

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getCommand("rtp").setExecutor(new RandomTeleportCommand(this));
        getCommand("randomteleport").setExecutor(new ReloadConfigCommand(this));;

        configManager = new ConfigManager(this);
        consoleManager = new ConsoleManager(this);

        consoleManager.sendMessage(ChatColor.GREEN + "[RTP] Successfully enabled! Created by Nux <3!");

    }

    @Override
    public void onDisable() {

        consoleManager.sendMessage(ChatColor.RED + "[RTP] Successfully disabled!");

    }

    public ConfigManager getConfigManager() { return configManager; }
    public ConsoleManager getConsoleManager() { return consoleManager; }

}
