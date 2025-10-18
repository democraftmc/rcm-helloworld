# rcm-helloworld

A simple Hello World module for RustyConnector that demonstrates basic module creation and event listening.

## What This Module Does

This module demonstrates the essential components of a RustyConnector module:

1. **Prints "Hello World"** when the module starts
2. **Registers with the EventManager** to demonstrate event system integration
3. **Prints a goodbye message** when the module shuts down

## Project Structure

```
rcm-helloworld/
├── src/main/
│   ├── java/group/aelysium/rcm/helloworld/
│   │   └── HelloWorldModule.java          # Main module class
│   └── resources/
│       └── rc-module.json                 # Module configuration
├── build.gradle                           # Gradle build configuration
└── README.md
```

## Requirements

- Java 21 or higher
- RustyConnector 0.9.1 or higher

## Building

To build the module JAR:

```bash
./gradlew build
```

The compiled module will be located at `build/libs/rcm-helloworld-1.0.0.jar`

## Installation

1. Build the module using the command above
2. Copy the JAR file from `build/libs/` to your RustyConnector `modules/` directory
3. Restart your RustyConnector proxy

## Expected Output

When the module loads, you should see:

```
Hello World from RustyConnector Module!
```

When the EventManager is available, you should see:

```
HelloWorld module registered with EventManager!
```

## Code Overview

### HelloWorldModule.java

The main module class implements the `Module` interface and contains:

- `close()`: Called when the module shuts down
- `details()`: Returns information about the module (returns null in this simple example)
- `Builder`: Extends `ExternalModuleBuilder` and contains:
  - `onStart()`: Called when the module initializes - prints "Hello World"
  - `bind()`: Called to integrate with the kernel - registers with EventManager

### rc-module.json

The module configuration file that tells RustyConnector:

- `main`: The classpath to the Builder class
- `name`: Module display name
- `description`: What the module does
- `environments`: Where the module runs (proxy, server, or both)

## Learn More

For more information about creating RustyConnector modules, see:

- [RustyConnector Documentation](https://github.com/Aelysium-Group/rustyconnector)
- [Whitelist Module Example](https://github.com/Aelysium-Group/rcm-whitelists)
- [Static Module Example](https://github.com/Aelysium-Group/rcm-staticFamily)

