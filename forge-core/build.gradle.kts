import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")

    // Quality gate
    alias(libs.plugins.kotlinter)
    alias(libs.plugins.detekt)

    // Publishing
    `java-library`
    `maven-publish`
    signing
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.objenesis)
    implementation(libs.lorem)
    // Javax inject
    api(libs.inject)

    // Testing
    testImplementation(project(":forge-test-utils"))
    testImplementation(libs.junitJupiter)
    testImplementation(kotlin("test-junit"))
    testImplementation(libs.mockK)
}

java {
    withSourcesJar()
    withJavadocJar()
}

tasks.withType<Sign>().configureEach {
    onlyIf { System.getenv("CI") == "true" }
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
            artifactId = "model-forge"
            from(components["java"])

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
