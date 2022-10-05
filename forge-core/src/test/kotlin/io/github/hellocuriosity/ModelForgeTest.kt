package io.github.hellocuriosity

import org.junit.Test
import kotlin.random.Random
import kotlin.test.assertEquals
import kotlin.test.assertNull

class ModelForgeTest {

    private val forge = ModelForge()

    @Test
    fun testBuild() {
        val testObject = forge.build(TestObject::class.java)
        testObject.assert()
    }

    @Test
    fun testBuildWithProvider() {
        forge.addProvider(TestProviderObject::class.java, testProvider)
        val testObject = forge.build(TestProviderObject::class.java)
        testObject.assert()
    }

    @Test(expected = ModelForgeException::class)
    fun testBuildWithUnsupportedType() {
        data class UnsupportedTestObject(
            private val random: Random
        )

        val testObject = forge.build(UnsupportedTestObject::class.java)
        assertNull(testObject)
    }

    @Test
    fun testBuildListDefault() {
        val list = forge.buildList(TestObject::class.java)
        assertEquals(10, list.size)
        list.map { testObject ->
            testObject.assert()
        }
    }

    @Test
    fun testBuildListWithSize() {
        val size = 3
        val list = forge.buildList(TestObject::class.java, size)
        assertEquals(size, list.size)
        list.map { testObject ->
            testObject.assert()
        }
    }

    @Test
    fun testBuildSetDefault() {
        val set = forge.buildSet(TestObject::class.java)
        assertEquals(10, set.size)
        for (testObject in set) {
            testObject.assert()
        }
    }

    @Test
    fun testBuildSetWithSize() {
        val size = 3
        val set = forge.buildSet(TestObject::class.java, size)
        assertEquals(size, set.size)
        for (testObject in set) {
            testObject.assert()
        }
    }
}
