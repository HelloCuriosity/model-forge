package io.github.hellocuriosity.providers

import kotlin.test.Test
import kotlin.test.assertTrue

class ByteProviderTest {

    @Test
    fun testGet() {
        val byte = ByteProvider().get()
        assertTrue(byte in ByteProvider.DEFAULT_MIN until ByteProvider.DEFAULT_MAX)
    }

    @Test
    fun testGet_WithCustomMaxMin() {
        val min = 5
        val max = 10
        val byte = ByteProvider(min = min, max = max).get()
        assertTrue(byte in min until max)
    }
}
