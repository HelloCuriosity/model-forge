package io.github.hellocuriosity.providers

fun interface Provider<T> {
    fun get(): T
}
