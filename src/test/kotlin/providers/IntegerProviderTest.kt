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
class IntegerProviderTest {

    @Mock
    private lateinit var random: Random

    @After
    fun teardown() {
        verifyNoMoreInteractions(random)
    }

    @Test
    fun testGet() {
        val integer = IntegerProvider().get()
        assertTrue(integer in IntegerProvider.DEFAULT_MIN until IntegerProvider.DEFAULT_MAX)
    }

    @Test
    fun testGet_WithCustomMaxMin() {
        val min = 5
        val max = 10
        val integer = IntegerProvider(min = min, max = max).get()
        assertTrue(integer in min until max)
    }

    @Test
    fun testGet_RandomCalled() {
        val randomInt = 15
        whenever(random.nextInt(any(), any())) doReturn randomInt

        val min = 5
        val max = 10
        val integer = IntegerProvider(
            min = min,
            max = max,
            random = random
        ).get()

        assertEquals(randomInt, integer)

        verify(random).nextInt(eq(min), eq(max))
    }
}
