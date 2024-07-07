package io.github.hellocuriosity

import org.junit.Test
import java.time.Instant
import kotlin.random.Random
import kotlin.test.assertEquals
import kotlin.test.assertNull

class ForgeryTest {
    @Test
    fun testForgery() {
        val testObject: TestObject by forgery()
        testObject.assert()
    }

    @Test
    fun testEnumForgery() {
        val testEnum by forgery<TestEnumWithValue>()

        val rawValue = testEnum.value
        assertEquals(testEnum, TestEnumWithValue::value.safeFindEnumCase(rawValue))
    }

    @Test
    fun testForgeryListDefault() {
        val list: List<TestObject> by forgeryList()
        assertEquals(10, list.size)
        list.map { testObject ->
            testObject.assert()
        }
    }

    @Test
    fun testForgeryListWithSize() {
        val size = 3
        val list: List<TestObject> by forgeryList(size = size)
        assertEquals(size, list.size)
        list.map { testObject ->
            testObject.assert()
        }
    }

    @Test
    fun testForgerySetDefault() {
        val set: Set<TestObject> by forgerySet()
        assertEquals(10, set.size)
        set.map { testObject ->
            testObject.assert()
        }
    }

    @Test
    fun testForgerySetWithSize() {
        val size = 3
        val set: Set<TestObject> by forgerySet(size = size)
        assertEquals(size, set.size)
        set.map { testObject ->
            testObject.assert()
        }
    }

    @Test(expected = ModelForgeException::class)
    fun testForgeryWithUnsupportedType() {
        data class UnsupportedTestObject(
            private val random: Random,
        )

        val testObject: UnsupportedTestObject by forgery()
        assertNull(testObject)
    }

    @Test
    fun testForgeryWithProvider() {
        data class FancyObject(
            val retrieveMe: String = "wrong it",
        )

        class FancyHolder(
            val value: FancyObject,
        )

        val forger =
            ModelForge().apply {
                addProvider {
                    FancyObject("got it")
                }
            }

        val fancyHolder by forgery<FancyHolder>(forger)
        assertEquals("got it", fancyHolder.value.retrieveMe)
    }

    @Test
    fun testReadmeExample() {
        data class Employee(
            val id: Long,
            val name: String,
            val dob: Instant,
        )

        val forge =
            ModelForge().apply {
                addProvider {
                    Employee(
                        id = 2L,
                        name = "Hendrik",
                        dob = Instant.ofEpochMilli(1574486400000),
                    )
                }
            }
        val employee by forgery<Employee>(forge)
        assertEquals("Hendrik", employee.name)
    }
}

/**
 * Find the enum case or null when not found.
 * The receiver is the predicate. This allows for `Enum::value.safeFindEnumCase("value")` on an Enum(val value: String)
 */
private inline fun <reified T : Enum<T>, V> ((T) -> V).safeFindEnumCase(value: V): T? =
    enumValues<T>().firstOrNull {
        this(it) == value
    }
