---
sidebar_position: 4
---

# Char

The `char` provider generates a random character from a list of chars.

### Default Behavoir

From `('a'..'z') + ('A'..'Z') + ('0'..'9')`

### Extending Calendar Provider

If you need a specific range you can pass custom `timestamps` to the provider:

```kotlin
    val char = CharProvider(chars = listOf('a', 'b')).get()
```
