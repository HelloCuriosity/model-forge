package io.github.hellocuriosity.providers

import kotlin.test.Test
import kotlin.test.assertTrue

class ShortProviderTest {

    @Test
    fun testGet() {
        val short = ShortProvider().get()
        assertTrue(short in Short.MIN_VALUE until Short.MAX_VALUE)
    }

    @Test
    fun testGetWithCustomMaxMin() {
        val min = 5
        val max = 10
        val short = ShortProvider(min = min, max = max).get()
        assertTrue(short in min until max)
    }
}
