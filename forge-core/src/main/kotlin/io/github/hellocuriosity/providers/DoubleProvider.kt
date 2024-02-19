package io.github.hellocuriosity.providers

import kotlin.random.Random

/**
 * Auto generates a Double between two values
 *
 * @param min minimum value
 * @param max maximum value
 * @param random random generator
 *
 * @return Double instance
 */
class DoubleProvider(
    private val min: Double = Double.MIN_VALUE,
    private val max: Double = Double.MAX_VALUE,
    private val random: Random = Random,
) : Provider<Double> {
    override fun get(): Double = random.nextDouble(min, max)
}
