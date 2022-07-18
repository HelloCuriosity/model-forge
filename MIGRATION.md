# Migration Guide

## 1.0.0 - July 18th 2022

In version 1.0.0 we removed the deprecated `forgeries` and `build` (list) reified functions. The same functionality
is covered in the `forgeryList()` and `buildList()` functions.

Replace instances of:
```kotlin
forgeries()
```

with:
```kotlin
forgeryList()
```

Replace all instances of:
```kotlin
build() // list
```

with:
```kotlin
buildList()
```

## 0.9.0 - March 22nd 2022

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
