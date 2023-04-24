package eu.beeadev.blizzard.commands

import eu.beeadev.blizzard.Blizzard
import net.kyori.adventure.text.Component
import net.minestom.server.command.CommandSender
import net.minestom.server.command.builder.Command
import net.minestom.server.command.builder.CommandContext
import net.minestom.server.command.builder.CommandExecutor
import net.minestom.server.entity.Player


class SuicideCommand : Command("suicide"), CommandExecutor {
    init {
        defaultExecutor = this
    }
    override fun apply(sender: CommandSender, context: CommandContext) {
        if (sender !is Player) {
            sender.sendMessage("§cYou can only execute this command as a player!")
            return
        }
        //if(!player.hasPermission("blizzard.fly")) return;
        sender.health = 0.0F
        sender.sendMessage("${Blizzard.PREFIX}§7You killed yourself")
    }

}