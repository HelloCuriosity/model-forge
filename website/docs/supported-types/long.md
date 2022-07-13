---
sidebar_position: 12
---

# Lont

The `long` provider generates a random long value between two longs.

### Default Behavoir
Between `-9223372036854775807L - 1L` and `9223372036854775807L`

### Extending the Provider

If you need a specific range you can pass custom `min` and `max` values to the provider:

```kotlin
    val long = LongProvider(min = 1L, max = 15L).get()
```
