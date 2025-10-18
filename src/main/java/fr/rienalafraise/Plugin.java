package fr.yoboujon.rienalafraise;

import java.util.Collection;
import java.util.logging.Logger;

import fr.yoboujon.rienalafraise.RalfCommand;
import fr.yoboujon.rienalafraise.RalfData;
import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.RegisteredCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin {
  private static final Logger LOGGER = Logger.getLogger("rienalafraise");

  @Override
  public void onLoad() {
    RalfData data = new RalfData();
    data.init(this);
    CommandAPI.registerCommand(RalfCommand.class);
  }

  @Override
  public void onEnable() {
    CommandAPI.onEnable();
  }

  @Override
  public void onDisable() {
    CommandAPI.onDisable();
  }
}
