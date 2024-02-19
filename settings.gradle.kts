rootProject.name = "model-forge"
include(
    "forge-core",
    "forge-test-utils"
)

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("gradle/dependencies.versions.toml"))
        }
    }
}
