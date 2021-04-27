package io.github.hellocuriosity.providers

interface Provider<T> {
    fun get(): T
}
