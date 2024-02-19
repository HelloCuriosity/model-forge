package io.github.hellocuriosity.providers

import io.github.hellocuriosity.Millis.NINETEEN_EIGHTY_SIX
import io.github.hellocuriosity.Millis.TWENTY_TWENTY_ONE
import java.util.Calendar

/**
 * Auto generates a Calendar instance between two dates
 *
 * @param from start date in millis
 * @param until end date in millis
 * @param dateProvider data generator
 *
 * @return Instance of Calendar
 */
class CalendarProvider(
    private val from: Long = NINETEEN_EIGHTY_SIX,
    private val until: Long = TWENTY_TWENTY_ONE,
    private val dateProvider: DateProvider = DateProvider(from, until),
) : Provider<Calendar> {
    override fun get(): Calendar {
        val calendar = Calendar.getInstance()
        calendar.time = dateProvider.get()
        return calendar
    }
}
