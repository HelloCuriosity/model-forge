# Model Forge 🔥🔨

[![Build Status](https://github.com/HelloCuriosity/model-forge/actions/workflows/main.yml/badge.svg?event=push)](https://github.com/HelloCuriosity/model-forge/actions)
[![codecov](https://codecov.io/gh/HelloCuriosity/model-forge/branch/main/graph/badge.svg?token=0P2Q8SLFO7)](https://codecov.io/gh/HelloCuriosity/model-forge)
[![License](https://img.shields.io/dub/l/vibe-d.svg)](https://github.com/HelloCuriosity/model-forge/blob/main/LICENSE)
[![](https://img.shields.io/maven-central/v/io.github.hellocuriosity/model-forge?color=blue)](https://search.maven.org/search?q=io.github.hellocuriosity)
[![Sonatype Nexus (Snapshots)](https://img.shields.io/nexus/s/io.github.hellocuriosity/model-forge?server=https%3A%2F%2Fs01.oss.sonatype.org)](https://s01.oss.sonatype.org/content/repositories/snapshots/io/github/hellocuriosity/model-forge/)

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
    testImplementation("io.github.hellocuriosity:model-forge:0.4.0")
}
```

</details>

<details>
<summary>Groovy</summary>

```groovy
dependencies {
    testImplementation 'io.github.hellocuriosity:model-forge:0.4.0'
}
```

</details>

### Feeling Adventurous 💥

If you're feeling adventurous you can be on the bleeding edge and test a snapshot:

<details open>
<summary>Kotlin</summary>

```kotlin
repositories {
    maven(url = "https://s01.oss.sonatype.org/content/repositories/snapshots/")
}

dependencies {
    testImplementation("io.github.hellocuriosity:model-forge:0.4.0.xx-SNAPSHOT")
}
```

</details>

<details>
<summary>Groovy</summary>

```groovy
repositories {
    maven { url 'https://s01.oss.sonatype.org/content/repositories/snapshots/' }
}

dependencies {
    testImplementation 'io.github.hellocuriosity:model-forge:0.4.0.xx-SNAPSHOT'
}
```

</details>

### Define your model

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
* Calendar
* Date
* Double
* Enums
* Float
* Int
* Instant
* Long
* String

## Contributors

If you contribute to Model Forge, please feel free to add yourself to the list!

- [Kyle Roe](https://github.com/hopeman15) - Maintainer
- [Adriaan Duz](https://github.com/nxtstep) - Contributor
    - Kotlin class definitions
    - Forgery and forgeries property delegate
