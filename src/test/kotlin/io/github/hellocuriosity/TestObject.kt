package io.github.hellocuriosity

import java.time.Instant
import java.util.Calendar
import java.util.Date
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

data class TestObject(
    val booleanValue: Boolean,
    val calendarValue: Calendar,
    val dateValue: Date,
    val doubleValue: Double,
    val enumValue: TestEnum,
    val floatValue: Float,
    val intValue: Int,
    val instantValue: Instant,
    val longValue: Long,
    val stringValue: String
)

enum class TestEnum {
    ONE, TWO, THREE
}

fun TestObject.assert() {
    assertNotNull(this.booleanValue)
    assertNotNull(this.calendarValue)
    assertNotNull(this.dateValue)
    assertNotNull(this.doubleValue)
    assertNotNull(this.enumValue)
    assertNotNull(this.floatValue)
    assertNotNull(this.intValue)
    assertNotNull(this.instantValue)
    assertNotNull(this.longValue)
    assertNotNull(this.stringValue)
    assertTrue(this.stringValue.isNotBlank())
}
