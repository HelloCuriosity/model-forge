package io.github.hellocuriosity.providers

/**
 * Auto generates a UByte between two values
 *
 * @param min minimum value
 * @param max maximum value
 * @param provider UIntProvider
 *
 * @return UByte instance
 */
class UByteProvider(
    private val min: UInt = UByte.MIN_VALUE.toUInt(),
    private val max: UInt = UByte.MAX_VALUE.toUInt(),
    private val provider: UIntProvider =
        UIntProvider(min, max),
) : Provider<UByte> {
    override fun get(): UByte = provider.get().toUByte()
}
