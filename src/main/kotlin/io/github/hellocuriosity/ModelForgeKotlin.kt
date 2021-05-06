package io.github.hellocuriosity

import kotlin.reflect.KClass

/**
 * Creates an automatically generated model object
 *
 *  @param <T> Type to instantiate
 *  @param clazz Class to instantiate
 *
 *  @return Instance of clazz
 */
fun <T : Any> ModelForge.build(clazz: KClass<T>): T =
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
fun <T : Any> ModelForge.buildList(clazz: KClass<T>, size: Int = 10): List<T> =
    buildList(clazz.java, size)
