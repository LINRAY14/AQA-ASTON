import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestArithmeticOperations {
    @Test
    public void testArithmeticOperations() {
        assertEquals(3, ArithmeticOperations.add(1,2));
        assertEquals(1, ArithmeticOperations.subtract(2,1));
        assertEquals(4, ArithmeticOperations.multiply(2,2));
        assertEquals(2, ArithmeticOperations.divide(4,2));
        assertThrows(ArithmeticException.class, () -> ArithmeticOperations.divide(5, 0));
    }
}
