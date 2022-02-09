package io.github.hellocuriosity.providers

import javax.inject.Provider
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
    private val min: Int = Int.MIN_VALUE,
    private val max: Int = Int.MAX_VALUE,
    private val random: Random = Random
) : Provider<Int> {

    override fun get(): Int =
        random.nextInt(min, max)
}
