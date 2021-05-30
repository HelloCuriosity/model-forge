package io.github.hellocuriosity

import io.github.hellocuriosity.providers.BooleanProvider
import io.github.hellocuriosity.providers.CalendarProvider
import io.github.hellocuriosity.providers.DateProvider
import io.github.hellocuriosity.providers.DoubleProvider
import io.github.hellocuriosity.providers.FloatProvider
import io.github.hellocuriosity.providers.InstantProvider
import io.github.hellocuriosity.providers.IntegerProvider
import io.github.hellocuriosity.providers.LongProvider
import io.github.hellocuriosity.providers.Provider
import io.github.hellocuriosity.providers.StringProvider
import io.github.hellocuriosity.providers.getEnum
import org.objenesis.Objenesis
import org.objenesis.ObjenesisStd
import org.objenesis.instantiator.ObjectInstantiator
import java.lang.reflect.Field
import java.lang.reflect.Modifier
import java.lang.reflect.ParameterizedType
import java.time.Instant
import java.util.Calendar
import java.util.Date

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
    open fun <T> build(clazz: Class<T>): T {
        val objenesis: Objenesis = ObjenesisStd()
        val instantiator: ObjectInstantiator<*> = objenesis.getInstantiatorOf(clazz)
        val model: T = instantiator.newInstance() as T

        if (providers.isNotEmpty()) {
            providers[clazz]?.let { return it.get() as T }
        }

        clazz.eligibleFields().map { field ->
            field.isAccessible = true
            when (field.type) {
                List::class.java -> field.set(model, field.getValues())
                else -> field.set(model, field.type.generate())
            }
        }

        return model
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
    open fun <T> buildList(clazz: Class<T>, size: Int = 10): List<T> {
        val list = mutableListOf<T>()
        for (i in 0 until size) {
            list.add(i, build(clazz))
        }
        return list
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
            .filter { field -> !Modifier.isTransient(field.modifiers) }
            .toTypedArray()

    /**
     * Auto generate values for specific providers
     *
     * @param <T> Type to instantiate
     * @param clazz Class (type) to auto generate
     *
     * @return Any autogenerated values
     */
    private fun <T> Class<T>.generate(): Any = when (this) {
        Boolean::class.java -> BooleanProvider().get()
        Calendar::class.java -> CalendarProvider().get()
        Date::class.java -> DateProvider().get()
        Double::class.java -> DoubleProvider().get()
        Float::class.java -> FloatProvider().get()
        Int::class.java -> IntegerProvider().get()
        Instant::class.java -> InstantProvider().get()
        Long::class.java -> LongProvider().get()
        String::class.java -> StringProvider().get()
        else -> if (isEnum) getEnum() else getValue() as Any
    }

    /**
     * Auto generate values for complex data types
     *
     * @param <T> Type to instantiate
     * @param clazz Class (type) to auto generate
     *
     * @return Any autogenerated values
     */
    private fun <T> Class<T>.getValue(): T =
        attempt { build(this) }

    /**
     * Auto generate list values
     *
     * @param Field Field needed to determine list type
     * @param size Int number of items to create (defaulting to 10)
     *
     * @return Autogenerated list values
     */
    private fun Field.getValues(size: Int = 10): Any {
        val type = genericType as ParameterizedType
        val clazz = type.actualTypeArguments.first() as Class<*>

        val list = mutableListOf<Any>()
        for (i in 0 until size) {
            list.add(i, clazz.generate())
        }
        return list
    }
}
