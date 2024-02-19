package io.github.hellocuriosity.providers

import java.util.UUID

/**
 * Auto generates an UUID
 *
 * @return UUID instance
 */
class UuidProvider : Provider<UUID> {
    override fun get(): UUID = UUID.randomUUID()
}
