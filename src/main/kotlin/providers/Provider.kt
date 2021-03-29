package providers

interface Provider<T> {
    fun get(): T
}
