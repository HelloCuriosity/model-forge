package io.github.hellocuriosity.providers

import io.mockk.confirmVerified
import io.mockk.mockk
import org.junit.After
import org.junit.Test
import kotlin.random.Random
import kotlin.test.assertTrue

class UIntProviderTest {
    private val random: Random = mockk()

    @After
    fun teardown() {
        confirmVerified(random)
    }

    @Test
    fun testGet() {
        val uInteger = UIntProvider().get()
        assertTrue(uInteger in UInt.MIN_VALUE until UInt.MAX_VALUE)
    }

    @Test
    fun testGetWithCustomMaxMin() {
        val min = 5u
        val max = 10u
        val uInteger = UIntProvider(min = min, max = max).get()
        assertTrue(uInteger in min until max)
    }
}
