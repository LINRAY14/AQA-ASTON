import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestCompareNumbers {
    @Test
    void testCompare() {
        assertEquals("5 больше 3", CompareNumbers.compare(5, 3));
        assertEquals("3 меньше 5", CompareNumbers.compare(3, 5));
        assertEquals("4 равно 4", CompareNumbers.compare(4, 4));
    }
}