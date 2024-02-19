package io.github.hellocuriosity.providers

import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.After
import org.junit.Test
import kotlin.random.Random
import kotlin.test.assertTrue

class BooleanProviderTest {
    private val random: Random = mockk()

    @After
    fun teardown() {
        confirmVerified(random)
    }

    @Test
    fun testGet() {
        every { random.nextBoolean() } returns true

        val boolean = BooleanProvider(random = random).get()
        assertTrue(boolean)

        verify { random.nextBoolean() }
    }
}
