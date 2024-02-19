package io.github.hellocuriosity.providers

import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.After
import org.junit.Test
import kotlin.random.Random
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class DoubleProviderTest {
    private val random: Random = mockk()

    @After
    fun teardown() {
        confirmVerified(random)
    }

    @Test
    fun testGet() {
        val double = DoubleProvider().get()
        assertTrue(double >= Double.MIN_VALUE)
        assertTrue(double <= Double.MAX_VALUE)
    }

    @Test
    fun testGetWithCustomMaxMin() {
        val min = 5.0
        val max = 10.0
        val double = DoubleProvider(min = min, max = max).get()
        assertTrue(double >= min)
        assertTrue(double <= max)
    }

    @Test
    fun testGetRandomCalled() {
        val randomDouble = 15.0
        every { random.nextDouble(any(), any()) } returns randomDouble

        val min = 5.0
        val max = 10.0
        val double =
            DoubleProvider(
                min = min,
                max = max,
                random = random,
            ).get()

        assertEquals(randomDouble, double)

        verify { random.nextDouble(eq(min), eq(max)) }
    }
}
