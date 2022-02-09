package io.github.hellocuriosity.providers

import javax.inject.Provider
import kotlin.random.Random

/**
 * Auto generates a boolean
 *
 * @param random random generator
 *
 * @return Boolean instance
 */
class BooleanProvider(
    private val random: Random = Random
) : Provider<Boolean> {

    override fun get(): Boolean =
        random.nextBoolean()
}
