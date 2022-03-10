package io.github.hellocuriosity.providers

import io.github.hellocuriosity.ModelForgeException
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
    fun testGetZero() {
        val emptyString = StringProvider(wordCount = 0).get()
        assertEquals("", emptyString)
    }

    @Test(expected = ModelForgeException::class)
    fun testGetLessThanZero() {
        StringProvider(wordCount = -1).get()
    }

    private fun String.count(): Int =
        this.trim().splitToSequence(" ").count()
}
