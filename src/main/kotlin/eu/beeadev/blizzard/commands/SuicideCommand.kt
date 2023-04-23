package eu.beeadev.blizzard.commands

import eu.beeadev.blizzard.Blizzard
import net.kyori.adventure.text.Component
import net.minestom.server.command.CommandSender
import net.minestom.server.command.builder.Command
import net.minestom.server.command.builder.CommandContext
import net.minestom.server.command.builder.CommandExecutor
import net.minestom.server.entity.Player


class SuicideCommand : Command("suicide") {
    init {
        defaultExecutor = CommandExecutor { sender: CommandSender, context: CommandContext? ->
            run {
                if (sender is Player) {
                    val player: Player = sender.asPlayer()
                    //if(player.hasPermission("blizzard.suicide")) {
                    player.sendMessage(Blizzard.prefix + "§c☠ §7You have killed yourself!")
                    player.instance?.sendMessage(Component.text("§c☠ §f${player.username} §7died through suicide!"))
                    player.health = 0.0F
                    //}
                } else {
                    sender.sendMessage("§cYou can only execute this command as a player!")
                }
            }
        }
    }

}