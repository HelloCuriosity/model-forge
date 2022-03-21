package io.github.hellocuriosity.providers

/**
 * Auto generates a Char
 *
 * @param chars list of possible characters
 *
 * @return Char instance
 */
class CharProvider(
    private val chars: List<Char> = DEFAULT_CHAR_LIST,
) : Provider<Char> {

    companion object {
        val DEFAULT_CHAR_LIST = ('a'..'z') + ('A'..'Z') + ('0'..'9')
    }

    override fun get(): Char =
        chars.random()
}
