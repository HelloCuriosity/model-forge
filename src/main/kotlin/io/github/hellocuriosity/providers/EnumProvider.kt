package io.github.hellocuriosity.providers

import io.github.hellocuriosity.ModelForgeException
import kotlin.random.Random

fun <T> Class<T>.getEnum(random: Random = Random): Any {
    if (this.enumConstants.isNotEmpty()) {
        val idx = random.nextInt(this.enumConstants.size)
        return this.enumConstants[idx] ?: throw ModelForgeException("$this is null")
    } else throw ModelForgeException("$this does not define enum values")
}
