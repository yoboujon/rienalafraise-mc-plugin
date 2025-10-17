package fr.yoboujon.rienalafraise;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.annotations.*;
import dev.jorel.commandapi.annotations.arguments.AMultiLiteralArgument;
import dev.jorel.commandapi.annotations.arguments.APlayerArgument;
import dev.jorel.commandapi.arguments.PlayerArgument;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

@Command("ralf")
public class RalfCommand {
    @Default
    public static void ralf(CommandSender sender) {
        sender.sendMessage("--- Rien A La Fraise help ---");
        sender.sendMessage("/ralf - Show this help");
        sender.sendMessage("/ralf init - Initialize the teams");
        sender.sendMessage("/ralf join <Player> <Team> - Player joins the team");
    }

    @Subcommand("init")
    public static void init(CommandSender sender) {
        Bukkit.dispatchCommand(sender, "scoreboard objectives add team_points dummy \"Points\"");
        Bukkit.dispatchCommand(sender, "scoreboard objectives setdisplay sidebar team_points");
        Bukkit.dispatchCommand(sender, "scoreboard players set §4Red team_points 0");
        Bukkit.dispatchCommand(sender, "scoreboard players set §9Blue team_points 0");
        Bukkit.dispatchCommand(sender, "scoreboard players set §2Green team_points 0");
        Bukkit.dispatchCommand(sender, "scoreboard players set §6Yellow team_points 0");
        sender.sendMessage("Team points initialized!");
    }

    @Subcommand("join")
    public static void join(
            CommandSender sender,
            @APlayerArgument Player player,
            @AMultiLiteralArgument({ "red", "blue", "green", "yellow" }) String team) {
        Bukkit.dispatchCommand(sender, "team join " + team + " " + player.getName());
        sender.sendMessage(player.getName() + " joined team " + team);
    }
}
