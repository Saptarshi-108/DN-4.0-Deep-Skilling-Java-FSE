# Mocking and Stubbing with Mockito

## Overview

This exercise demonstrates how to use Mockito for mocking dependencies and stubbing method calls in unit tests. It shows how to isolate the unit under test by replacing its dependencies with test doubles.

## Key Concepts

### Mocking

- Creating a mock object that simulates the behavior of a real object
- Used to isolate the code being tested from its dependencies
- Verifies interactions between objects

### Stubbing

- Defining the behavior of mock objects
- Specifying return values for method calls
- Configuring mock objects to throw exceptions
- Controlling the behavior of mock objects

## Implementation

### ExternalApi.java (Interface)

```java
package org.saptarshi;

public interface ExternalApi {
    String getData();
}
```

### MyService.java (Class Under Test)

```java
package org.saptarshi;

public class MyService {
    private final ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData();  // Calls the external API (mocked in tests)
    }
}
```

### MyServiceTest.java (Test Class)

```java
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.saptarshi.ExternalApi;
import org.saptarshi.MyService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MyServiceTest {

    @Test
    public void testExternalApi() {
        // 1. Create a mock of the ExternalApi
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // 2. Stub the getData() method to return a specific value
        when(mockApi.getData()).thenReturn("Mock Data");

        // 3. Inject the mock into the service
        MyService service = new MyService(mockApi);

        // 4. Call the method under test
        String result = service.fetchData();

        // 5. Verify the result
        assertEquals("Mock Data", result);
    }
}
```

## Mockito Annotations

### @Mock

```java
@Mock
private ExternalApi mockApi;

@BeforeEach
void setUp() {
    MockitoAnnotations.openMocks(this);
}
```

### @InjectMocks

```java
@Mock
private ExternalApi mockApi;

@InjectMocks
private MyService myService;
```

## Common Mockito Methods

### Stubbing

```java
// Return a specific value
when(mock.method()).thenReturn(value);

// Throw an exception
when(mock.method()).thenThrow(new RuntimeException());

// Return different values on consecutive calls
when(mock.method())
    .thenReturn(value1)
    .thenReturn(value2);

// Use Answer for complex stubbing
when(mock.method()).thenAnswer(invocation -> {
    // Custom logic here
    return result;
});
```

### Verifying Interactions

```java
// Verify a method was called
verify(mock).method();

// Verify exact number of invocations
verify(mock, times(2)).method();

// Verify no more interactions
verifyNoMoreInteractions(mock);

// Verify no interactions at all
verifyNoInteractions(mock);
```

## Best Practices

1. **Use meaningful mock names**: Helps in test readability
2. **Keep tests focused**: Test one behavior per test method
3. **Use argument matchers**: For flexible argument matching
4. **Verify interactions**: Ensure mocks are used as expected
5. **Don't mock value objects**: Simple data objects don't need mocks
6. **Use @Spy for partial mocks**: When you want to mock only specific methods

## Running Tests

```bash
mvn test
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

## Common Pitfalls

1. **Over-mocking**: Don't mock everything, only external dependencies
2. **Overspecification**: Don't over-verify interactions
3. **Ignoring test failures**: Address failing tests promptly
4. **Testing the mock**: Focus on testing the unit under test, not the mock
5. **Forgetting to reset mocks**: When using @Mock, they're reset automatically between tests
