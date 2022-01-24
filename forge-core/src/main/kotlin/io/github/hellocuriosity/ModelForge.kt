package io.github.hellocuriosity

import io.github.hellocuriosity.providers.BooleanProvider
import io.github.hellocuriosity.providers.ByteProvider
import io.github.hellocuriosity.providers.CalendarProvider
import io.github.hellocuriosity.providers.CharProvider
import io.github.hellocuriosity.providers.DateProvider
import io.github.hellocuriosity.providers.DoubleProvider
import io.github.hellocuriosity.providers.FileProvider
import io.github.hellocuriosity.providers.FloatProvider
import io.github.hellocuriosity.providers.InstantProvider
import io.github.hellocuriosity.providers.IntegerProvider
import io.github.hellocuriosity.providers.LongProvider
import io.github.hellocuriosity.providers.Provider
import io.github.hellocuriosity.providers.ShortProvider
import io.github.hellocuriosity.providers.StringProvider
import io.github.hellocuriosity.providers.UuidProvider
import io.github.hellocuriosity.providers.getEnum
import org.objenesis.Objenesis
import org.objenesis.ObjenesisStd
import org.objenesis.instantiator.ObjectInstantiator
import java.io.File
import java.lang.reflect.Field
import java.lang.reflect.Modifier
import java.lang.reflect.ParameterizedType
import java.time.Instant
import java.util.Calendar
import java.util.Date
import java.util.UUID

open class ModelForge {

    val providers: HashMap<Class<*>, Provider<*>> = HashMap()

    /**
     * Creates an automatically generated model object
     *
     *  @param <T> Type to instantiate
     *  @param clazz Class to instantiate
     *
     *  @return Instance of clazz
     */
    open fun <T : Any> build(clazz: Class<T>): T =
        realBuild(clazz) ?: throw ModelForgeException("Could not create a forgery for: ${clazz.name}")

    private fun <T : Any> realBuild(clazz: Class<T>): T? {
        if (providers.isNotEmpty() && clazz != List::class.java) {
            providers[clazz]?.let { return it.get() as T }
        }

        return clazz.generate {
            if (clazz.classLoader == null) {
                return@generate null
            }
            attempt {
                val objenesis: Objenesis = ObjenesisStd()
                val instantiator: ObjectInstantiator<T> = objenesis.getInstantiatorOf(clazz)
                instantiator.newInstance() as T
            }.also { model ->
                clazz.eligibleFields().map { field ->
                    field.isAccessible = true
                    when (field.type) {
                        List::class.java -> field.set(model, field.getValues())
                        Map::class.java -> field.set(model, field.getValues())
                        Set::class.java -> field.set(model, field.getValues())
                        else -> realBuild(field.type)?.also {
                            field.set(model, it)
                        }
                    }
                }
            }
        }
    }

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
    open fun <T : Any> buildList(clazz: Class<T>, size: Int = 10): List<T> {
        val list = mutableListOf<T>()
        for (i in 0 until size) {
            list.add(i, build(clazz))
        }
        return list
    }

    /**
     *  Creates an automatically generated model map with
     *  a specified size.
     *
     *  @param type ParameterizedType to instantiate
     *  @param size Int number of models to create
     *
     *  @return Instance of clazz
     */
    private fun buildMap(type: ParameterizedType, size: Int): Map<Any, Any> {
        val key = type.actualTypeArguments[0] as Class<*>
        val value = type.actualTypeArguments[1] as Class<*>

        val map = mutableMapOf<Any, Any>()
        while (map.size < size) {
            map[build(key)] = build(value)
        }
        return map
    }

    /**
     *  Creates an automatically generated model set with
     *  or without a specified size.
     *
     *  @param <T> Type to instantiate
     *  @param clazz Class to instantiate
     *  @param size Int number of models to create (defaulting to 10)
     *
     *  @return Instance of clazz
     */
    open fun <T : Any> buildSet(clazz: Class<T>, size: Int = 10): Set<T> {
        val set = mutableSetOf<T>()
        for (i in 0 until size) {
            set.add(build(clazz))
        }
        return set
    }

    /**
     * Adds a custom provider for generating models
     *
     *  @param <T> Type to instantiate
     *  @param clazz Class to instantiate
     *  @param provider Provider for populating data
     *
     */
    open fun <T> addProvider(clazz: Class<T>, provider: Provider<T>) {
        providers[clazz] = provider
    }

    /**
     * Get all eligible fields for model generation
     *
     * @param <T> Type to instantiate
     * @param clazz Class (declaredFields) to filter
     *
     * @return Array of eligible fields
     */
    private fun <T> Class<T>.eligibleFields(): Array<Field> =
        this.declaredFields
            .filter { field -> !Modifier.isTransient(field.modifiers) && !Modifier.isStatic(field.modifiers) }
            .toTypedArray()

    /**
     * Auto generate values for specific providers
     *
     * @param <T> Type to instantiate
     * @param clazz Class (type) to auto generate
     *
     * @return Any autogenerated values
     */
    @Suppress("ComplexMethod")
    private fun <T : Any> Class<T>.generate(orDefault: () -> T?): T? = when (this) {
        Boolean::class.java, java.lang.Boolean::class.java -> BooleanProvider().get() as T
        Byte::class.java, java.lang.Byte::class.java -> ByteProvider().get() as T
        Calendar::class.java -> CalendarProvider().get() as T
        Char::class.java, java.lang.Character::class.java -> CharProvider().get() as T
        Date::class.java -> DateProvider().get() as T
        Double::class.java, java.lang.Double::class.java -> DoubleProvider().get() as T
        File::class.java -> FileProvider().get() as T
        Float::class.java, java.lang.Float::class.java -> FloatProvider().get() as T
        Int::class.java, java.lang.Integer::class.java -> IntegerProvider().get() as T
        Instant::class.java -> InstantProvider().get() as T
        Long::class.java, java.lang.Long::class.java -> LongProvider().get() as T
        Short::class.java, java.lang.Short::class.java -> ShortProvider().get() as T
        String::class.java, java.lang.String::class.java -> StringProvider().get() as T
        UUID::class.java -> UuidProvider().get() as T
        else -> if (isEnum) getEnum() as T else orDefault()
    }

    /**
     * Auto generate values
     *
     * @param Field Field needed to determine list type
     * @param size Int number of items to create (defaulting to 10)
     *
     * @return Autogenerated values
     */
    private fun Field.getValues(size: Int = 10): Any {
        val type = genericType as ParameterizedType
        val clazz = type.actualTypeArguments.first() as Class<*>

        return when (this.type) {
            List::class.java -> buildList(clazz, size)
            Map::class.java -> buildMap(type, size)
            Set::class.java -> buildSet(clazz, size)
            else -> throw ModelForgeException("Could not create values for: ${clazz.name}")
        }
    }
}
