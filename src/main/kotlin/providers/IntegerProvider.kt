package providers

import kotlin.random.Random

class IntegerProvider(
    private val min: Int = DEFAULT_MIN,
    private val max: Int = DEFAULT_MAX,
    private val random: Random = Random
) : Provider<Int> {
    companion object {
        const val DEFAULT_MIN = 1
        const val DEFAULT_MAX = 100000
    }

    override fun get(): Int =
        random.nextInt(min, max)
}
