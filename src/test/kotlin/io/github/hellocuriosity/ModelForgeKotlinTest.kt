package io.github.hellocuriosity

import org.junit.Test
import kotlin.random.Random
import kotlin.test.assertEquals
import kotlin.test.assertNull

class ModelForgeKotlinTest {

    private val forge = ModelForge()

    @Test
    fun testBuild() {
        val testObject = forge.build(TestObject::class)
        testObject.assert()
    }

    @Test
    fun testReifiedBuild() {
        val testObject: TestObject = forge.build()
        testObject.assert()
    }

    @Test
    fun testBuild_WithProvider() {
        forge.addProvider(TestProviderObject::class, testProvider)
        val testObject = forge.build(TestProviderObject::class)
        testObject.assert()
    }

    @Test
    fun testBuildList_Default() {
        val list = forge.buildList(TestObject::class)
        assertEquals(10, list.size)
        list.map { testObject ->
            testObject.assert()
        }
    }

    @Test
    fun testBuildList_WithSize() {
        val size = 3
        val list = forge.buildList(TestObject::class, size)
        assertEquals(size, list.size)
        list.map { testObject ->
            testObject.assert()
        }
    }

    @Test
    fun testReifiedBuildList_WithSize() {
        val size = 3
        val list = forge.build<TestObject>(size)
        assertEquals(size, list.size)
        list.map { testObject ->
            testObject.assert()
        }
    }

    @Test(expected = ModelForgeException::class)
    fun testBuild_WithUnsupportedType() {
        data class UnsupportedTestObject(
            private val random: Random,
        )

        val testObject = forge.build(UnsupportedTestObject::class)
        assertNull(testObject)
    }
}
