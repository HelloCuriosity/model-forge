import org.junit.Test
import kotlin.test.assertEquals

class ModelForgeExceptionTest {

    @Test
    fun testException() {
        val message = "test message"
        val exception = ModelForgeException(message)

        assertEquals(message, exception.message)
    }
}
