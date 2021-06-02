package io.github.hellocuriosity

import java.io.File
import java.time.Instant
import java.util.Calendar
import java.util.Date
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

data class TestObject(
    val booleanValue: Boolean,
    val booleanOptional: Boolean?,
    val calendarValue: Calendar,
    val calendarOptional: Calendar?,
    val dateValue: Date,
    val dateOptional: Date?,
    val doubleValue: Double,
    val doubleOptional: Double?,
    val enumValue: TestEnum,
    val enumOptional: TestEnum?,
    val file: File,
    val fileOptional: File?,
    val floatValue: Float,
    val floatOptional: Float?,
    val intValue: Int,
    val intValueOptional: Int?,
    val instantValue: Instant,
    val instantOptional: Instant?,
    val longValue: Long,
    val longOptional: Long?,
    val stringValue: String,
    val stringOptional: String?,
    val listValues: List<ComplexObject>,
    val listOptional: List<ComplexObject>?,
    val complexObject: ComplexObject,
    val complexOptional: ComplexObject?
) {
    companion object {
        const val COMPANION_VALUE = 1234
    }
}

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
    assertNotNull(this.booleanOptional)
    assertNotNull(this.calendarValue)
    assertNotNull(this.calendarOptional)
    assertNotNull(this.dateValue)
    assertNotNull(this.dateOptional)
    assertNotNull(this.doubleValue)
    assertNotNull(this.doubleOptional)
    assertNotNull(this.enumValue)
    assertNotNull(this.enumOptional)
    assertNotNull(this.file)
    assertNotNull(this.fileOptional)
    assertNotNull(this.floatValue)
    assertNotNull(this.floatOptional)
    assertNotNull(this.intValue)
    assertNotNull(this.intValueOptional)
    assertNotNull(this.instantValue)
    assertNotNull(this.instantOptional)
    assertNotNull(this.longValue)
    assertNotNull(this.longOptional)
    assertNotNull(this.listValues)
    assertEquals(10, this.listValues.size)
    assertNotNull(this.listOptional)
    assertEquals(10, this.listOptional.size)
    assertNotNull(this.stringValue)
    assertTrue(this.stringValue.isNotBlank())
    assertNotNull(this.stringOptional)
    assertTrue(this.stringOptional.isNotBlank())
    assertNotNull(this.complexObject)
    assertNotNull(this.complexOptional)

    // Validate populated values for ComplexObject
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
