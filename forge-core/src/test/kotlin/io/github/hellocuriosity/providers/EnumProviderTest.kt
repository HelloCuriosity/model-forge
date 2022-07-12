package io.github.hellocuriosity.providers

import io.github.hellocuriosity.ModelForgeException
import io.github.hellocuriosity.TestEnum
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Suite
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
                arrayOf(TestEnum.THREE, 2)
            )
        }

        private val random: Random = mockk()

        @After
        fun teardown() {
            confirmVerified(random)
        }

        @Test
        fun testGetEnum() {
            every { random.nextInt(any()) } returns mock
            assertEquals(expected, TestEnum::class.java.getEnum(random = random))
            verify { random.nextInt(eq(TestEnum::class.java.enumConstants.size)) }
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
