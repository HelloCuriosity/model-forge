---
sidebar_position: 10
---

# Int

The `int` provider generates a random int value between two integers.

### Default Behavior
Between `-2147483648` and `2147483647`

### Extending the Provider

If you need a specific range you can pass custom `min` and `max` values to the provider:

```kotlin
    val integer = IntegerProvider(min = 1, max = 15).get()
```
