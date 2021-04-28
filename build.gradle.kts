import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "io.github.hellocuriosity"
version = "0.1.0"

plugins {
    kotlin("jvm") version "1.4.32"
    id("org.jmailen.kotlinter") version "3.4.2"
    id("io.gitlab.arturbosch.detekt") version "1.16.0"
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
    implementation("org.objenesis:objenesis:3.2")
    implementation("com.thedeanda:lorem:2.1")

    // Testing
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.1")
    testImplementation(kotlin("test-junit"))
    testImplementation("org.mockito.kotlin:mockito-kotlin:3.1.0")
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
