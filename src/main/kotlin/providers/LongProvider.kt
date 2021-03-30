package providers

import java.util.Random

class LongProvider(
    private val min: Int = DEFAULT_MIN,
    private val max: Int = DEFAULT_MAX,
    private val random: Random = Random()
) : Provider<Long> {

    companion object {
        const val DEFAULT_MIN = 1
        const val DEFAULT_MAX = 100000
    }

    override fun get(): Long =
        (min + random.nextInt(max - min)).toLong()
}
