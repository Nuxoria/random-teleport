package me.dev.nux.rtp.console;

import me.dev.nux.rtp.RTP;
import org.bukkit.Bukkit;

public class ConsoleManager {

    RTP main;

    public ConsoleManager(RTP main) {
        this.main = main;
    }

    public void sendMessage(String message) {

        Bukkit.getConsoleSender().sendMessage(message);

    }

    public void sendLog(String message) {

        if (main.getConfigManager().getActivity()) {
            sendMessage(message);
        }

    }

}
