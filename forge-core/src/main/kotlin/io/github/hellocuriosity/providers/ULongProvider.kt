package io.github.hellocuriosity.providers

import kotlin.random.Random
import kotlin.random.nextULong

/**
 * Auto generates a ULong between two values
 *
 * @param min minimum value
 * @param max maximum value
 * @param random random generator
 *
 * @return ULong instance
 */
class ULongProvider(
    private val min: ULong = ULong.MIN_VALUE,
    private val max: ULong = ULong.MAX_VALUE,
    private val random: Random = Random,
) : Provider<ULong> {
    override fun get(): ULong = random.nextULong(min, max)
}
