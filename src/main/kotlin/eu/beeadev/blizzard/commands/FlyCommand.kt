package eu.beeadev.blizzard.commands

import eu.beeadev.blizzard.Blizzard
import net.minestom.server.command.CommandSender
import net.minestom.server.command.builder.Command
import net.minestom.server.command.builder.CommandContext
import net.minestom.server.command.builder.CommandExecutor
import net.minestom.server.command.builder.arguments.ArgumentType
import net.minestom.server.entity.Player


class FlyCommand : Command("fly", "flight", "togglefly"), CommandExecutor {
    init {
        defaultExecutor = this
    }
    override fun apply(sender: CommandSender, context: CommandContext) {
        if (sender !is Player) {
            sender.sendMessage("§cYou can only execute this command as a player!")
            return
        }
            //if(player.hasPermission("blizzard.fly")) {
        if (!sender.isAllowFlying) {
            sender.isAllowFlying = true
            sender.sendMessage("${Blizzard.PREFIX}§7Fly §8→ §a✔")
        } else {
            sender.isAllowFlying = false
            if (sender.isFlying) sender.isFlying = false
            sender.sendMessage("${Blizzard.PREFIX}§7Fly §8→ §c✖")
        }
    }

}