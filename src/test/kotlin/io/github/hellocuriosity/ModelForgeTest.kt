package io.github.hellocuriosity

import org.junit.Test
import java.util.Date
import kotlin.random.Random
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

class ModelForgeTest {

    private val forge = ModelForge()

    @Test
    fun testBuild() {
        val testObject = forge.build(TestObject::class.java)
        testObject.assert()
    }

    @Test
    fun testBuildList_Default() {
        val list = forge.buildList(TestObject::class.java)
        assertEquals(10, list.size)
        list.map { testObject ->
            testObject.assert()
        }
    }

    @Test
    fun testBuildList_WithSize() {
        val size = 3
        val list = forge.buildList(TestObject::class.java, size)
        assertEquals(size, list.size)
        list.map { testObject ->
            testObject.assert()
        }
    }

    @Test(expected = ModelForgeException::class)
    fun testBuild_WithUnsupportedType() {
        data class UnsupportedTestObject(
            private val random: Random
        )

        val testObject = forge.build(UnsupportedTestObject::class.java)
        assertNull(testObject)
    }

    private fun TestObject.assert() {
        assertNotNull(this.booleanValue)
        assertNotNull(this.dateValue)
        assertNotNull(this.doubleValue)
        assertNotNull(this.floatValue)
        assertNotNull(this.intValue)
        assertNotNull(this.longValue)
        assertNotNull(this.stringValue)
        assertTrue(this.stringValue.isNotBlank())
    }
}

data class TestObject(
    val booleanValue: Boolean,
    val dateValue: Date,
    val doubleValue: Double,
    val floatValue: Float,
    val intValue: Int,
    val longValue: Long,
    val stringValue: String
)
