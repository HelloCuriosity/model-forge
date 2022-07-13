---
sidebar_position: 5
---

# Date

The `date` provider generates a random calendar instance between two `timestamps`.

### Default Behavoir
From `529714800000L` until `1617141600000L`

### Extending Calendar Provider

If you need a specific range you can pass custom `timestamps` to the provider:

```kotlin
    val date = DateProvider(from = 1315260000000L, until = 1574486400000L).get()
    
```
