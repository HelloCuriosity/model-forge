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
    private val min: Int = Short.MIN_VALUE.toInt(),
    private val max: Int = Short.MAX_VALUE.toInt(),
    private val provider: IntegerProvider = IntegerProvider(min, max),
) : Provider<Short> {
    override fun get(): Short = provider.get().toShort()
}
