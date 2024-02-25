---
sidebar_position: 6
---

# Double

The `double` provider generates a random double value between two doubles.

### Default Behavior

Between `4.9E-324` and `1.7976931348623157E308`

### Extending the Provider

If you need a specific range you can pass custom `min` and `max` values to the provider:

```kotlin
    val double = DoubleProvider(min = 1.0, max = 15.0).get()
```
