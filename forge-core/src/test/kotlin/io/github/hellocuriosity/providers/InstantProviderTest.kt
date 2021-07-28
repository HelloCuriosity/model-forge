package io.github.hellocuriosity.providers

import io.github.hellocuriosity.Millis.NINETEEN_EIGHTY_SIX
import io.github.hellocuriosity.Millis.TWENTY_TWENTY_ONE
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.eq
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.verifyNoMoreInteractions
import org.mockito.kotlin.whenever
import kotlin.random.Random
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@RunWith(MockitoJUnitRunner::class)
class InstantProviderTest {

    private val random: Random = mock()

    @After
    fun teardown() {
        verifyNoMoreInteractions(random)
    }

    @Test
    fun testGet() {
        val instant = InstantProvider().get()
        assertTrue(instant.toEpochMilli() in NINETEEN_EIGHTY_SIX until TWENTY_TWENTY_ONE)
    }

    @Test
    fun testGet_WithCustomTimeSpan() {
        val start = 1L
        val end = 2L
        val instant = InstantProvider(from = start, until = end).get()
        assertTrue(instant.toEpochMilli() in start until end)
    }

    @Test
    fun testGet_RandomCalled() {
        whenever(random.nextLong(any(), any())) doReturn 1315260000000L // 06.09.2011

        val instant = InstantProvider(random = random).get()
        assertEquals(1315260000000L, instant.toEpochMilli())

        verify(random).nextLong(eq(NINETEEN_EIGHTY_SIX), eq(TWENTY_TWENTY_ONE))
    }
}
