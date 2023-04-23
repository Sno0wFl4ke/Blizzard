package eu.beeadev.blizzard.commands

import eu.beeadev.blizzard.Blizzard
import net.minestom.server.command.CommandSender
import net.minestom.server.command.builder.Command
import net.minestom.server.command.builder.CommandContext
import net.minestom.server.command.builder.CommandExecutor
import net.minestom.server.command.builder.arguments.ArgumentType
import net.minestom.server.entity.Player


class FlyCommand : Command("fly", "flight", "togglefly") {
    init {
        defaultExecutor = CommandExecutor { sender: CommandSender, context: CommandContext? ->
            run {
                if (sender is Player) {
                    val player: Player = sender.asPlayer()
                    //if(player.hasPermission("blizzard.fly")) {
                        if (!player.isAllowFlying) {
                            player.isAllowFlying = true
                            player.sendMessage(Blizzard.prefix + "§7Fly §8→ §a✔")
                        } else {
                            player.isAllowFlying = false
                            if (player.isFlying) player.isFlying = false
                            player.sendMessage(Blizzard.prefix + "§7Fly §8→ §c✖")
                        }
                    //}
                } else {
                    sender.sendMessage("§cYou can only execute this command as a player!")
                }
            }
        }
    }

}