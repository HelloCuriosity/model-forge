package providers

import com.thedeanda.lorem.LoremIpsum

class StringProvider(
    private val lorem: LoremIpsum = LoremIpsum.getInstance()
) : Provider<String> {

    companion object {
        const val DEFAULT_VALUE = 1
    }

    override fun get(wordCount: Int = DEFAULT_VALUE): String {
        if (wordCount <= 0) {
            println("$wordCount is not a valid input, reverting to default $DEFAULT_VALUE")
            return lorem.getWords(wordCount)
        }
        return lorem.getWords(wordCount)
    }

    override fun get(value: Any?): String {

    }
}
