package io.github.hellocuriosity

@Suppress("SwallowedException")
fun <T> attempt(block: () -> T) =
    try {
        block()
    } catch (e: InstantiationError) {
        // Throw model forge exception instead
        throw ModelForgeException("${e.message} is not yet supported")
    }
