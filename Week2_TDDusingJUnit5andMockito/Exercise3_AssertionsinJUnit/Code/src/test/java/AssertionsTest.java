import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {

    @Test
    public void testAssertions() {
        assertEquals(5, 2 + 3, "2 + 3 should equal 5");
        assertArrayEquals(new int[] { 1, 2 }, new int[] { 1, 2 });
        assertThrows(ArithmeticException.class, () -> {
            int x = 1 / 0;
        });
        assertAll(
                () -> assertTrue(10 > 5),
                () -> assertNotNull("JUnit"));

        assertTrue(5 > 3, "5 is greater than 3");

        assertFalse(5 < 3, "5 is not less than 3");

        assertNull(null, "Expected value to be null");

        assertNotNull(new Object(), "Expected non-null object");
    }
}
