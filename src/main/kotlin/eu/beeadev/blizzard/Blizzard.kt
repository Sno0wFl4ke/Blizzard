package eu.beeadev.blizzard

import eu.beeadev.blizzard.commands.*
import eu.beeadev.blizzard.events.HandlePlayerJoinEvent
import net.minestom.server.MinecraftServer
import net.minestom.server.MinecraftServer.getCommandManager
import net.minestom.server.command.builder.Command
import net.minestom.server.instance.block.Block
import net.minestom.server.instance.generator.GenerationUnit


object Blizzard {

    @JvmStatic
    var PREFIX: String = "§8【§bBlizzard§8】"
    val minecraftServer = MinecraftServer.init()
    val instanceManager = MinecraftServer.getInstanceManager()
    val instanceContainer = instanceManager.createInstanceContainer()

    @JvmStatic
    fun main(args: Array<String>) {
        instanceContainer.setGenerator { unit: GenerationUnit ->
            unit.modifier().fillHeight(0, 40, Block.GRASS_BLOCK)
        }
        registerCommands()
        registerEvents()
        minecraftServer.start("0.0.0.0", 25565)
    }

    private fun registerEvents() {
        HandlePlayerJoinEvent()
    }

    private fun registerCommands() {
        getCommandManager().register(GameModeCommand())
        getCommandManager().register(FlyCommand())
        getCommandManager().register(InstantBreakCommand())
        getCommandManager().register(GodCommand())
        getCommandManager().register(SuicideCommand())
    }
}