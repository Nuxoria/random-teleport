package me.dev.nux.rtp.config;

import me.dev.nux.rtp.RTP;
import org.bukkit.ChatColor;

public class ConfigManager {

    RTP main;

    public ConfigManager(RTP main) {
        this.main = main;
    }

    public int getMinX() {
        return (main.getConfig().getInt("options.range.min.x"));
    }

    public int getMaxX() {
        return (main.getConfig().getInt("options.range.max.x"));
    }

    public int getMinZ() {
        return (main.getConfig().getInt("options.range.min.z"));
    }

    public int getMaxZ() {
        return (main.getConfig().getInt("options.range.max.z"));
    }

    public String getWorldName() { return (main.getConfig().getString("options.world.world-name")); }

    public String getSuccessMessage() { return ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("options.messages.teleport-success")); }

    public String getProcessMessage() { return ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("options.messages.teleport-in-process")); }

    public String getFailMessage() { return ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("options.messages.teleport-failure")); }

    public String getReloadUsage() { return ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("options.messages.wrong-reload-config-usage"));}
    public String getWrongUsageMessage() { return ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("options.messages.wrong-command-usage")); }

    public String getConfigReloadMessage() { return ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("options.messages.config-reload")); }

    public boolean getActivity() { return (main.getConfig().getBoolean("options.messages.log-activity")); }

}
