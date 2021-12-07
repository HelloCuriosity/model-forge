package io.github.hellocuriosity.providers

import kotlin.test.Test
import kotlin.test.assertTrue

class ShortProviderTest {

    @Test
    fun testGet() {
        val short = ShortProvider().get()
        assertTrue(short in ShortProvider.DEFAULT_MIN until ShortProvider.DEFAULT_MAX)
    }

    @Test
    fun testGet_WithCustomMaxMin() {
        val min = 5
        val max = 10
        val short = ShortProvider(min = min, max = max).get()
        assertTrue(short in min until max)
    }
}
