package io.github.hellocuriosity.providers

/**
 * Auto generates a UShort between two values
 *
 * @param min minimum value
 * @param max maximum value
 * @param provider UIntProvider
 *
 * @return UShort instance
 */
class UShortProvider(
    private val min: UInt = UShort.MIN_VALUE.toUInt(),
    private val max: UInt = UShort.MAX_VALUE.toUInt(),
    private val provider: UIntProvider = UIntProvider(min, max),
) : Provider<UShort> {
    override fun get(): UShort = provider.get().toUShort()
}
