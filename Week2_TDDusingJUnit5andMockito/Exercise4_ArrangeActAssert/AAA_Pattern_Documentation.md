# Arrange-Act-Assert (AAA) Pattern in JUnit 5

## Overview

This exercise demonstrates the Arrange-Act-Assert (AAA) pattern, a fundamental testing pattern that structures test methods into three distinct sections for better readability and maintainability.

## AAA Pattern Explained

### 1. Arrange

- Set up the test environment and inputs
- Create necessary objects and data
- Prepare the system under test

### 2. Act

- Execute the code being tested
- Perform the operation that produces the result

### 3. Assert

- Verify the outcome matches expectations
- Check the results of the action
- Validate the state changes

## Example Implementation

### Calculator.java

```java
package org.saptarshi;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public void clearMemory() {
        // Reset any internal state if needed
    }
}
```

### CalculatorTest.java

```java
import org.junit.jupiter.api.*;
import org.saptarshi.Calculator;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        // Arrange: Set up test environment
        calculator = new Calculator();
        System.out.println("✅ Setup complete");
    }

    @AfterEach
    void tearDown() {
        // Clean up after each test
        calculator.clearMemory();
        System.out.println("🧹 Teardown complete");
    }

    @Test
    void testAddition() {
        // Arrange
        int a = 2;
        int b = 3;
        int expected = 5;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(expected, result, "2 + 3 should equal 5");
    }

    @Test
    void testMultiplication() {
        // Arrange
        int a = 4;
        int b = 5;
        int expected = 20;

        // Act
        int result = calculator.multiply(a, b);

        // Assert
        assertEquals(expected, result, "4 * 5 should equal 20");
    }
}
```

## Key Benefits of AAA Pattern

1. **Readability**: Clear separation of test phases
2. **Maintainability**: Easy to understand and modify
3. **Consistency**: Standardized test structure
4. **Debugging**: Easier to identify where a test fails
5. **Documentation**: Tests serve as living documentation

## Best Practices

1. **Single Responsibility**: Test one behavior per test method
2. **Descriptive Names**: Use clear, descriptive test method names
3. **Minimal Arrange**: Only set up what's necessary for the test
4. **Single Act**: Perform one action per test
5. **Clear Assertions**: Make assertions specific and meaningful
6. **Use Setup/Teardown**: For common initialization and cleanup

## Common Test Annotations

- `@BeforeEach`: Runs before each test method
- `@AfterEach`: Runs after each test method
- `@BeforeAll`: Runs once before all test methods
- `@AfterAll`: Runs once after all test methods
- `@Test`: Marks a method as a test case

## Running Tests

```bash
mvn test
```

## Example Output

```
✅ Setup complete
🧪 Running testAddition...
✅ Test passed: 2 + 3 = 5
🧹 Teardown complete

✅ Setup complete
🧪 Running testMultiplication...
✅ Test passed: 4 * 5 = 20
🧹 Teardown complete
```

## Common Pitfalls to Avoid

1. **Multiple Acts**: Avoid multiple actions in a single test
2. **Overly Complex Setup**: Keep arrange section minimal
3. **Hidden Logic**: Make test logic explicit and clear
4. **Test Dependencies**: Ensure tests are independent
5. **Incomplete Assertions**: Verify all relevant outcomes
