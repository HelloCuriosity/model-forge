package io.github.hellocuriosity.providers

import io.github.hellocuriosity.Millis.NINETEEN_EIGHTY_SIX
import io.github.hellocuriosity.Millis.TWENTY_TWENTY_ONE
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.After
import org.junit.Test
import kotlin.random.Random
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class InstantProviderTest {

    private val random: Random = mockk()

    @After
    fun teardown() {
        confirmVerified(random)
    }

    @Test
    fun testGet() {
        val instant = InstantProvider().get()
        assertTrue(instant.toEpochMilli() in NINETEEN_EIGHTY_SIX until TWENTY_TWENTY_ONE)
    }

    @Test
    fun testGetWithCustomTimeSpan() {
        val start = 1L
        val end = 2L
        val instant = InstantProvider(from = start, until = end).get()
        assertTrue(instant.toEpochMilli() in start until end)
    }

    @Test
    fun testGetRandomCalled() {
        every { random.nextLong(any(), any()) } returns 1315260000000L // 06.09.2011

        val instant = InstantProvider(random = random).get()
        assertEquals(1315260000000L, instant.toEpochMilli())

        verify { random.nextLong(eq(NINETEEN_EIGHTY_SIX), eq(TWENTY_TWENTY_ONE)) }
    }
}
