package providers

import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.verify
import org.mockito.kotlin.verifyNoMoreInteractions
import org.mockito.kotlin.whenever
import kotlin.random.Random
import kotlin.test.assertTrue

@RunWith(MockitoJUnitRunner::class)
class BooleanProviderTest {

    @Mock
    private lateinit var random: Random

    @After
    fun teardown() {
        verifyNoMoreInteractions(random)
    }

    @Test
    fun testGet() {
        whenever(random.nextBoolean()) doReturn true

        val boolean = BooleanProvider(random = random).get()
        assertTrue(boolean)

        verify(random).nextBoolean()
    }
}
