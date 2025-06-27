# SLF4J Logging Framework Exercise

## Overview
This document covers the implementation of SLF4J (Simple Logging Facade for Java) for logging error messages and warning levels in a Java application.

---

## Dependencies
- SLF4J API 1.7.30  
- Logback Classic 1.2.3 (SLF4J Implementation)

---

## Project Structure

```
src/main/java/org/saptarshi/
├── LoggingExample.java    # Main logging implementation
└── Main.java              # Entry point
```

---

## Code Implementation

### `LoggingExample.java`

```java
package org.saptarshi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        // Log messages at different levels
        logger.error("This is an error message");
        logger.warn("This is a warning message");
        logger.info("This is an info message");
    }
}
```

---

### `pom.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
         http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.saptarshi</groupId>
    <artifactId>Code</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>19</maven.compiler.source>
        <maven.compiler.target>19</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <!-- SLF4J API -->
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>1.7.30</version>
        </dependency>

        <!-- Logback (SLF4J Implementation) -->
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>1.2.3</version>
        </dependency>
    </dependencies>
</project>
```

---

## Output

The program produces the following log output:

```
ERROR - This is an error message  
WARN  - This is a warning message  
INFO  - This is an info message  
```

---

## Key Features Demonstrated

- **Logging Levels**: Shows usage of different log levels (ERROR, WARN, INFO)  
- **SLF4J Integration**: Demonstrates how to integrate SLF4J with a logging implementation (Logback)  
- **Dependency Management**: Uses Maven for managing dependencies  

---

## Running the Example

1. Ensure Maven is installed  
2. Navigate to the project directory  
3. Run the application with:


mvn compile exec:java -Dexec.mainClass="org.saptarshi.LoggingExample"


---

## Best Practices

- **Use appropriate log levels:**
  - `ERROR`: For critical issues that need immediate attention  
  - `WARN`: For potentially harmful situations  
  - `INFO`: For important runtime events

- Use meaningful log messages  
- Configure log levels appropriately in production  
- Consider using MDC (Mapped Diagnostic Context) for adding user/session/request-specific info to logs  

---
