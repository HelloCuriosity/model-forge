import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektCreateBaselineTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

allprojects {
    group = "io.github.hellocuriosity"
    version = System.getenv("VERSION") ?: "local"

    apply(plugin = "org.jetbrains.kotlinx.kover")
}

plugins {
    kotlin("jvm") version libs.versions.kotlin.get()

    // Quality gate
    alias(libs.plugins.kotlinter)
    alias(libs.plugins.detekt)
    alias(libs.plugins.kover)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

tasks.test {
    useJUnit()
}

tasks.withType<Detekt>().configureEach {
    jvmTarget = "17"
    reports {
        html.required.set(true)
        xml.required.set(false)
        txt.required.set(false)
        sarif.required.set(false)
    }
}

tasks.withType<DetektCreateBaselineTask>().configureEach {
    jvmTarget = "17"
}

// Kover
dependencies {
    kover(project(":forge-core"))
}

koverReport {
    defaults {
        xml {
            onCheck = false
            setReportFile(layout.buildDirectory.file("$buildDir/reports/kover/result.xml"))
        }
        html {
            onCheck = false
            setReportDir(layout.buildDirectory.dir("$buildDir/reports/kover/html-result"))
        }
    }
}
