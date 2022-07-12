package io.github.hellocuriosity.providers

import kotlin.random.Random
import kotlin.random.nextUInt

/**
 * Auto generates an UInt between two values
 *
 * @param min minimum value
 * @param max maximum value
 * @param random random generator
 *
 * @return UInt instance
 */
class UIntProvider(
    private val min: UInt = UInt.MIN_VALUE,
    private val max: UInt = UInt.MAX_VALUE,
    private val random: Random = Random,
) : Provider<UInt> {
    override fun get(): UInt = random.nextUInt(min, max)
}
