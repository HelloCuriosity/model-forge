package io.github.hellocuriosity.providers

import javax.inject.Provider as JavaxProvider

/**
 * Legacy support for the removed Provider interface
 */
typealias Provider<T> = JavaxProvider<T>
