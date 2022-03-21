package io.github.hellocuriosity.providers

import com.thedeanda.lorem.LoremIpsum
import io.github.hellocuriosity.ModelForgeException
import javax.inject.Provider

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
        return when {
            wordCount < 0 -> throw ModelForgeException("Cannot generate string of $wordCount words")
            wordCount == 0 -> ""
            else -> lorem.getWords(wordCount)
        }
    }
}
