plugins {
    kotlin("jvm")

    // Publishing
    `java-library`
    `maven-publish`
    signing
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.objenesis:objenesis:3.2")
    implementation("com.thedeanda:lorem:2.1")

    // Testing
    testImplementation(project(":test-utils"))

    testImplementation("org.junit.jupiter:junit-jupiter:5.7.2")
    testImplementation(kotlin("test-junit"))
    testImplementation("org.mockito.kotlin:mockito-kotlin:3.2.0")
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
