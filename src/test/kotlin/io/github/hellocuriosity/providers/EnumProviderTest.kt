package io.github.hellocuriosity.providers

import io.github.hellocuriosity.ModelForgeException
import io.github.hellocuriosity.TestEnum
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Suite
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.eq
import org.mockito.kotlin.verify
import org.mockito.kotlin.verifyNoMoreInteractions
import org.mockito.kotlin.whenever
import kotlin.random.Random
import kotlin.test.assertEquals

@RunWith(Suite::class)
@Suite.SuiteClasses(
    EnumProviderTest.TestEnums::class,
    EnumProviderTest.TestExceptions::class
)
class EnumProviderTest {

    @RunWith(Parameterized::class)
    open class TestEnums(private val expected: TestEnum, private val mock: Int) {

        companion object {
            @JvmStatic
            @Parameterized.Parameters
            fun data() = listOf(
                arrayOf(TestEnum.ONE, 0),
                arrayOf(TestEnum.TWO, 1),
                arrayOf(TestEnum.THREE, 2),
            )
        }

        @Mock
        private lateinit var random: Random

        @Before
        fun setup() {
            MockitoAnnotations.openMocks(this)
        }

        @After
        fun teardown() {
            verifyNoMoreInteractions(random)
        }

        @Test
        fun testGetEnum() {
            whenever(random.nextInt(any())) doReturn mock
            assertEquals(expected, TestEnum::class.java.getEnum(random = random))
            verify(random).nextInt(eq(TestEnum::class.java.enumConstants.size))
        }
    }

    open class TestExceptions {

        private enum class NoValueEnum

        @Test(expected = ModelForgeException::class)
        fun testGetEnumNoValuesDefined() {
            NoValueEnum::class.java.getEnum()
        }
    }
}
