---
sidebar_position: 8
---

# File

The `file` provider generates a file with a random name from the `StringProvider`.

### Default Behavior

See [string](string.md).

### Extending the Provider

If you need a specific file name, you can pass a custom `string` provider:

```kotlin
    val provider: Provider<String> = Provider { "filename" }
    val file = FileProvider(stringProvider = provider).get()
```
