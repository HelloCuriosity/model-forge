package io.github.hellocuriosity

import io.github.hellocuriosity.providers.Provider

public inline fun <reified T : Any> forgery(forger: ModelForge = ModelForge()): Lazy<T> = lazy {
    forger.build(T::class)
}

public inline fun <reified T : Any> forgeries(forger: ModelForge = ModelForge(), size: Int = 10): Lazy<List<T>> = lazy {
    forger.buildList(T::class, size)
}

public inline fun <reified T : Any> ModelForge.addProvider(provider: Provider<T>) {
    addProvider(T::class.java, provider)
}
