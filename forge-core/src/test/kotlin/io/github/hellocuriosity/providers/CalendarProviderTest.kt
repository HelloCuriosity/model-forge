package io.github.hellocuriosity.providers

import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.verifyNoMoreInteractions
import org.mockito.kotlin.whenever
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@RunWith(MockitoJUnitRunner::class)
class CalendarProviderTest {

    private val dateProvider: DateProvider = mock()

    @After
    fun tearDown() {
        verifyNoMoreInteractions(dateProvider)
    }

    @Test
    fun testGet() {
        val date = DateProvider().get()
        whenever(dateProvider.get()) doReturn date

        val calendar = CalendarProvider(dateProvider = dateProvider).get()
        assertEquals(date, calendar.time)

        verify(dateProvider).get()
    }

    @Test
    fun testGet_WithCustomTimeSpan() {
        val start = 1L
        val end = 2L
        val calendar = CalendarProvider(from = start, until = end).get()
        assertTrue(calendar.timeInMillis in start until end)
    }
}
