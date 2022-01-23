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

class FloatProviderTest {

    private val random: Random = mockk()

    @After
    fun teardown() {
        confirmVerified(random)
    }

    @Test
    fun testGet() {
        val float = FloatProvider().get()
        assertTrue(float >= FloatProvider.DEFAULT_MIN)
        assertTrue(float <= FloatProvider.DEFAULT_MAX)
    }

    @Test
    fun testGetWithCustomMaxMin() {
        val min = 5.0
        val max = 10.0
        val float = FloatProvider(min = min, max = max).get()
        assertTrue(float >= min)
        assertTrue(float <= max)
    }

    @Test
    fun testGetRandomCalled() {
        val randomDouble = 15.0
        every { random.nextDouble(any(), any()) } returns randomDouble

        val min = 5.0
        val max = 10.0
        val float = FloatProvider(
            min = min,
            max = max,
            random = random
        ).get()

        assertEquals(randomDouble.toFloat(), float)

        verify { random.nextDouble(eq(min), eq(max)) }
    }
}
