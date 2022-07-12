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
    fun testBuildWithProvider() {
        forge.addProvider(TestProviderObject::class, testProvider)
        val testObject = forge.build(TestProviderObject::class)
        testObject.assert()
    }

    @Test
    fun testBuildListDefault() {
        val list = forge.buildList(TestObject::class)
        assertEquals(10, list.size)
        list.map { testObject ->
            testObject.assert()
        }
    }

    @Test
    fun testBuildListWithSize() {
        val size = 3
        val list = forge.buildList(TestObject::class, size)
        assertEquals(size, list.size)
        list.map { testObject ->
            testObject.assert()
        }
    }

    @Test
    fun testReifiedBuildListDeprecatedWithSize() {
        val size = 3
        val list = forge.build<TestObject>(size)
        assertEquals(size, list.size)
        list.map { testObject ->
            testObject.assert()
        }
    }

    @Test
    fun testReifiedBuildListWithSize() {
        val size = 3
        val list = forge.buildList<TestObject>(size)
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

        val testObject = forge.build(UnsupportedTestObject::class)
        assertNull(testObject)
    }

    @Test
    fun testBuildSetDefault() {
        val set = forge.buildSet(TestObject::class)
        assertEquals(10, set.size)
        set.map { testObject ->
            testObject.assert()
        }
    }

    @Test
    fun testBuildSetWithSize() {
        val size = 3
        val set = forge.buildSet(TestObject::class, size)
        assertEquals(size, set.size)
        set.map { testObject ->
            testObject.assert()
        }
    }

    @Test
    fun testReifiedBuildSetWithSize() {
        val size = 3
        val set = forge.buildSet<TestObject>(size)
        assertEquals(size, set.size)
        set.map { testObject ->
            testObject.assert()
        }
    }
}
