import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class ModelForgeTest {

    private val forge = ModelForge()

    @Test
    fun testBuild() {
        val testObject = forge.build(TestObject::class.java)
        assertNotNull(testObject.intValue)
        assertNotNull(testObject.stringValue)
        assertTrue { testObject.stringValue.isNotBlank() }
    }

    @Test
    fun testBuildList_Default() {
        val list = forge.buildList(TestObject::class.java)
        assertEquals(10, list.size)
        list.map { testObject ->
            assertNotNull(testObject.intValue)
            assertNotNull(testObject.stringValue)
            assertTrue { testObject.stringValue.isNotBlank() }
        }
    }

    @Test
    fun testBuildList_WithSize() {
        val size = 3
        val list = forge.buildList(TestObject::class.java, size)
        assertEquals(size, list.size)
        list.map { testObject ->
            assertNotNull(testObject.intValue)
            assertNotNull(testObject.stringValue)
            assertTrue { testObject.stringValue.isNotBlank() }
        }
    }
}

data class TestObject(
    val intValue: Int,
    val stringValue: String
)
