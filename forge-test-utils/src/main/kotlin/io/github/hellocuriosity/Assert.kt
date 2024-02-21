package io.github.hellocuriosity

import java.io.File
import java.time.Instant
import java.util.Calendar
import java.util.Date
import java.util.UUID
import kotlin.test.assertTrue

fun <T : Any> assertBoolean(value: T) =
    assertType(Boolean::class.java, value::class.java)

fun <T : Any> assertByte(value: T) =
    assertType(Byte::class.java, value::class.java)

fun <T : Any> assertCalendar(value: T) =
    assertType(Calendar::class.java, value::class.java)

fun <T : Any> assertChar(value: T) =
    assertType(Char::class.java, value::class.java)

fun <T : Any> assertDate(value: T) =
    assertType(Date::class.java, value::class.java)

fun <T : Any> assertDouble(value: T) =
    assertType(Double::class.java, value::class.java)

fun <T : Any> assertFile(value: T) =
    assertType(File::class.java, value::class.java)

fun <T : Any> assertFloat(value: T) =
    assertType(Float::class.java, value::class.java)

fun <T : Any> assertInt(value: T) =
    assertType(Int::class.java, value::class.java)

fun <T : Any> assertInstant(value: T) =
    assertType(Instant::class.java, value::class.java)

fun <T : Any> assertLong(value: T) =
    assertType(Long::class.java, value::class.java)

fun <T : Any> assertShort(value: T) =
    assertType(Short::class.java, value::class.java)

fun <T : Any> assertString(value: T) =
    assertType(String::class.java, value::class.java)

fun <T : Any> assertUByte(value: T) =
    assertType(UByte::class.java, value::class.java)

fun <T : Any> assertUInt(value: T) =
    assertType(UInt::class.java, value::class.java)

fun <T : Any> assertULong(value: T) =
    assertType(ULong::class.java, value::class.java)

fun <T : Any> assertUUID(value: T) =
    assertType(UUID::class.java, value::class.java)

private fun <T : Class<*>> assertType(expectedType: Class<*>, value: T) =
    assertTrue(message = "Expected ${expectedType.simpleName} but was ${value::class.simpleName}") {
        value::class.java == expectedType::class.java
    }
