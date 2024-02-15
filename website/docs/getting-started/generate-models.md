---
sidebar_position: 2
---

import Tabs from '@theme/Tabs';
import TabItem from '@theme/TabItem';

# Generating Models

#### Define your model

```kotlin
data class Employee(
    val id: Long,
    val name: String,
    val dob: Instant,
)
```

#### Generate
<Tabs groupId="generation">
  <TabItem value="model" label="Model" default>

  ```kotlin
  val forge = ModelForge()
  val employee = forge.build<Employee>()
  ```
  </TabItem>
  <TabItem value="list" label="List">

  ```kotlin
  val forge = ModelForge()
  val employees = forge.buildList<Employee>(size = 3)
  ```

  </TabItem>
  <TabItem value="set" label="Set">

  ```kotlin
  val forge = ModelForge()
  val employees = forge.buildSet<Employee>(size = 3)
  ```
    
  </TabItem>
</Tabs>

#### or by Delegation
<Tabs groupId="generation">
  <TabItem value="model" label="Model" default>
  
  ```kotlin
  val employee: Employee by forgery()
  ```

  </TabItem>
  <TabItem value="list" label="List">

  ```kotlin
  val employees: List<Employee> by forgeryList(size = 3)
  ```

  </TabItem>

  <TabItem value="set" label="Set">

  ```kotlin
  val employees: List<Employee> by forgerySet(size = 3)
  ```

  </TabItem>
</Tabs>
