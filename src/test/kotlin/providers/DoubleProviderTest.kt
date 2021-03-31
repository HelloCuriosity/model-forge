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
class DoubleProviderTest {

    @Mock
    private lateinit var random: Random

    @After
    fun teardown() {
        verifyNoMoreInteractions(random)
    }

    @Test
    fun testGet() {
        val double = DoubleProvider().get()
        assertTrue(double >= DoubleProvider.DEFAULT_MIN)
        assertTrue(double <= DoubleProvider.DEFAULT_MAX)
    }

    @Test
    fun testGet_WithCustomMaxMin() {
        val min = 5.0
        val max = 10.0
        val double = DoubleProvider(min = min, max = max).get()
        assertTrue(double >= min)
        assertTrue(double <= max)
    }

    @Test
    fun testGet_RandomCalled() {
        val randomDouble = 15.0
        whenever(random.nextDouble(any(), any())) doReturn randomDouble

        val min = 5.0
        val max = 10.0
        val double = DoubleProvider(
            min = min,
            max = max,
            random = random
        ).get()

        assertEquals(randomDouble, double)

        verify(random).nextDouble(eq(min), eq(max))
    }
}
