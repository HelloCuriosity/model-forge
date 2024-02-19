package io.github.hellocuriosity.providers

import io.github.hellocuriosity.Millis.NINETEEN_EIGHTY_SIX
import io.github.hellocuriosity.Millis.TWENTY_TWENTY_ONE
import java.time.Instant
import kotlin.random.Random

/**
 * Auto generates an Instant instance between two dates
 *
 * @param from start date in millis
 * @param until end date in millis
 * @param random random generator
 *
 * @return Instance of Instant
 */
class InstantProvider(
    private val from: Long = NINETEEN_EIGHTY_SIX,
    private val until: Long = TWENTY_TWENTY_ONE,
    private val random: Random = Random,
) : Provider<Instant> {
    override fun get(): Instant = Instant.ofEpochMilli(random.nextLong(from, until))
}
