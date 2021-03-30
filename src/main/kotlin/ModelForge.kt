import providers.StringProvider
import java.lang.reflect.Field
import java.lang.reflect.Modifier

class ModelForge {

    fun <T> build(clazz: Class<T>): T {
        val result: T = clazz.getDeclaredConstructor().apply {
            isAccessible = true
        }.newInstance()

        clazz.eligibleFields().map { field ->
            field.isAccessible = true
            field.set(result, field.generate())
        }

        return result
    }

    fun <T> buildList(clazz: Class<T>, size: Int = 10): List<T> {
        val list = mutableListOf<T>()
        for (i in 0 until size) {
            list.add(i, build(clazz))
        }
        return list
    }

    /**
     * Remove all fields that aren't eligible for model generation
     */
    private fun <T> Class<T>.eligibleFields() =
        this.declaredFields
            .filter { field -> !Modifier.isTransient(field.modifiers) }
            .toTypedArray()

    /**
     * Auto generate values for specific providers
     */
    private fun Field.generate(): Any {
        return when (this.type) {
            String::class.java -> StringProvider().get()
            else -> throw ModelForgeException("${this.type} is not yet supported")
        }
    }
}
