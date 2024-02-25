package io.github.hellocuriosity.providers

import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.After
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class UByteProviderTest {
    private val provider: UIntProvider = mockk()

    @After
    fun teardown() {
        confirmVerified(provider)
    }

    @Test
    fun testGet() {
        val uByte = UByteProvider().get()
        assertTrue(uByte in UByte.MIN_VALUE until UByte.MAX_VALUE)
    }

    @Test
    fun testGetWithCustomMaxMin() {
        val min = 5u
        val max = 10u
        val uByte = UByteProvider(min = min, max = max).get()
        assertTrue(uByte in min until max)
    }

    @Test
    fun testGetProviderCalled() {
        every { provider.get() } returns 15u

        val uByte = UByteProvider(provider = provider).get()
        assertEquals(15u.toUByte(), uByte)

        verify { provider.get() }
    }
}
