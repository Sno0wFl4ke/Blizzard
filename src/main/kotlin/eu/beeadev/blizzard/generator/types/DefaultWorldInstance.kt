package eu.beeadev.blizzard.generator.types

import net.minestom.server.coordinate.Point
import net.minestom.server.entity.Player
import net.minestom.server.instance.Chunk
import net.minestom.server.instance.Instance
import net.minestom.server.instance.block.Block
import net.minestom.server.instance.block.BlockFace
import net.minestom.server.instance.block.BlockHandler
import net.minestom.server.instance.generator.Generator
import net.minestom.server.world.DimensionType
import java.util.*
import java.util.concurrent.CompletableFuture

class DefaultWorldInstance : Instance(UUID.randomUUID(), DimensionType.OVERWORLD) {

    override fun setBlock(x: Int, y: Int, z: Int, block: Block) {
        TODO("Not yet implemented")
    }

    override fun placeBlock(placement: BlockHandler.Placement): Boolean {
        TODO("Not yet implemented")
    }

    override fun breakBlock(player: Player, blockPosition: Point, blockFace: BlockFace): Boolean {
        TODO("Not yet implemented")
    }

    override fun loadChunk(chunkX: Int, chunkZ: Int): CompletableFuture<Chunk> {
        TODO("Not yet implemented")
    }

    override fun loadOptionalChunk(chunkX: Int, chunkZ: Int): CompletableFuture<Chunk?> {
        TODO("Not yet implemented")
    }

    override fun unloadChunk(chunk: Chunk) {
        TODO("Not yet implemented")
    }

    override fun getChunk(chunkX: Int, chunkZ: Int): Chunk? {
        TODO("Not yet implemented")
    }

    override fun saveInstance(): CompletableFuture<Void> {
        TODO("Not yet implemented")
    }

    override fun saveChunkToStorage(chunk: Chunk): CompletableFuture<Void> {
        TODO("Not yet implemented")
    }

    override fun saveChunksToStorage(): CompletableFuture<Void> {
        TODO("Not yet implemented")
    }

    override fun generator(): Generator? {
        TODO("Not yet implemented")
    }

    override fun setGenerator(generator: Generator?) {
        TODO("Not yet implemented")
    }

    override fun getChunks(): MutableCollection<Chunk> {
        TODO("Not yet implemented")
    }

    override fun enableAutoChunkLoad(enable: Boolean) {
        TODO("Not yet implemented")
    }

    override fun hasEnabledAutoChunkLoad(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isInVoid(point: Point): Boolean {
        TODO("Not yet implemented")
    }
}