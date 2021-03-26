import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "com.hello.curiosity"
version = "1.0-SNAPSHOT"

plugins {
    kotlin("jvm") version "1.4.31"
    id("org.jmailen.kotlinter") version "3.4.0"
    id("io.gitlab.arturbosch.detekt") version "1.15.0"
    jacoco
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test-junit"))
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.jacocoTestReport {
    reports {
        csv.isEnabled = false
        html.isEnabled = false
        xml.isEnabled = true
    }
}

jacoco {
    toolVersion = "0.8.6"
}
