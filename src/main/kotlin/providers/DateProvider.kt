package providers

import java.util.Date
import kotlin.random.Random

class DateProvider(
    private val from: Long = NINETEEN_EIGHTY_SIX,
    private val until: Long = TWENTY_TWENTY_ONE,
    private val random: Random = Random
) : Provider<Date> {

    companion object {
        const val NINETEEN_EIGHTY_SIX = 529714800000L
        const val TWENTY_TWENTY_ONE = 1617141600000L
    }

    override fun get(): Date =
        Date(random.nextLong(from, until))
}
