package net.abitmorehex.api.blockiota

import at.petrak.hexcasting.api.spell.iota.Iota
import at.petrak.hexcasting.api.spell.iota.IotaType
import at.petrak.hexcasting.api.spell.iota.VectorIota
import net.minecraft.nbt.CompoundTag
import net.minecraft.core.BlockPos
import net.minecraft.world.level.Level
import ram.talia.hexal.api.mediafieditems.ItemIota // Import for mediafied items

// Make BlockIota a concrete class (not abstract) if you intend to instantiate it
class BlockIota(val blockPos: BlockPos, val level: Level) : Iota {

    // Serialize method to convert BlockIota to a CompoundTag
    override fun serialize(): CompoundTag {
        val tag = CompoundTag()
        tag.putLong("Pos", blockPos.asLong())
        tag.putString("Level", level.dimension().location().toString())
        return tag
    }

    // Return the custom IotaType
    override fun getType(): IotaType<*> {
        return MyModIotaTypes.BLOCK_IOTA // Ensure MyModIotaTypes is defined correctly
    }

    // Required method to determine if the Iota is "truthy"
    override fun isTruthy(): Boolean {
        return true
    }

    // Convert the BlockIota to an ItemIota
    fun toMedifiedItemIota(): ItemIota? {
        val blockState = level.getBlockState(blockPos)
        val itemStack = blockState.block.asItem().defaultInstance
        return if (!itemStack.isEmpty) {
            ItemIota(itemStack, true)
        } else {
            null
        }
    }

    companion object {
        // Method to create a BlockIota from a VectorIota
        fun fromVectorIota(vectorIota: VectorIota, level: Level): BlockIota? {
            val pos = BlockPos(vectorIota.vector.x, vectorIota.vector.y, vectorIota.vector.z)
            return if (level.isLoaded(pos)) {
                BlockIota(pos, level)
            } else {
                null
            }
        }
    }
}
