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

class LongProviderTest {
    private val random: Random = mockk()

    @After
    fun teardown() {
        confirmVerified(random)
    }

    @Test
    fun testGet() {
        val long = LongProvider().get()
        assertTrue(long in Long.MIN_VALUE until Long.MAX_VALUE)
    }

    @Test
    fun testGetWithCustomMaxMin() {
        val min = 5L
        val max = 10L
        val long = LongProvider(min = min, max = max).get()
        assertTrue(long in min until max)
    }

    @Test
    fun testGetRandomCalled() {
        val randomLong = 15L

        every { random.nextLong(any(), any()) } returns randomLong
        val min = 5L
        val max = 10L
        val long =
            LongProvider(
                min = min,
                max = max,
                random = random,
            ).get()

        assertEquals(randomLong, long)

        verify { random.nextLong(eq(min), eq(max)) }
    }
}
