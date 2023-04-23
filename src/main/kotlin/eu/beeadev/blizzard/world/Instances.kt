package eu.beeadev.blizzard.world

import eu.beeadev.blizzard.world.types.DefaultWorldInstance
import net.minestom.server.MinecraftServer
import net.minestom.server.instance.InstanceContainer
import net.minestom.server.instance.InstanceManager


class Instances {

    private val instanceManager: InstanceManager = MinecraftServer.getInstanceManager()
    private val instanceContainer: InstanceContainer = instanceManager.createInstanceContainer()
    private var sharedInstance = instanceManager.createSharedInstance(instanceContainer)

    fun registerInstances() {
        instanceManager.registerInstance(DefaultWorldInstance())
        val instance = instanceManager.createInstanceContainer()
        instance.saveChunksToStorage()
    }

}