import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "io.github.hellocuriosity"
version = System.getenv("VERSION") ?: "null"

plugins {

    kotlin("jvm") version "1.4.32"

    // Quality gate
    id("org.jmailen.kotlinter") version "3.4.4"
    id("io.gitlab.arturbosch.detekt") version "1.16.0"
    jacoco

    // Publishing
    `java-library`
    `maven-publish`
    signing
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

tasks.register<Jar>("sourcesJar") {
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allJava)
}

tasks.register<Jar>("javadocJar") {
    archiveClassifier.set("javadoc")
    from(tasks.javadoc.get().destinationDir)
}

publishing {
    repositories {
        maven {
            name = "MavenCentral"
            val releasesRepoUrl = "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2"
            val snapshotsRepoUrl = "https://s01.oss.sonatype.org/content/repositories/snapshots"

            url = uri(
                if (System.getenv("IS_RELEASE") == "true") releasesRepoUrl
                else snapshotsRepoUrl
            )

            credentials {
                username = System.getenv("SONATYPE_USER")
                password = System.getenv("SONATYPE_PWD")
            }
        }
    }
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            artifact(tasks["sourcesJar"])
            artifact(tasks["javadocJar"])

            pom {
                name.set("Model Forge")
                description.set("Model Forge is a library to automate model generation for automated testing.")
                url.set("https://github.com/HelloCuriosity/model-forge")
                licenses {
                    license {
                        name.set("MIT Licence")
                        url.set("https://github.com/HelloCuriosity/model-forge/blob/main/LICENSE")
                    }
                }
                developers {
                    developer {
                        id.set("hopeman15")
                        name.set("Kyle Roe")
                    }
                }
                scm {
                    connection.set("scm:git:https://github.com/HelloCuriosity/model-forge.git")
                    developerConnection.set("scm:git:https://github.com/HelloCuriosity/model-forge.git")
                    url.set("https://github.com/HelloCuriosity/model-forge")
                }
            }
        }
    }

    signing {
        val signingKey: String? = System.getenv("SIGNING_KEY")
        val signingPwd: String? = System.getenv("SIGNING_PWD")
        useInMemoryPgpKeys(signingKey, signingPwd)
        sign(publishing.publications["mavenJava"])
    }
}
