package eu.beeadev.blizzard.events

import eu.beeadev.blizzard.Blizzard
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.minestom.server.MinecraftServer
import net.minestom.server.coordinate.Pos
import net.minestom.server.entity.Player
import net.minestom.server.entity.PlayerSkin
import net.minestom.server.event.Event
import net.minestom.server.event.player.PlayerLoginEvent
import net.minestom.server.item.*
import net.minestom.server.network.ConnectionManager
import java.util.*


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
            player.sendMessage("${Blizzard.PREFIX}§f${player.username} §7has joined the game")
            val item = ItemStack.builder(Material.STONE)
                .displayName(Component.text("Display name!", NamedTextColor.GREEN))
                .lore(Component.text("Line 1"), Component.text("Line 2"))
                .meta { metaBuilder: ItemMeta.Builder ->
                    metaBuilder.enchantment(Enchantment.EFFICIENCY, 10.toShort())
                        .hideFlag(ItemHideFlag.HIDE_ENCHANTS)
                }
                .build()
            player.inventory.addItemStack(item)

            val connectionManager: ConnectionManager = ConnectionManager()
            connectionManager.setUuidProvider { playerConnection, username -> UUID.randomUUID() }
            System.out.println(player.playerConnection.player?.uuid)
            //TODO: Skins
        }
    }
}