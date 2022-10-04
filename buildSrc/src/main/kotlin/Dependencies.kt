object Versions {
    const val javax = "1"
    const val objenesis = "3.3"
    const val lorem = "2.1"
    const val jupiter = "5.9.1"
    const val mockk = "1.13.2"
    const val kotlin = "1.7.20"
    const val kotlinter = "3.11.1"
    const val detekt = "1.20.0"
    const val kover = "0.6.1"
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

fun isNonStable(version: String): Boolean {
    val stableKeyword = setOf("RELEASE", "FINAL", "GA").any { version.toUpperCase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(version)
    return isStable.not()
}
