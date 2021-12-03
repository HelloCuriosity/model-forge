package io.github.hellocuriosity.providers

import org.junit.Test
import kotlin.test.assertEquals

class UuidProviderTest {

    @Test
    fun testGet() {
        val uuid = UuidProvider().get().toString()
        val groups = uuid.split("-")

        /**
         * UUIDs are displayed in five groups separated by hyphens,
         * in the form 8-4-4-4-12 for a total of 36 characters
         */
        assertEquals(36, uuid.length)
        assertEquals(5, groups.size)
        assertEquals(8, groups[0].length)
        assertEquals(4, groups[1].length)
        assertEquals(4, groups[2].length)
        assertEquals(4, groups[3].length)
        assertEquals(12, groups[4].length)
    }
}
