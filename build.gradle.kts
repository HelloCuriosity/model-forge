import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

allprojects {
    group = "io.github.hellocuriosity"
    version = System.getenv("VERSION") ?: "local"
}

plugins {
    kotlin("jvm") version "1.5.31"

    // Quality gate
    id("org.jmailen.kotlinter") version "3.6.0"
    id("io.gitlab.arturbosch.detekt") version "1.18.1"
    jacoco
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(8))
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.test {
    useJUnit()
}

detekt {
    reports {
        html.enabled = true
        xml.enabled = true
        txt.enabled = false
        sarif.enabled = false
    }
}
