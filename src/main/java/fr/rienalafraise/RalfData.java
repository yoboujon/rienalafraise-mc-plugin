package fr.yoboujon.rienalafraise;

import java.io.File;
import java.io.IOException;
import java.lang.Integer;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class RalfData {
    private static RalfData instance;
    private JavaPlugin plugin;
    private FileConfiguration dataConfig;
    private File file;

    public RalfData() {
        instance = this;
    }

    public void init(JavaPlugin plugin) {
        this.plugin = plugin;
        createfile();
    }

    public static RalfData getInstance() {
        return instance;
    }

    private void createfile() {
        file = new File(plugin.getDataFolder(), "data.yml");
        if (!file.exists()) {
            try {
                plugin.getDataFolder().mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        dataConfig = YamlConfiguration.loadConfiguration(file);
    }

    public void addPoint(Integer num) {
        int points = dataConfig.getInt("teams.red.points", 0);
        dataConfig.set("teams.red.points", points + num);
        saveData();
    }

    public Integer getPoint() {
        return dataConfig.getInt("teams.red.points", 0);
    }

    public void saveData() {
        try {
            dataConfig.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
