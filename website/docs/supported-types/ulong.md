---
sidebar_position: 17
---

# ULong (Snapshot)

The `ULong` provider generates a random ULong value between two unsigned longs.

### Default Behavoir

Between <code>0</code> and <code>18,446,744,073,709,551,615 (2<sup>64 - 1</sup>)</code>

### Extending the Provider

If you need a specific range you can pass custom `min` and `max` values to the provider:

```kotlin
    val uLong = ULongProvider(min = 1u, max = 15u).get()
```
