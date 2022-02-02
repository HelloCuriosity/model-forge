package io.github.hellocuriosity

@Suppress("SwallowedException", "TooGenericExceptionCaught", "PrintStackTrace")
fun <T> Any.attempt(block: () -> T) = try {
    block()
} catch (e: InstantiationError) {
    // Throw model forge exception instead
    throw ModelForgeException("$this is not yet supported", e)
} catch (e: Throwable) {
    e.printStackTrace()
    throw e
}
