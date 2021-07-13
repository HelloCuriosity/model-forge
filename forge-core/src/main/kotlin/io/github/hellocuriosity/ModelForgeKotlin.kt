package io.github.hellocuriosity

import io.github.hellocuriosity.providers.Provider
import kotlin.reflect.KClass

/**
 * Creates an automatically generated model object
 *
 *  @param <T> Type to instantiate
 *  @param clazz Class to instantiate
 *
 *  @return Instance of clazz
 */
public fun <T : Any> ModelForge.build(clazz: KClass<T>): T =
    build(clazz.java)

/**
 *  Creates an automatically generated model list with
 *  or without a specified size.
 *
 *  @param <T> Type to instantiate
 *  @param clazz Class to instantiate
 *  @param size Int number of models to create (defaulting to 10)
 *
 *  @return Instance of clazz
 */
public fun <T : Any> ModelForge.buildList(clazz: KClass<T>, size: Int = 10): List<T> =
    buildList(clazz.java, size)

/**
 * Adds a custom provider for generating models
 *
 *  @param <T> Type to instantiate
 *  @param clazz Class to instantiate
 *  @param provider Provider for populating data
 *
 */
public fun <T : Any> ModelForge.addProvider(clazz: KClass<T>, provider: Provider<T>) =
    addProvider(clazz.java, provider)

public inline fun <reified T : Any> ModelForge.build(): T = build(T::class)

public inline fun <reified T : Any> ModelForge.build(size: Int = 10): List<T> = buildList(T::class, size)
