package io.github.hellocuriosity.providers

import org.junit.Test
import kotlin.test.assertTrue

class CharProviderTest {

    @Test
    fun testGet() {
        val char = CharProvider().get()
        assertTrue(CharProvider.DEFAULT_CHAR_LIST.contains(char))
    }
}
