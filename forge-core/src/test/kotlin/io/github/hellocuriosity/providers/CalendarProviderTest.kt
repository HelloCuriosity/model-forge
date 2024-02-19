package io.github.hellocuriosity.providers

import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.After
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class CalendarProviderTest {
    private val dateProvider: DateProvider = mockk()

    @After
    fun tearDown() {
        confirmVerified(dateProvider)
    }

    @Test
    fun testGet() {
        val date = DateProvider().get()
        every { dateProvider.get() } returns date

        val calendar = CalendarProvider(dateProvider = dateProvider).get()
        assertEquals(date, calendar.time)

        verify { dateProvider.get() }
    }

    @Test
    fun testGetWithCustomTimeSpan() {
        val start = 1L
        val end = 2L
        val calendar = CalendarProvider(from = start, until = end).get()
        assertTrue(calendar.timeInMillis in start until end)
    }
}
