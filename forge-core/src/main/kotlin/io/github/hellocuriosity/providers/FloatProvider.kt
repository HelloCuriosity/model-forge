package io.github.hellocuriosity.providers

import kotlin.random.Random

/**
 * Auto generates a Float between two values
 *
 * @param min minimum value
 * @param max maximum value
 * @param random random generator
 *
 * @return Float instance
 */
class FloatProvider(
    private val min: Double = Float.MIN_VALUE.toDouble(),
    private val max: Double = Float.MAX_VALUE.toDouble(),
    private val random: Random = Random
) : Provider<Float> {

    override fun get(): Float =
        random.nextDouble(min, max).toFloat()
}
