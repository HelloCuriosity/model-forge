package io.github.hellocuriosity.providers

import java.io.File
import javax.inject.Provider

class FileProvider(
    private val stringProvider: StringProvider = StringProvider()
) : Provider<File> {
    override fun get(): File =
        File(stringProvider.get())
}
