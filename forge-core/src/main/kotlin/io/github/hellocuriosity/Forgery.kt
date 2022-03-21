package io.github.hellocuriosity

import javax.inject.Provider

public inline fun <reified T : Any> forgery(forger: ModelForge = ModelForge()): Lazy<T> = lazy {
    forger.build(T::class)
}

@Deprecated(
    "forgeries is not used and will be removed in the future.",
    ReplaceWith("forgeryList(forger: ModelForge = ModelForge(), size: Int = 10)")
)
public inline fun <reified T : Any> forgeries(forger: ModelForge = ModelForge(), size: Int = 10): Lazy<List<T>> = lazy {
    forger.buildList(T::class, size)
}

public inline fun <reified T : Any> forgeryList(forger: ModelForge = ModelForge(), size: Int = 10): Lazy<List<T>> =
    lazy { forger.buildList(T::class, size) }

public inline fun <reified T : Any> forgerySet(forger: ModelForge = ModelForge(), size: Int = 10): Lazy<Set<T>> =
    lazy { forger.buildSet(T::class, size) }

public inline fun <reified T : Any> ModelForge.addProvider(provider: Provider<T>) {
    addProvider(T::class.java, provider)
}
