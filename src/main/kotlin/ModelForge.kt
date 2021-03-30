import org.objenesis.Objenesis
import org.objenesis.ObjenesisStd
import org.objenesis.instantiator.ObjectInstantiator
import providers.IntegerProvider
import providers.StringProvider
import java.lang.reflect.Field
import java.lang.reflect.Modifier

class ModelForge {

    /**
     * Creates an automatically generated model object
     *
     *  @param <T> Type to instantiate
     *  @param clazz Class to instantiate
     *
     *  @return Instance of clazz
     */
    fun <T> build(clazz: Class<T>): T {
        val objenesis: Objenesis = ObjenesisStd()
        val instantiator: ObjectInstantiator<*> = objenesis.getInstantiatorOf(clazz)
        val model: T = instantiator.newInstance() as T

        clazz.eligibleFields().map { field ->
            field.isAccessible = true
            field.set(model, field.type.generate())
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
    fun <T> buildList(clazz: Class<T>, size: Int = 10): List<T> {
        val list = mutableListOf<T>()
        for (i in 0 until size) {
            list.add(i, build(clazz))
        }
        return list
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
    private fun <T> Class<T>.generate(): Any {
        return when (this) {
            Int::class.java -> IntegerProvider().get()
            String::class.java -> StringProvider().get()
            else -> throw ModelForgeException("$this is not yet supported")
        }
    }
}
