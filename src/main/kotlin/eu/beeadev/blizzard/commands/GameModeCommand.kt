package eu.beeadev.blizzard.commands

import eu.beeadev.blizzard.Blizzard
import net.minestom.server.command.CommandSender
import net.minestom.server.command.builder.Command
import net.minestom.server.command.builder.CommandContext
import net.minestom.server.command.builder.CommandExecutor
import net.minestom.server.command.builder.arguments.ArgumentType
import net.minestom.server.entity.GameMode
import net.minestom.server.entity.Player


class GameModeCommand : Command("gamemode", "gm", "changemode"), CommandExecutor {
    init {
        defaultExecutor = this
    }
    override fun apply(sender: CommandSender, context: CommandContext) {
        if (sender !is Player) {
            sender.sendMessage("§cYou can only execute this command as a player!")
            return
        }
        //if(player.hasPermission("blizzard.gamemode")) {
        sender.sendMessage("${Blizzard.PREFIX}§7Usage§8: /§7gamemode §8(§fSURVIVAL§8, §fCREATIVE§8, §fADVENTURE§8, §fSPECTATOR§8)")

        val gamemodeType = ArgumentType.Enum("gamemode", GameMode::class.java)
        addSyntax({ sender, context ->
            val player: Player = sender as Player
            val gamemode: GameMode = context.get(gamemodeType)
            player.gameMode = GameMode.valueOf(gamemode.name)
            sender.sendMessage("${Blizzard.PREFIX}§7Changed gamemode to §f$gamemode")
        }, gamemodeType)

        val gamemodeTypeNumerical = ArgumentType.Integer("gamemodeNum")
        addSyntax({ sender, context ->
            val player: Player = sender as Player
            when (context.get(gamemodeTypeNumerical)) {
                0 -> {
                    sender.gameMode = GameMode.SURVIVAL
                }
                1 -> {
                    sender.gameMode = GameMode.CREATIVE
                }
                2 -> {
                    sender.gameMode = GameMode.ADVENTURE
                }
                3 -> {
                    sender.gameMode = GameMode.SPECTATOR
                }
                else -> {
                    sender.sendMessage("§cError while parsing gamemode type!")
                    return@addSyntax
                }
            }
            sender.sendMessage("${Blizzard.PREFIX}§7Changed gamemode to §f${sender.gameMode}")
        }, gamemodeTypeNumerical)
    }

}