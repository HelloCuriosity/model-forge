package io.github.hellocuriosity.providers

import kotlin.random.Random

/**
 * Auto generates a Long between two values
 *
 * @param min minimum value
 * @param max maximum value
 * @param random random generator
 *
 * @return Long instance
 */
class LongProvider(
    private val min: Long = Long.MIN_VALUE,
    private val max: Long = Long.MAX_VALUE,
    private val random: Random = Random,
) : Provider<Long> {
    override fun get(): Long = random.nextLong(min, max)
}
