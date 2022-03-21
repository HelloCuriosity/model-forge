import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektCreateBaselineTask
import kotlinx.kover.api.KoverTaskExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

allprojects {
    group = "io.github.hellocuriosity"
    version = System.getenv("VERSION") ?: "local"
}

plugins {
    kotlin("jvm") version Versions.kotlin

    // Quality gate
    id("org.jmailen.kotlinter") version Versions.kotlinter
    id("io.gitlab.arturbosch.detekt") version Versions.detekt
    id("org.jetbrains.kotlinx.kover") version Versions.kover
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
    kotlinOptions.jvmTarget = "11"
}

tasks.test {
    useJUnit()
}

tasks.withType<Detekt>().configureEach {
    jvmTarget = "11"
    reports {
        html.required.set(true)
        xml.required.set(false)
        txt.required.set(false)
        sarif.required.set(false)
    }
}

tasks.withType<DetektCreateBaselineTask>().configureEach {
    jvmTarget = "11"
}

tasks.test {
    extensions.configure(KoverTaskExtension::class) {
        isEnabled = true
    }
}

kover {
    isDisabled = false
    jacocoEngineVersion.set("0.8.7")
    generateReportOnCheck = true
}
