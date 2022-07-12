object Versions {
    const val javax = "1"
    const val objenesis = "3.2"
    const val lorem = "2.1"
    const val jupiter = "5.8.2"
    const val mockk = "1.12.4"
    const val kotlin = "1.7.10"
    const val kotlinter = "3.10.0"
    const val detekt = "1.20.0"
    const val kover = "0.5.0"
    const val versions = "0.42.0"
}

object Dependency {
    const val objenesis = "org.objenesis:objenesis:${Versions.objenesis}"
    const val lorem = "com.thedeanda:lorem:${Versions.lorem}"

    object JavaX {
        const val inject = "javax.inject:javax.inject:${Versions.javax}"
    }

    object Test {
        const val junitJupiter = "org.junit.jupiter:junit-jupiter:${Versions.jupiter}"
        const val mockK = "io.mockk:mockk:${Versions.mockk}"
    }

    // Quality Gates
    const val detekt = "io.gitlab.arturbosch.detekt"
    const val kotlinter = "org.jmailen.kotlinter"
    const val kover = "org.jetbrains.kotlinx.kover"
    const val versions = "com.github.ben-manes.versions"
}
