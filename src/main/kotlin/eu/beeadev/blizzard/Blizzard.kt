package eu.beeadev.blizzard

import net.minestom.server.MinecraftServer

class Blizzard {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val minecraftServer: MinecraftServer = MinecraftServer.init()
            minecraftServer.start("0.0.0.0", 25565)
        }
    }

}