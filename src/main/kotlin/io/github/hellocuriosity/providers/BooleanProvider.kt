package io.github.hellocuriosity.providers

import kotlin.random.Random

class BooleanProvider(
    private val random: Random = Random
) : Provider<Boolean> {

    override fun get(): Boolean =
        random.nextBoolean()
}
