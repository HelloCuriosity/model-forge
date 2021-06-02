package io.github.hellocuriosity.providers

import java.io.File

class FileProvider(
    private val stringProvider: StringProvider = StringProvider()
) : Provider<File> {
    override fun get(): File =
        File(stringProvider.get())
}
