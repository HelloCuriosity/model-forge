package io.github.hellocuriosity.providers

import com.thedeanda.lorem.LoremIpsum

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
        if (wordCount <= 0) {
            println("$wordCount is not a valid input, reverting to default $DEFAULT_VALUE")
            return lorem.getWords(wordCount)
        }
        return lorem.getWords(wordCount)
    }
}
