---
sidebar_position: 13
---

# Short

The `short` provider generates a random short value between two integers.

### Default Behavoir
Between `-32768` and `32767`

### Extending the Provider

If you need a specific range you can pass custom `min` and `max` values to the provider:

```kotlin
    val short = ShortProvider(min = 1, max = 15).get()
```
