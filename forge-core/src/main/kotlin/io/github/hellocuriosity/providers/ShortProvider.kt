package io.github.hellocuriosity.providers

/**
 * Auto generates a Short between two values
 *
 * @param min minimum value
 * @param max maximum value
 * @param provider IntegerProvider
 *
 * @return Short instance
 */
class ShortProvider(
    private val min: Int = DEFAULT_MIN,
    private val max: Int = DEFAULT_MAX,
    private val provider: IntegerProvider =
        IntegerProvider(min, max)
) : Provider<Short> {

    companion object {
        const val DEFAULT_MIN = 1
        const val DEFAULT_MAX = 32767
    }

    override fun get(): Short =
        provider.get().toShort()
}
