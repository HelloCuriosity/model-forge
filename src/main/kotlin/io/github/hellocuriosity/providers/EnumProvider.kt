package io.github.hellocuriosity.providers

import io.github.hellocuriosity.ModelForgeException
import kotlin.random.Random

/**
 * Auto generates an enum value
 *
 * @param <T> Type to instantiate
 * @param random random generator
 *
 * @return enum value
 */
fun <T> Class<T>.getEnum(random: Random = Random): Any {
    if (enumConstants.isNotEmpty()) {
        val idx = random.nextInt(enumConstants.size)
        return enumConstants[idx] ?: throw ModelForgeException("$this is null")
    } else throw ModelForgeException("$this does not define enum values")
}
