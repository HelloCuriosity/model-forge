package io.github.hellocuriosity.providers

import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals

class StringProviderTest {

    @Test
    fun testGet() {
        for (i in 1..1000) {
            val words = StringProvider(wordCount = i).get()
            assertEquals(i, words.count())
        }
    }

    @Test
    fun testGet_ZeroOrLess() {
        for (i in -1000..0) {
            val words = StringProvider(wordCount = i).get()
            assertEquals(1, words.count())
        }
    }

    private fun String.count(): Int =
        this.trim().splitToSequence(" ").count()
}
