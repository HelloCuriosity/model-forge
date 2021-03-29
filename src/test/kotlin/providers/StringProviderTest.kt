package providers

import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals


class StringProviderTest {

    @Test
    fun testGet() {
        val stringProvider = StringProvider()

        for (i in 1..3) {
            println(i)
            .get(wordCount = i)
            val result = string
            assertEquals(i, "")
        }

    }
}
