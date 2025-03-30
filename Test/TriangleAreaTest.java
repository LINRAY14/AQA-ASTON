import org.testng.Assert;
import org.testng.annotations.Test;

public class TriangleAreaTest {

    @Test
    public void testTriangleAreaValid() {
        Assert.assertEquals(TriangleArea.triangleArea(3, 4, 5), 6.0);
        Assert.assertEquals(TriangleArea.triangleArea(10, 10, 10), 43.301, 0.001);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidTriangle() {
        TriangleArea.triangleArea(1, 2, 10);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testDegenerateTriangle() {
        TriangleArea.triangleArea(5, 5, 10);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNegativeSides() {
        TriangleArea.triangleArea(-3, 4, 5);
    }

    }

