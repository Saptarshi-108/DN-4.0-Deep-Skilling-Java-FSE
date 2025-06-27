import org.junit.jupiter.api.*;
import org.saptarshi.Calculator;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        System.out.println("✅ Setup complete");
    }

    @AfterEach
    void tearDown() {
        calculator.clearMemory();
        System.out.println("🧹 Teardown complete");
    }

    @Test
    void testAddition() {

        int result = calculator.add(2, 3);

        assertEquals(5, result, "2 + 3 should equal 5");
    }

    @Test
    void testMultiplication() {

        int result = calculator.multiply(4, 5);

        assertEquals(20, result, "4 * 5 should equal 20");
    }
}
