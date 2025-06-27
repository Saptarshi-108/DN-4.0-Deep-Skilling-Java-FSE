# JUnit 5 Setup and Basic Testing

## Overview
This exercise demonstrates the basic setup of JUnit 5 for unit testing in Java. It includes a simple Calculator class with an add method and its corresponding test case.

## Project Structure
```
src/
  main/java/org/saswata/
    Calculator.java    # Implementation
    Main.java         # Entry point
  test/java/
    CalculatorTest.java  # Test cases
```

## Implementation

### Calculator.java
```java
package org.saswata;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}
```

### CalculatorTest.java
```java
import org.junit.Test;
import org.saswata.Calculator;

import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void testAdd() {
        Calculator calc = new Calculator();
        int result = calc.add(2, 3);
        assertEquals(5, result);
    }
}
```

### pom.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
         http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.saswata</groupId>
    <artifactId>Week2_TDDusingJUnit5andMockito</artifactId>
    <version>1.0-SNAPSHOT</version>


    <properties>
        <maven.compiler.source>19</maven.compiler.source>
        <maven.compiler.target>19</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>
    
    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
```

## Running Tests
```bash
mvn test
```

## Key Concepts
1. **JUnit Annotations**: `@Test` marks a method as a test case
2. **Assertions**: `assertEquals()` verifies expected vs actual results
3. **Test Naming**: Clear, descriptive test method names
4. **Isolation**: Each test runs independently

## Best Practices
1. One assertion per test method
2. Clear, descriptive test names
3. Follow Arrange-Act-Assert pattern
4. Keep tests simple and focused
