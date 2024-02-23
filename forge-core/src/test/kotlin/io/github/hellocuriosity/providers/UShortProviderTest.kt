package io.github.hellocuriosity.providers

import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.After
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class UShortProviderTest {
    private val provider: UIntProvider = mockk()

    @After
    fun teardown() {
        confirmVerified(provider)
    }

    @Test
    fun testGet() {
        val uShort = UShortProvider().get()
        assertTrue(uShort in UShort.MIN_VALUE until UShort.MAX_VALUE)
    }

    @Test
    fun testGetWithCustomMaxMin() {
        val min = 5u
        val max = 10u
        val uShort = UShortProvider(min = min, max = max).get()
        assertTrue(uShort in min until max)
    }

    @Test
    fun testGetProviderCalled() {
        every { provider.get() } returns 15u

        val uShort = UShortProvider(provider = provider).get()
        assertEquals(15u.toUShort(), uShort)

        verify { provider.get() }
    }
}
