package io.github.hellocuriosity.providers

import kotlin.random.Random

/**
 * Auto generates an Int between two values
 *
 * @param min minimum value
 * @param max maximum value
 * @param random random generator
 *
 * @return Int instance
 */
class IntegerProvider(
    private val min: Int = DEFAULT_MIN,
    private val max: Int = DEFAULT_MAX,
    private val random: Random = Random
) : Provider<Int> {
    companion object {
        const val DEFAULT_MIN = 1
        const val DEFAULT_MAX = 100000
    }

    override fun get(): Int =
        random.nextInt(min, max)
}
