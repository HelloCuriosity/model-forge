---
sidebar_position: 15
---

# UByte

The `UByte` provider generates a random UByte value between two unsigned integers.

### Default Behavior

Between `0` and `255`

### Extending the Provider

If you need a specific range you can pass custom `min` and `max` values to the provider:

```kotlin
    val uByte = UByteProvider(min = 1u, max = 15u).get()
```
