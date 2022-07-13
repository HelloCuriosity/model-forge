---
sidebar_position: 3
---

# Calendar

The `calendar` provider generates a random calendar instance between two `timestamps`.

### Default Behavoir
From `529714800000L` until `1617141600000L`

### Extending the Provider

If you need a specific range you can pass custom `timestamps` to the provider:

```kotlin
    val calendar = CalendarProvider(from = 1315260000000L, until = 1574486400000L).get()
```
