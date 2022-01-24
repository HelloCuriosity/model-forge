package io.github.hellocuriosity

import java.io.File
import java.time.Instant
import java.util.Calendar
import java.util.Date
import java.util.UUID
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

data class TestObject(
    val booleanValue: Boolean,
    val booleanOptional: Boolean?,
    val byteValue: Byte,
    val byteOptional: Byte?,
    val calendarValue: Calendar,
    val calendarOptional: Calendar?,
    val charValue: Char,
    val charOptional: Char?,
    val complexObject: ComplexObject,
    val complexOptional: ComplexObject?,
    val dateValue: Date,
    val dateOptional: Date?,
    val doubleValue: Double,
    val doubleOptional: Double?,
    val enumValue: TestEnum,
    val enumOptional: TestEnum?,
    val enumWithValue: TestEnumWithValue,
    val enumWithValueOptional: TestEnumWithValue?,
    val file: File,
    val fileOptional: File?,
    val floatValue: Float,
    val floatOptional: Float?,
    val intValue: Int,
    val intValueOptional: Int?,
    val instantValue: Instant,
    val instantOptional: Instant?,
    val listValues: List<ComplexObject>,
    val listOptional: List<ComplexObject>?,
    val longValue: Long,
    val longOptional: Long?,
    val mapValues: Map<String, ComplexObject>,
    val mapOptional: Map<String, ComplexObject>?,
    val setValues: Set<ComplexObject>,
    val setOptional: Set<ComplexObject>?,
    val shortValue: Short,
    val shortOptional: Short?,
    val stringValue: String,
    val stringOptional: String?,
    val uuidValue: UUID,
    val uuidOptional: UUID?,
)

enum class TestEnum {
    ONE, TWO, THREE
}

enum class TestEnumWithValue(val value: String) {
    FOUR("four"), FIVE("five"), SIX("six");

    companion object {
        /**
         * Unused because we aren't validating this, but still necessary
         * to validate that these objects aren't being generated
         */

        const val COMPANION_VALUE = 1234
        fun list() = listOf(FOUR, FIVE, SIX)
    }
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
    assertNotNull(booleanValue)
    assertNotNull(booleanOptional)
    assertNotNull(byteValue)
    assertNotNull(byteOptional)
    assertNotNull(calendarValue)
    assertNotNull(calendarOptional)
    assertNotNull(charValue)
    assertNotNull(charOptional)
    assertNotNull(complexObject)
    assertNotNull(complexOptional)
    assertNotNull(dateValue)
    assertNotNull(dateOptional)
    assertNotNull(doubleValue)
    assertNotNull(doubleOptional)
    assertNotNull(enumValue)
    assertNotNull(enumOptional)
    assertNotNull(enumWithValue)
    assertNotNull(enumWithValueOptional)
    assertNotNull(file)
    assertNotNull(fileOptional)
    assertNotNull(floatValue)
    assertNotNull(floatOptional)
    assertNotNull(intValue)
    assertNotNull(intValueOptional)
    assertNotNull(instantValue)
    assertNotNull(instantOptional)
    assertNotNull(longValue)
    assertNotNull(longOptional)
    assertNotNull(listValues)
    assertEquals(10, listValues.size)
    assertNotNull(listOptional)
    assertEquals(10, listOptional.size)
    assertNotNull(mapValues)
    assertEquals(10, mapValues.size)
    assertNotNull(mapOptional)
    assertEquals(10, mapOptional.size)
    assertNotNull(setValues)
    assertEquals(10, setValues.size)
    assertNotNull(setOptional)
    assertEquals(10, setOptional.size)
    assertNotNull(shortValue)
    assertNotNull(shortOptional)
    assertNotNull(stringValue)
    assertTrue(stringValue.isNotBlank())
    assertNotNull(stringOptional)
    assertTrue(stringOptional.isNotBlank())
    assertNotNull(uuidValue)
    assertNotNull(uuidOptional)

    // Validate populated values for ComplexObject
    assertNotNull(complexObject.booleanValue)
    assertNotNull(complexObject.calendarValue)
    assertNotNull(complexObject.dateValue)
    assertNotNull(complexObject.doubleValue)
    assertNotNull(complexObject.enumValue)
    assertNotNull(complexObject.floatValue)
    assertNotNull(complexObject.intValue)
    assertNotNull(complexObject.instantValue)
    assertNotNull(complexObject.longValue)
    assertNotNull(complexObject.stringValue)
    assertTrue(complexObject.stringValue.isNotBlank())
}
