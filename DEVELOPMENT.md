# Development Notes

## RustyConnector SDK Version

This module uses RustyConnector Core SDK version **0.9.1**, which is the current stable release.

## Dependencies

The module depends on:
- `group.aelysium.rustyconnector:core:0.9.1` - The RustyConnector Core SDK
- `net.kyori:adventure-api:4.17.0` - For text components
- `org.jetbrains:annotations:24.1.0` - For annotations

## Build Configuration

The project uses:
- **Java 21** as the target version
- **Gradle 8.3** as the build tool
- Maven repositories:
  - Maven Central
  - https://maven.mrnavastar.me/snapshots/
  - https://maven.mrnavastar.me/releases/

## API Structure (0.9.x)

The RustyConnector 0.9.x API uses the following package structure:
- `group.aelysium.rustyconnector.common.modules.*` - Module interfaces and builders
- `group.aelysium.rustyconnector.common.events.*` - Event system
- `group.aelysium.rustyconnector.proxy.*` - Proxy-specific classes
- `net.kyori.adventure.text.*` - Text components (from Kyori Adventure)

## Module Integration

To integrate with the RustyConnector kernel:

1. The `onStart()` method is called first to initialize the module
2. The `bind()` method is called to integrate with kernel services
3. Use `kernel.fetchModule()` to access other modules like EventManager
4. The `close()` method is called when the module shuts down

