package providers

interface Provider<T> {
    fun get(value: Any?): T
}
