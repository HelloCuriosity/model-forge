package io.github.hellocuriosity

import io.github.hellocuriosity.providers.Provider
import kotlin.test.assertEquals
import kotlin.test.assertTrue

data class TestProviderObject(
    val booleanValue: Boolean,
    val enumValue: TestEnum,
    val floatValue: Float,
    val intValue: Int,
    val stringValue: String,
)

val testProvider: Provider<TestProviderObject> = Provider {
    TestProviderObject(
        booleanValue = true,
        enumValue = TestEnum.TWO,
        floatValue = 15.0f,
        intValue = 15,
        stringValue = "custom string",
    )
}

fun TestProviderObject.assert() {
    assertTrue(this.booleanValue)
    assertEquals(TestEnum.TWO, this.enumValue)
    assertEquals(15.0f, this.floatValue)
    assertEquals(15, this.intValue)
    assertEquals("custom string", this.stringValue)
}
