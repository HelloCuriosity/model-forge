package io.github.hellocuriosity.providers

import org.junit.Test
import kotlin.test.assertTrue

class ULongProviderTest {
    @Test
    fun testGet() {
        val uLong = ULongProvider().get()
        assertTrue(uLong in ULong.MIN_VALUE until ULong.MAX_VALUE)
    }

    @Test
    fun testGetWithCustomMaxMin() {
        val min: ULong = 5u
        val max: ULong = 10u
        val uLong = ULongProvider(min = min, max = max).get()
        assertTrue(uLong in min until max)
    }
}
