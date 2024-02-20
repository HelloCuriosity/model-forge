package io.github.hellocuriosity.providers

import kotlin.test.Test
import kotlin.test.assertTrue

class UByteProviderTest {
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
}
