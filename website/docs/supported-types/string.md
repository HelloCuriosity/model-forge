---
sidebar_position: 14
---

# String

The `string` provider generate a random string.

### Default Behavior

`1` word

### Extending the Provider

You can specify the number of words by passing the count to the provider:

```kotlin
    val words = StringProvider(wordCount = 15).get()
```
