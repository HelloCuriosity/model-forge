import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.KotlinJvm
import com.vanniktech.maven.publish.SonatypeHost

plugins {
    kotlin("jvm")

    // Quality gate
    alias(libs.plugins.kotlinter)
    alias(libs.plugins.detekt)

    // Publishing
    alias(libs.plugins.vanniktech)

    // Documentation
    alias(libs.plugins.dokka)
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

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
    signAllPublications()

    coordinates(
        "io.github.hellocuriosity",
        "model-forge",
        System.getenv("VERSION") ?: "local"
    )

    configure(
        KotlinJvm(
            javadocJar = JavadocJar.Dokka("dokkaHtml"),
            sourcesJar = true,
        )
    )

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
