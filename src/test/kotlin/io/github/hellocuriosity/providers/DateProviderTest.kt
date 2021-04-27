package io.github.hellocuriosity.providers

import io.github.hellocuriosity.providers.DateProvider.Companion.NINETEEN_EIGHTY_SIX
import io.github.hellocuriosity.providers.DateProvider.Companion.TWENTY_TWENTY_ONE
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.eq
import org.mockito.kotlin.verify
import org.mockito.kotlin.verifyNoMoreInteractions
import org.mockito.kotlin.whenever
import kotlin.random.Random
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@RunWith(MockitoJUnitRunner::class)
class DateProviderTest {

    @Mock
    private lateinit var random: Random

    @After
    fun teardown() {
        verifyNoMoreInteractions(random)
    }

    @Test
    fun testGet() {
        val date = DateProvider().get()
        assertTrue(date.time in NINETEEN_EIGHTY_SIX until TWENTY_TWENTY_ONE)
    }

    @Test
    fun testGet_WithCustomTimeSpan() {
        val start = 1L
        val end = 2L
        val date = DateProvider(from = start, until = end).get()
        assertTrue(date.time in start until end)
    }

    @Test
    fun testGet_RandomCalled() {
        whenever(random.nextLong(any(), any())) doReturn 1315260000000L // 06.09.2011

        val date = DateProvider(random = random).get()
        assertEquals(1315260000000L, date.time)

        verify(random).nextLong(eq(NINETEEN_EIGHTY_SIX), eq(TWENTY_TWENTY_ONE))
    }
}
