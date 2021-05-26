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
    val stringValue: String,
    val complexObject: ComplexObject
)

enum class TestEnum {
    ONE, TWO, THREE
}

data class ComplexObject(
    val booleanValue: Boolean,
    val calendarValue: Calendar,
    val dateValue: Date,
    val doubleValue: Double,
    val enumValue: TestEnum,
    val floatValue: Float,
    val intValue: Int,
    val instantValue: Instant,
    val longValue: Long,
    val stringValue: String,
)

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
    assertNotNull(this.complexObject)

    // Validate complex object
    assertNotNull(this.complexObject.booleanValue)
    assertNotNull(this.complexObject.calendarValue)
    assertNotNull(this.complexObject.dateValue)
    assertNotNull(this.complexObject.doubleValue)
    assertNotNull(this.complexObject.enumValue)
    assertNotNull(this.complexObject.floatValue)
    assertNotNull(this.complexObject.intValue)
    assertNotNull(this.complexObject.instantValue)
    assertNotNull(this.complexObject.longValue)
    assertNotNull(this.complexObject.stringValue)
    assertTrue(this.complexObject.stringValue.isNotBlank())
}
