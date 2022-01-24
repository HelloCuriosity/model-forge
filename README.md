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
    testImplementation("io.github.hellocuriosity:model-forge:0.8.0")
}
```

</details>

<details>
<summary>Groovy</summary>

```groovy
dependencies {
    testImplementation 'io.github.hellocuriosity:model-forge:0.8.0'
}
```

</details>

### Feeling Adventurous 💥

If you're feeling adventurous you can be on the cutting edge and test a snapshot:

<details open>
<summary>Kotlin</summary>

```kotlin
repositories {
    maven(url = "https://s01.oss.sonatype.org/content/repositories/snapshots/")
}

dependencies {
    testImplementation("io.github.hellocuriosity:model-forge:0.8.0.xx-SNAPSHOT")
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
    testImplementation 'io.github.hellocuriosity:model-forge:0.8.0.xx-SNAPSHOT'
}
```

</details>

### Define your model

```kotlin
data class Employee(
    val id: Long,
    val name: String,
    val dob: Instant,
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
val testObjects: List<TestObject> by forgeryList()
```

## Custom Provider

While Model Forge aims to fully automate model generation, you may run into an instance where you need to customize your
data. This is easily achievable by defining a custom provider and adding it to the forge.

### Define your provider

```kotlin
val testProvider: Provider<TestObject> = Provider {
    Employee(
        id = 15L,
        name = "Josh",
        dob = Instant.ofEpochMilli(1315260000000)
    )
}
```

### Add your provider to the forge

```java
forge.addProvider(TestObject.class,testProvider);
```

or Kotlin

```kotlin
forge.addProvider(testProvider)
```

### Inline your provider(s)

Alternatively you can add your forgery providers inline

```kotlin

val forge = ModelForge().apply {
    addProvider {
        Employee(
            id = 2L,
            name = "Hendrik",
            dob = Instant.ofEpochMilli(1574486400000)
        )
    }
}
val employee by forgery<Employee>(forge)

```

## Supported Types

Model Forge currently supports the auto generation for the following types:

### Types

* Boolean
* Byte
* Calendar
* Char
* Date
* Double
* Enums
* File
* Float
* Int
* Instant
* Long
* Short
* String
* UUID

### Collections

* List
* Map (_SNAPSHOT_)
* Set

_Can't find your data type? Feel free to create a pull request or open an issue_ :parachute:

## Contributors

If you contribute to Model Forge, please feel free to add yourself to the list!

* [Kyle Roe](https://github.com/hopeman15) - Maintainer
* [Adriaan Duz](https://github.com/nxtstep) - Contributor
    * Kotlin class definitions
    * Forgery and forgeries property delegate
    * Reified inline extension functions
