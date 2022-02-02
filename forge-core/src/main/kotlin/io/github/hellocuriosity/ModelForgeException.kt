package io.github.hellocuriosity

import java.lang.RuntimeException

class ModelForgeException(message: String, cause: Throwable? = null) : RuntimeException(message, cause)
