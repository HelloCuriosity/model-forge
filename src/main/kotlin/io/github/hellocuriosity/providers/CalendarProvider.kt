package io.github.hellocuriosity.providers

import java.util.Calendar

class CalendarProvider(
    private val from: Long = NINETEEN_EIGHTY_SIX,
    private val until: Long = TWENTY_TWENTY_ONE,
    private val dateProvider: DateProvider = DateProvider(from, until)
) : Provider<Calendar> {
    companion object {
        const val NINETEEN_EIGHTY_SIX = 529714800000L
        const val TWENTY_TWENTY_ONE = 1617141600000L
    }

    override fun get(): Calendar {
        val calendar = Calendar.getInstance()
        calendar.time = dateProvider.get()
        return calendar
    }
}
