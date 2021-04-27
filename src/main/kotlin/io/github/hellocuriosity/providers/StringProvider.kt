package io.github.hellocuriosity.providers

import com.thedeanda.lorem.LoremIpsum

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
