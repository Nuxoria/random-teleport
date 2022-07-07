package me.dev.nux.rtp.teleport;

import me.dev.nux.rtp.RTP;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class TeleportManager {

    RTP main;
    public TeleportManager(RTP main) {
        this.main = main;
    }

    public Location calculateRandomLocation(Player p) {

        // CALCULATE RANDOM X AND RANDOM Y POSITION

        int minX = main.getConfigManager().getMinX();
        int minZ = main.getConfigManager().getMinZ();
        int maxX = main.getConfigManager().getMaxX();
        int maxZ = main.getConfigManager().getMaxZ();

        double randomX = generateRandomDoubleInRange(minX, maxX);
        double randomZ = generateRandomDoubleInRange(minZ, maxZ);

        p.sendMessage(main.getConfigManager().getProcessMessage());

        // CALCULATE RANDOM BUT A VALID Z POSITION (THAT MEANS NO SUFFICATION OR INSTANT DEATH)

        double randomY = calculateYCoordinate((int)randomX, (int)randomZ);

        if (randomY == 257) {
            return null;
        }

        String worldName = main.getConfigManager().getWorldName();

        Location randomLoc = new Location(Bukkit.getWorld(worldName), randomX, randomY, randomZ);

        return randomLoc;

    }

    public double generateRandomDoubleInRange(int min, int max) {

        double randomDouble = Math.random() * (max - min + 1) + min;

        return randomDouble;

    }

    public double calculateYCoordinate(int x, int z) {

        final int MAX_HEIGHT = 256;

        String worldName = main.getConfigManager().getWorldName();

        for (int y = MAX_HEIGHT; y > 0; --y) {

            Material block = Bukkit.getWorld(worldName).getBlockAt(x, y, z).getType();

            if (Bukkit.getVersion().contains("1.8") ||
                    Bukkit.getVersion().contains("1.9") ||
                    Bukkit.getVersion().contains("1.10") ||
                    Bukkit.getVersion().contains("1.11") ||
                    Bukkit.getVersion().contains("1.12")) {

                if (!block.equals(Material.AIR)) {

                    double yCoord = y + 2;

                    return yCoord;

                }

            } else {

                if (!block.equals(Material.AIR)) {

                    double yCoord = y + 2;

                    return yCoord;

                }

            }

        }

        return 257;

    }

}
