package eu.beeadev.blizzard.events

import eu.beeadev.blizzard.Blizzard
import net.minestom.server.MinecraftServer
import net.minestom.server.coordinate.Pos
import net.minestom.server.entity.Player
import net.minestom.server.entity.PlayerSkin
import net.minestom.server.event.Event
import net.minestom.server.event.player.PlayerLoginEvent


class HandlePlayerJoinEvent() : Event {
    init {
        handlePlayerJoin()
    }

    private fun handlePlayerJoin() {
        val handler = MinecraftServer.getGlobalEventHandler()
        handler.addListener(PlayerLoginEvent::class.java) { event ->
            val player: Player = event.getPlayer()

            player.skin = PlayerSkin.fromUsername("Sno0wFl4ke")
            event.setSpawningInstance(Blizzard.instanceContainer)
            player.respawnPoint = Pos(0.0, 42.0, 0.0)
            player.sendMessage("${Blizzard.prefix}§f${player.username} §7has joined the game")
        }
    }
}