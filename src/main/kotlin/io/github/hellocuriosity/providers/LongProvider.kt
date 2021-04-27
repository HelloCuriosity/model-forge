package io.github.hellocuriosity.providers

import kotlin.random.Random

class LongProvider(
    private val min: Long = DEFAULT_MIN,
    private val max: Long = DEFAULT_MAX,
    private val random: Random = Random
) : Provider<Long> {

    companion object {
        const val DEFAULT_MIN = 1L
        const val DEFAULT_MAX = 100000L
    }

    override fun get(): Long =
        random.nextLong(min, max)
}
