package io.github.hellocuriosity

@Suppress("SwallowedException")
fun <T> Class<T>.attempt(block: () -> T) = try {
    block()
} catch (e: InstantiationError) {
    // Throw model forge exception instead
    throw ModelForgeException("$this is not yet supported")
}
