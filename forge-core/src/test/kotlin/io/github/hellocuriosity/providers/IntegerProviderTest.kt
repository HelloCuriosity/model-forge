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

class IntegerProviderTest {

    private val random: Random = mockk()

    @After
    fun teardown() {
        confirmVerified(random)
    }

    @Test
    fun testGet() {
        val integer = IntegerProvider().get()
        assertTrue(integer in IntegerProvider.DEFAULT_MIN until IntegerProvider.DEFAULT_MAX)
    }

    @Test
    fun testGet_WithCustomMaxMin() {
        val min = 5
        val max = 10
        val integer = IntegerProvider(min = min, max = max).get()
        assertTrue(integer in min until max)
    }

    @Test
    fun testGet_RandomCalled() {
        val randomInt = 15
        every { random.nextInt(any(), any()) } returns randomInt

        val min = 5
        val max = 10
        val integer = IntegerProvider(
            min = min,
            max = max,
            random = random
        ).get()

        assertEquals(randomInt, integer)

        verify { random.nextInt(eq(min), eq(max)) }
    }
}
