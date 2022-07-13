---
sidebar_position: 9
---

# Float

The `float` provider generates a random float value between two doubles.

### Default Behavoir

Between `1.4E-45F` and `3.4028235E38F`

### Extending the Provider

If you need a specific range you can pass custom `min` and `max` values to the provider:

```kotlin
    val float = FloatProvider(min = 1.0, max = 15.0).get()
```
