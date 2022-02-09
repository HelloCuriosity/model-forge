package io.github.hellocuriosity.providers

import javax.inject.Provider

/**
 * Auto generates a Byte between two values
 *
 * @param min minimum value
 * @param max maximum value
 * @param provider IntegerProvider
 *
 * @return Byte instance
 */
class ByteProvider(
    private val min: Int = Byte.MIN_VALUE.toInt(),
    private val max: Int = Byte.MAX_VALUE.toInt(),
    private val provider: IntegerProvider =
        IntegerProvider(min, max)
) : Provider<Byte> {

    override fun get(): Byte =
        provider.get().toByte()
}
