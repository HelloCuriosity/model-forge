---
sidebar_position: 18
---

# UShort (Snapshot)

The `UShort` provider generates a random UShort value between two unsigned integers.

### Default Behavior

Between `0` and `65,535`

### Extending the Provider

If you need a specific range you can pass custom `min` and `max` values to the provider:

```kotlin
    val uShort = UShortProvider(min = 1u, max = 15u).get()
```
