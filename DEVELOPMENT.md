# Development Notes

## RustyConnector SDK Stub Classes

This project includes minimal stub interfaces for the RustyConnector Core SDK in the `src/main/java/group/aelysium/rustyconnector/` package. These stubs are provided to allow the module to compile without access to the actual RustyConnector SDK repository.

**Important**: When this module is loaded by RustyConnector at runtime, the actual SDK classes will be used instead of these stubs. These stubs only provide the minimal interface definitions needed for compilation.

If you have access to the RustyConnector SDK repository, you can replace the stub dependency in `build.gradle`:

```gradle
// Replace this:
dependencies {
    compileOnly 'org.jetbrains:annotations:24.0.1'
}

// With this (when repository is accessible):
repositories {
    mavenCentral()
    maven {
        url = 'https://repo.aelysium.group/repository/maven-public/'
    }
}

dependencies {
    compileOnly 'group.aelysium.rustyconnector:core:5.2.1'
}
```

Then remove the stub classes from `src/main/java/group/aelysium/rustyconnector/`.
