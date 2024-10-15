package net.abitmorehex.casting.patterns.math

import at.petrak.hexcasting.api.misc.MediaConstants
import at.petrak.hexcasting.api.spell.ConstMediaAction
import at.petrak.hexcasting.api.spell.asActionResult
import at.petrak.hexcasting.api.spell.casting.CastingContext
import at.petrak.hexcasting.api.spell.iota.DoubleIota
import at.petrak.hexcasting.api.spell.iota.Iota
import at.petrak.hexcasting.api.spell.iota.ListIota
import at.petrak.hexcasting.api.spell.iota.NullIota
import at.petrak.hexcasting.api.spell.iota.Vec3Iota
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Vec3d

class OpBlockRaycastWithBacktrack : ConstMediaAction {
    override val argc = 3
    override val mediaCost = MediaConstants.DUST_UNIT / 100

    override fun execute(args: List<Iota>, ctx: CastingContext): List<Iota> {
        val origin = (args[0] as Vec3Iota).vec3
        val look = (args[1] as Vec3Iota).vec3
        val backtrackDistance = (args[2] as DoubleIota).double

        ctx.assertVecInRange(origin)

        // Calculate the normalized direction vector
        val direction = look.subtract(origin).normalize()
        var currentPos = origin
        var blockHitResult: BlockPos? = null

        // Manual raycast by stepping along the vector
        for (i in 0..100) { // Assuming a max range of 100 blocks
            val stepPos = currentPos.add(direction.multiply(1.0)) // Correctly step in the direction
            val blockPos = BlockPos(stepPos)
            if (!ctx.world.isAir(blockPos)) {
                blockHitResult = blockPos
                break
            }
            currentPos = stepPos
        }
        return if (blockHitResult != null && ctx.isVecInRange(Vec3d.ofCenter(blockHitResult))) {
            val blocks = mutableListOf<Iota>()
            val hitCenter = Vec3d.ofCenter(blockHitResult)

            for (i in 0 until backtrackDistance.toInt()) {
                // Calculate position by moving backward along the direction vector
                val backtrackVec = hitCenter.subtract(direction.multiply(i.toDouble())) // Move along the correct direction
                val blockPos = BlockPos(backtrackVec.x, backtrackVec.y, backtrackVec.z) // Convert to BlockPos
                if (ctx.isVecInRange(Vec3d.ofCenter(blockPos))) {
                    blocks.add(Vec3Iota(Vec3d.ofCenter(blockPos)))
                }
            }
            listOf(ListIota(blocks))  // Return a single ListIota containing all positions
        } else {
            listOf(NullIota())
        }

    }
}
