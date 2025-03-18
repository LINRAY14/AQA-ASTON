import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestFactorial {
    @Test
    void testFactorial() {
        assertEquals(1, Factorial.factorial(0));
        assertEquals(1, Factorial.factorial(1));
        assertEquals(120, Factorial.factorial(5));
        assertEquals(3628800, Factorial.factorial(10));
        assertThrows(IllegalArgumentException.class, () -> Factorial.factorial(-1));
    }
}