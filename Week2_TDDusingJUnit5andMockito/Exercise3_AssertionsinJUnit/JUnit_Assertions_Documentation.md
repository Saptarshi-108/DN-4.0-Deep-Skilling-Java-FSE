# JUnit 5 Assertions

## Overview
This exercise demonstrates various assertion methods available in JUnit 5 for writing effective test cases. It covers different types of assertions for validating test conditions.

## Key Assertion Methods

### 1. Basic Assertions
- `assertEquals(expected, actual, message)`: Verifies that expected and actual are equal
- `assertNotEquals(unexpected, actual, message)`: Verifies that expected and actual are not equal
- `assertTrue(condition, message)`: Verifies that the condition is true
- `assertFalse(condition, message)`: Verifies that the condition is false
- `assertNull(actual, message)`: Verifies that the actual value is null
- `assertNotNull(actual, message)`: Verifies that the actual value is not null

### 2. Array Assertions
- `assertArrayEquals(expected, actual, message)`: Verifies that the expected and actual arrays are equal

### 3. Exception Assertions
- `assertThrows(exceptionType, executable)`: Verifies that the executable throws the expected exception

### 4. Grouped Assertions
- `assertAll(heading, executables...)`: Groups multiple assertions and executes them all, reporting any failures

## Example Implementation

### AssertionsTest.java
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {
    @Test
    public void testAssertions() {
        // Basic assertions
        assertEquals(5, 2 + 3, "2 + 3 should equal 5");
        
        // Array assertion
        assertArrayEquals(new int[] {1, 2}, new int[] {1, 2});
        
        // Exception assertion
        assertThrows(ArithmeticException.class, () -> {
            int x = 1 / 0;
        });
        
        // Grouped assertions
        assertAll(
            () -> assertTrue(10 > 5),
            () -> assertNotNull("JUnit")
        );

        // Boolean assertions
        assertTrue(5 > 3, "5 is greater than 3");
        assertFalse(5 < 3, "5 is not less than 3");

        // Null assertions
        assertNull(null, "Expected value to be null");
        assertNotNull(new Object(), "Expected non-null object");
    }
}
```

## Running Tests
```bash
mvn test
```

## Best Practices
1. Always provide descriptive messages in assertions
2. Use the most specific assertion that matches your needs
3. Group related assertions using `assertAll()`
4. Test both positive and negative scenarios
5. Use appropriate assertion methods for different data types

## Common Assertion Patterns

### Testing for Exceptions
```java
@Test
void testException() {
    Exception exception = assertThrows(
        ArithmeticException.class,
        () -> calculator.divide(1, 0)
    );
    
    assertEquals("/ by zero", exception.getMessage());
}
```

### Testing Multiple Properties
```java
@Test
void testPersonDetails() {
    Person person = new Person("John", "Doe", 30);
    
    assertAll("person",
        () -> assertEquals("John", person.getFirstName()),
        () -> assertEquals("Doe", person.getLastName()),
        () -> assertTrue(person.getAge() > 0)
    );
}
```

### Testing Arrays and Collections
```java
@Test
void testArrayEquality() {
    int[] expected = {1, 2, 3};
    int[] actual = {1, 2, 3};
    
    assertArrayEquals(expected, actual, "Arrays should be equal");
}
```
