# Migration Guide

## 1.0.0

In version 1.0.0 we removed the forgeries function.

Replace all instances of:
```kotlin
    forgeries()
```

with:
```kotlin
    forgeryList()
```

## 0.9.0

In version 0.9.0 we removed the custom provider in favor of javax provider for easier 
adaptation in other projects. 

Replace all instances of:
```kotlin
    import io.github.hellocuriosity.providers.Provider
```

with:
```kotlin
    import javax.inject.Provider
```
