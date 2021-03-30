package providers

import kotlin.random.Random

class LongProvider(
    private val min: Long = DEFAULT_MIN,
    private val max: Long = DEFAULT_MAX,
    private val random: Random = Random
) : Provider<Long> {

    companion object {
        const val DEFAULT_MIN: Long = 1
        const val DEFAULT_MAX: Long = 100000
    }

    override fun get(): Long =
        random.nextLong(min, max)
}
