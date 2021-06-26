package io.github.hellocuriosity.providers

import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.verify
import org.mockito.kotlin.verifyNoMoreInteractions
import org.mockito.kotlin.whenever
import kotlin.test.assertEquals

@RunWith(MockitoJUnitRunner::class)
class FileProviderTest {
    @Mock
    private lateinit var stringProvider: StringProvider

    @After
    fun tearDown() {
        verifyNoMoreInteractions(stringProvider)
    }

    @Test
    fun testGet() {
        val filename = "filename"
        whenever(stringProvider.get()) doReturn filename

        val file = FileProvider(stringProvider).get()
        assertEquals(filename, file.name)

        verify(stringProvider).get()
    }
}
