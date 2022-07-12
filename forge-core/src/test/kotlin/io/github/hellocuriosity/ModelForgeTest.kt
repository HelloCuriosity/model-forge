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

    @Test(expected = ModelForgeException::class)
    fun testBuildWithUnsupportedType() {
        data class UnsupportedTestObject(
            private val random: Random
        )

        val testObject = forge.build(UnsupportedTestObject::class.java)
        assertNull(testObject)
    }
}
