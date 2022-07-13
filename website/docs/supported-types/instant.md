---
sidebar_position: 11
---

# Instant

The `instant` provider generates a random instant between two `timestamps`.

### Default Behavoir
From `529714800000L` until `1617141600000L`

### Extending the Provider

If you need a specific range you can pass custom `timestamps` to the provider:

```kotlin
    val instant = InstantProvider(from = 1315260000000L, until = 1574486400000L).get()
```
