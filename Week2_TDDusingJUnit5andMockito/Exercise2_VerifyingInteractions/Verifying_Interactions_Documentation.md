# Verifying Interactions with Mockito

## Overview

This exercise demonstrates how to verify interactions with mock objects using Mockito. It shows how to ensure that certain methods were called with specific parameters and how many times they were invoked during test execution.

## Key Concepts

### Verification

- Confirming that specific methods were called on mock objects
- Verifying the number of method invocations
- Checking the order of method calls
- Verifying method arguments

### Common Verification Modes

- `times(n)`: Verifies exact number of invocations
- `never()`: Verifies zero interactions
- `atLeast(n)`: Verifies minimum number of invocations
- `atMost(n)`: Verifies maximum number of invocations
- `atLeastOnce()`: Verifies one or more invocations

## Implementation

### MyService.java

```java
package org.saptarshi;

public class MyService {
    private final ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData();
    }
}
```

### ExternalApi.java

```java
package org.saptarshi;

public interface ExternalApi {
    String getData();
}
```

### MyServiceTest.java

```java
import org.junit.jupiter.api.Test;
import org.saptarshi.ExternalApi;
import org.saptarshi.MyService;

import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {
        // 1. Create a mock of ExternalApi
        ExternalApi mockApi = mock(ExternalApi.class);

        // 2. Inject mock into MyService
        MyService service = new MyService(mockApi);

        // 3. Call method under test
        service.fetchData();

        // 4. Verify that getData() was called exactly once
        verify(mockApi).getData();
    }
}
```

## Common Verification Patterns

### Verifying Exact Number of Invocations

```java
// Verify method was called exactly once (default)
verify(mock).someMethod();

// Verify method was called exactly n times
verify(mock, times(3)).someMethod();

// Verify method was never called
verify(mock, never()).someMethod();

// Verify method was called at least once
verify(mock, atLeastOnce()).someMethod();

// Verify method was called at least n times
verify(mock, atLeast(2)).someMethod();

// Verify method was called at most n times
verify(mock, atMost(3)).someMethod();
```

### Verifying with Argument Matchers

```java
// Verify with any argument
verify(mock).someMethod(anyString());

// Verify with specific argument
verify(mock).someMethod("expected value");

// Verify with argument matcher
verify(mock).someMethod(argThat(arg -> arg.contains("test")));
```

### Verifying in Order

```java
// Create in-order verifier
InOrder inOrder = inOrder(mock1, mock2);

// Verify calls in specific order
inOrder.verify(mock1).firstMethod();
inOrder.verify(mock2).secondMethod();
```

### Verifying No More Interactions

```java
// Verify no more interactions with this mock
verifyNoMoreInteractions(mock);

// Verify no interactions at all with this mock
verifyNoInteractions(mock);
```

## Advanced Verification

### Verifying with Timeout

```java
// Verify method was called within 100ms
verify(mock, timeout(100)).someMethod();

// Verify method was called exactly 2 times within 100ms
verify(mock, timeout(100).times(2)).someMethod();
```

### Capturing Arguments

```java
// Create argument captor
ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

// Verify and capture argument
verify(mock).someMethod(captor.capture());

// Get captured value
String capturedValue = captor.getValue();
assertEquals("expected", capturedValue);
```

## Best Practices

1. **Be specific but not over-specified**: Verify important interactions without testing implementation details
2. **Focus on behavior, not implementation**: Test what the method does, not how it does it
3. **Use argument matchers wisely**: Be as specific as necessary with argument matching
4. **Keep verifications minimal**: Only verify what's important for the test case
5. **Use in-order verification sparingly**: Only when the order of operations is critical
6. **Clear test names**: Use descriptive test method names that explain the verification

## Common Pitfalls

1. **Over-verification**: Verifying every single interaction can make tests brittle
2. **Testing the mock**: Remember you're testing the unit under test, not the mock
3. **Missing verifications**: Forgetting to verify important interactions
4. **Incorrect argument matching**: Using matchers that are too loose or too strict
5. **Ignoring test failures**: Not addressing failing verification tests

## Running Tests

```bash
mvn test
```

## Example Test Output

```
Test run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.123 s
```

## Dependencies (pom.xml)

```xml
<dependencies>
    <!-- JUnit 5 -->
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-api</artifactId>
        <version>5.8.2</version>
        <scope>test</scope>
    </dependency>

    <!-- Mockito -->
    <dependency>
        <groupId>org.mockito</groupId>
        <artifactId>mockito-core</artifactId>
        <version>4.5.1</version>
        <scope>test</scope>
    </dependency>

    <!-- Mockito JUnit 5 Extension -->
    <dependency>
        <groupId>org.mockito</groupId>
        <artifactId>mockito-junit-jupiter</artifactId>
        <version>4.5.1</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```
