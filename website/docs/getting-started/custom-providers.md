---
sidebar_position: 2
---

# Custom Providers

While Model Forge aims to fully automate model generation, you may run into an
instance where you need to customize your data. This is easily achievable by
defining a custom provider and adding it to the forge.

#### Define your provider

```kotlin
val employeeProvider: Provider<Employee> = Provider {
    Employee(
        id = 15L,
        name = "Josh",
        dob = Instant.ofEpochMilli(1315260000000)
    )
}
```

#### Add your provider to the forge

```kotlin
forge.addProvider(employeeProvider)
```

#### Inline your provider(s)

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
