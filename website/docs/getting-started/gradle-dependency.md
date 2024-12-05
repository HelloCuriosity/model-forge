---
sidebar_position: 1
---

# Gradle Setup

Add the dependency to your `build.gradle` file to get started:

```kotlin
dependencies {
    testImplementation("io.github.hellocuriosity:model-forge:1.5.1")
}
```

#### Feeling Adventurous 💥

If you're feeling adventurous you can be on the cutting edge and test a snapshot:

```kotlin
repositories {
    maven(url = "https://s01.oss.sonatype.org/content/repositories/snapshots/")
}

dependencies {
    testImplementation("io.github.hellocuriosity:model-forge:1.5.1.xx-SNAPSHOT")
}
```
