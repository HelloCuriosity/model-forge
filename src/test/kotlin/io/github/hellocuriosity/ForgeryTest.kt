package io.github.hellocuriosity

import org.junit.Test
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
}
