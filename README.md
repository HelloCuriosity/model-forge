# Model Forge 🔥🔨

[![Build Status](https://github.com/HelloCuriosity/model-forge/actions/workflows/main.yml/badge.svg?event=push)](https://github.com/HelloCuriosity/model-forge/actions)
[![codecov](https://codecov.io/gh/HelloCuriosity/model-forge/branch/main/graph/badge.svg?token=0P2Q8SLFO7)](https://codecov.io/gh/HelloCuriosity/model-forge)
[![License](https://img.shields.io/dub/l/vibe-d.svg)](https://github.com/HelloCuriosity/model-forge/blob/main/LICENSE)
[![](https://img.shields.io/maven-central/v/io.github.hellocuriosity/model-forge?color=blue)](https://search.maven.org/search?q=io.github.hellocuriosity)

## About

Model Forge is a library to automate model generation for automated testing:

- unit
- integration
- etc.

## Getting Started

### Gradle Setup

<details open>
<summary>Kotlin</summary>

```kotlin
dependencies {
    testImplementation("io.github.hellocuriosity:model-forge:0.1.1")
}
```

</details>

<details>
<summary>Groovy</summary>

```groovy
dependencies {
    testImplementation 'io.github.hellocuriosity:model-forge:0.1.1'
}
```

</details>

### Define you model

```kotlin
data class Employee(
    val id: Long,
    val name: String,
    val dob: Date,
    val age: Int,
    val isTeamLead: Boolean
)
```

### Generate model

```kotlin
val forge = ModelForge()
val testObject = forge.build(Employee::class)
```

or by delegating

```kotlin
val testObject: Employee by forgery()
```

You can create different sized lists by specifying the number of elements.

```kotlin
val forge = ModelForge()
val list = forge.buildList(TestObject::class, 3)
```

or by delegating

```kotlin
val testObjects: List<TestObject> by forgeries()
```

## Supported Types

Model Forge currently supports the auto generation for the following types:

* Boolean
* Date
* Double
* Float
* Int
* Long
* String 
