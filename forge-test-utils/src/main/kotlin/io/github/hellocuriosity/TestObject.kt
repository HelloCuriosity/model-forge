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
    val uIntValue: UInt,
    val uIntOptional: UInt?,
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
    assertBoolean(booleanValue)
    assertNotNull(booleanOptional)
    assertBoolean(booleanOptional)
    assertNotNull(byteValue)
    assertByte(byteValue)
    assertNotNull(byteOptional)
    assertByte(byteOptional)
    assertNotNull(calendarValue)
    assertCalendar(calendarValue)
    assertNotNull(calendarOptional)
    assertCalendar(calendarOptional)
    assertNotNull(charValue)
    assertChar(charValue)
    assertNotNull(charOptional)
    assertChar(charOptional)
    assertNotNull(complexObject)
    assertNotNull(complexOptional)
    assertNotNull(dateValue)
    assertDate(dateValue)
    assertNotNull(dateOptional)
    assertDate(dateOptional)
    assertNotNull(doubleValue)
    assertDouble(doubleValue)
    assertNotNull(doubleOptional)
    assertDouble(doubleOptional)
    assertNotNull(enumValue)
    assertNotNull(enumOptional)
    assertNotNull(enumWithValue)
    assertNotNull(enumWithValueOptional)
    assertNotNull(file)
    assertFile(file)
    assertNotNull(fileOptional)
    assertFile(fileOptional)
    assertNotNull(floatValue)
    assertFloat(floatValue)
    assertNotNull(floatOptional)
    assertFloat(floatOptional)
    assertNotNull(intValue)
    assertInt(intValue)
    assertNotNull(intValueOptional)
    assertInt(intValueOptional)
    assertNotNull(instantValue)
    assertInstant(instantValue)
    assertNotNull(instantOptional)
    assertInstant(instantOptional)
    assertNotNull(longValue)
    assertLong(longValue)
    assertNotNull(longOptional)
    assertLong(longOptional)
    assertNotNull(listValues)
    assertEquals(10, listValues.size)
    assertNotNull(listOptional)
    assertEquals(10, listOptional.size)
    assertNotNull(mapValues)
    assertTrue(mapValues.size in 0 until 11)
    assertNotNull(mapOptional)
    assertTrue(mapOptional.size in 0 until 11)
    assertNotNull(setValues)
    assertEquals(10, setValues.size)
    assertNotNull(setOptional)
    assertEquals(10, setOptional.size)
    assertNotNull(shortValue)
    assertShort(shortValue)
    assertNotNull(shortOptional)
    assertShort(shortOptional)
    assertNotNull(stringValue)
    assertString(stringValue)
    assertTrue(stringValue.isNotBlank())
    assertNotNull(stringOptional)
    assertTrue(stringOptional.isNotBlank())
    assertString(stringOptional)
    assertInt(uIntValue)
    assertNotNull(uIntOptional)
    assertInt(uIntOptional)
    assertNotNull(uuidValue)
    assertUUID(uuidValue)
    assertNotNull(uuidOptional)
    assertUUID(uuidOptional)

    // Validate populated values for ComplexObject
    assertNotNull(complexObject.booleanValue)
    assertBoolean(complexObject.booleanValue)
    assertNotNull(complexObject.calendarValue)
    assertCalendar(complexObject.calendarValue)
    assertNotNull(complexObject.dateValue)
    assertDate(complexObject.dateValue)
    assertNotNull(complexObject.doubleValue)
    assertDouble(complexObject.doubleValue)
    assertNotNull(complexObject.enumValue)
    assertNotNull(complexObject.floatValue)
    assertFloat(complexObject.floatValue)
    assertNotNull(complexObject.intValue)
    assertInt(complexObject.intValue)
    assertNotNull(complexObject.instantValue)
    assertInstant(complexObject.instantValue)
    assertNotNull(complexObject.longValue)
    assertLong(complexObject.longValue)
    assertNotNull(complexObject.stringValue)
    assertString(complexObject.stringValue)
    assertTrue(complexObject.stringValue.isNotBlank())
}
