# Migration Guide

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
