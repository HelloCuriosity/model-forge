---
sidebar_position: 15
---

# UInt (Snapshot)

The `UInt` provider generates a random UInt value between two unsigned integers.

### Default Behavoir
Between 0 and 4,294,967,295 (2<sup>32 - 1</sup>)

### Extending the Provider

If you need a specific range you can pass custom `min` and `max` values to the provider:

```kotlin
    val uInteger = UIntProvider(min = 1u, max = 15u).get()
```
