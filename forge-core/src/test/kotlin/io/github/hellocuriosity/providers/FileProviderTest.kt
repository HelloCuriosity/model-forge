package io.github.hellocuriosity.providers

import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.After
import org.junit.Test
import kotlin.test.assertEquals

class FileProviderTest {
    private val stringProvider: StringProvider = mockk()

    @After
    fun tearDown() {
        confirmVerified(stringProvider)
    }

    @Test
    fun testGet() {
        val filename = "filename"
        every { stringProvider.get() } returns filename

        val file = FileProvider(stringProvider).get()
        assertEquals(filename, file.name)

        verify { stringProvider.get() }
    }
}
