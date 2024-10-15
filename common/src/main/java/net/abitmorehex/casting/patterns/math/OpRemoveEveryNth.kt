package net.abitmorehex.casting.patterns.math

import at.petrak.hexcasting.api.spell.ConstMediaAction
import at.petrak.hexcasting.api.spell.asActionResult
import at.petrak.hexcasting.api.spell.casting.CastingContext
import at.petrak.hexcasting.api.spell.getList
import at.petrak.hexcasting.api.spell.getPositiveIntUnderInclusive
import at.petrak.hexcasting.api.spell.iota.Iota

class OpRemoveEveryNth : ConstMediaAction {
    override val argc = 2

    override fun execute(args: List<Iota>, ctx: CastingContext): List<Iota> {
        val list = args.getList(0, argc)
        val n = args.getPositiveIntUnderInclusive(1, list.size(), argc)

        // Create a new list by filtering out every nth element
        val filteredList = list.filterIndexed { index, _ -> (index + 1) % n != 0 }

        return filteredList.asActionResult
    }
}