package io.github.hellocuriosity.providers

import com.thedeanda.lorem.LoremIpsum
import io.github.hellocuriosity.ModelForgeException

/**
 * Auto generates a String
 *
 * @param wordCount amount of words to be generated
 * @param lorem lorem ipsum generator
 *
 * @return String instance
 */
class StringProvider(
    private val wordCount: Int = DEFAULT_VALUE,
    private val lorem: LoremIpsum = LoremIpsum.getInstance()
) : Provider<String> {

    companion object {
        const val DEFAULT_VALUE = 1
    }

    override fun get(): String {
        if (wordCount < 0) {
            throw ModelForgeException("$wordCount is not a valid word count")
        }
        return lorem.getWords(wordCount)
    }
}
