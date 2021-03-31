package providers

import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.eq
import org.mockito.kotlin.verify
import org.mockito.kotlin.verifyNoMoreInteractions
import org.mockito.kotlin.whenever
import kotlin.random.Random
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@RunWith(MockitoJUnitRunner::class)
class LongProviderTest {

    @Mock
    private lateinit var random: Random

    @After
    fun teardown() {
        verifyNoMoreInteractions(random)
    }

    @Test
    fun testGet() {
        val long = LongProvider().get()
        assertTrue(long in LongProvider.DEFAULT_MIN until LongProvider.DEFAULT_MAX)
    }

    @Test
    fun testGet_WithCustomMaxMin() {
        val min = 5L
        val max = 10L
        val long = LongProvider(min = min, max = max).get()
        assertTrue(long in min until max)
    }

    @Test
    fun testGet_RandomCalled() {
        val randomLong = 15L

        whenever(random.nextLong(any(), any())) doReturn randomLong
        val min = 5L
        val max = 10L
        val long = LongProvider(
            min = min,
            max = max,
            random = random
        ).get()

        assertEquals(randomLong, long)

        verify(random).nextLong(eq(min), eq(max))
    }
}
