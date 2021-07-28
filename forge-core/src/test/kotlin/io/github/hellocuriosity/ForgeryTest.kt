package io.github.hellocuriosity

import org.junit.Assert.assertTrue
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
        assertTrue(testEnum.value.isNotEmpty())
    }

    @Test
    fun testForgeries_Default() {
        val list: List<TestObject> by forgeries()
        assertEquals(10, list.size)
        list.map { testObject ->
            testObject.assert()
        }
    }

    @Test
    fun testForgeries_WithSize() {
        val size = 3
        val list: List<TestObject> by forgeries(size = size)
        assertEquals(size, list.size)
        list.map { testObject ->
            testObject.assert()
        }
    }

    @Test(expected = ModelForgeException::class)
    fun testForgery_WithUnsupportedType() {
        data class UnsupportedTestObject(
            private val random: Random,
        )

        val testObject: UnsupportedTestObject by forgery()
        assertNull(testObject)
    }

    @Test
    fun testForgery_withProvider() {
        data class FancyObject(val retrieveMe: String = "wrong it")

        class FancyHolder(val value: FancyObject)

        val forger = ModelForge().apply {
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
        val forge = ModelForge().apply {
            addProvider {
                Employee(
                    id = 2L,
                    name = "Hendrik",
                    dob = Instant.ofEpochMilli(1574486400000)
                )
            }
        }
        val employee by forgery<Employee>(forge)
        assertEquals("Hendrik", employee.name)
    }
}
