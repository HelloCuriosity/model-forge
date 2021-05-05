package io.github.hellocuriosity

public inline fun <reified T : Any> forgery(forger: ModelForge = ModelForge()): Lazy<T> = lazy {
    forger.build(T::class)
}

public inline fun <reified T : Any> forgeries(forger: ModelForge = ModelForge(), size: Int = 10): Lazy<List<T>> = lazy {
    forger.buildList(T::class, size)
}
