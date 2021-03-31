package providers

import kotlin.random.Random

class FloatProvider(
    private val min: Double = DEFAULT_MIN,
    private val max: Double = DEFAULT_MAX,
    private val random: Random = Random
) : Provider<Float> {
    companion object {
        const val DEFAULT_MIN = 1.0
        const val DEFAULT_MAX = 100000.0
    }

    override fun get(): Float =
        random.nextDouble(min, max).toFloat()
}
