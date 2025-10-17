package fr.yoboujon.rienalafraise;

import java.util.logging.Logger;

import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.CommandAPIBukkitConfig;
import dev.jorel.commandapi.CommandAPICommand;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin {
  private static final Logger LOGGER = Logger.getLogger("rienalafraise");

  @Override
  public void onLoad() {
    // CommandAPI.onLoad(new CommandAPIBukkitConfig(this).verboseOutput(true)); //
    // Load with verbose output
  }

  @Override
  public void onEnable() {
    CommandAPI.onEnable();
    // Register commands, listeners etc.
    new CommandAPICommand("yoyoping")
        .executes((sender, args) -> {
          sender.sendMessage("yoyopong!");
        })
        .register();
  }

  @Override
  public void onDisable() {
    CommandAPI.onDisable();
  }
}
