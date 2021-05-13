package io.github.hellocuriosity.providers

import io.github.hellocuriosity.Millis.NINETEEN_EIGHTY_SIX
import io.github.hellocuriosity.Millis.TWENTY_TWENTY_ONE
import java.util.Date
import kotlin.random.Random

class DateProvider(
    private val from: Long = NINETEEN_EIGHTY_SIX,
    private val until: Long = TWENTY_TWENTY_ONE,
    private val random: Random = Random
) : Provider<Date> {

    override fun get(): Date =
        Date(random.nextLong(from, until))
}
