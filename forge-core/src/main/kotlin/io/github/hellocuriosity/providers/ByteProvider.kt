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
class ByteProvider(
    private val min: Int = DEFAULT_MIN,
    private val max: Int = DEFAULT_MAX,
    private val provider: IntegerProvider =
        IntegerProvider(min, max)
) : Provider<Byte> {

    companion object {
        const val DEFAULT_MIN = 1
        const val DEFAULT_MAX = 127
    }

    override fun get(): Byte =
        provider.get().toByte()
}
