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
    jcenter {
        content {
            // Only download the 'kotlinx-html-jvm' module from JCenter, but nothing else.
            // detekt needs 'kotlinx-html-jvm' for the HTML report.
            // TODO: update me when available on maven central
            // https://github.com/Kotlin/kotlinx.html/issues/81
            // https://github.com/Kotlin/kotlinx.html/issues/173
            includeModule("org.jetbrains.kotlinx", "kotlinx-html-jvm")
        }
    }
}

dependencies {
    implementation("com.thedeanda:lorem:2.1")

    // Testing
    testImplementation("org.junit.jupiter:junit-jupiter:5.4.2")
    testImplementation(kotlin("test-junit"))
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

jacoco {
    toolVersion = "0.8.6"
}

tasks.jacocoTestReport {
    reports {
        csv.isEnabled = false
        html.isEnabled = false
        xml.isEnabled = true
    }
}
