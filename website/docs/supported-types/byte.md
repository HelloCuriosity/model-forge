---
sidebar_position: 2
---

# Byte

The `byte` provider generates a random byte value between two integers.

### Default Behavior
Between `-128` and `127`

### Extending the Provider

If you need a specific range you can pass custom `min` and `max` values to the provider:

```kotlin
    val byte = ByteProvider(min = 1, max = 15).get()
```
