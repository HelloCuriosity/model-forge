# Model Forge 🔥🔨

[![Build Status](https://github.com/HelloCuriosity/model-forge/actions/workflows/main.yml/badge.svg?event=push)](https://github.com/HelloCuriosity/model-forge/actions)
[![codecov](https://codecov.io/gh/HelloCuriosity/model-forge/branch/main/graph/badge.svg?token=0P2Q8SLFO7)](https://codecov.io/gh/HelloCuriosity/model-forge)
[![License](https://img.shields.io/dub/l/vibe-d.svg)](https://github.com/HelloCuriosity/model-forge/blob/main/LICENSE)
[![ko-fi](https://img.shields.io/badge/donate%20on-Ko--fi-blue.svg)](https://ko-fi.com/U7U4L9F5)

## About

Model Forge is a library to automate model generation for automated testing:

- unit
- integration
- etc.

## Getting Started

### Define you model

```kotlin
data class TestObject(
    val intValue: Int,
    val longValue: Long,
    val stringValue: String
)
```

### Generate model

```kotlin
val forge = ModelForge()
val testObject = forge.build(TestObject::class.java)
```

You can create different sized lists by specifying the number of elements.

```kotlin
val forge = ModelForge()
val list = forge.buildList(TestObject::class.java, 3)
```

## Supported Types

Model Forge currently supports the auto generation for the following types:

* Int
* Long
* String 
