import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestTriangleArea {
    @Test
    void testTriangleArea() {
        assertEquals(24, TriangleArea.triangleArea(6, 8, 10));
        assertEquals(43.301, TriangleArea.triangleArea(10, 10, 10), 0.001);
        assertEquals(24.206, TriangleArea.triangleArea(10, 10, 5), 0.001);
        assertThrows(IllegalArgumentException.class, () -> TriangleArea.triangleArea(-3, 4, 5));
        assertThrows(IllegalArgumentException.class, () -> TriangleArea.triangleArea(5, 5, 10));
    }
}