import org.testng.Assert;
import org.testng.annotations.Test;

public class ArithmeticOperationsTest {

    @Test
    public void testAddition() {
        Assert.assertEquals(ArithmeticOperations.add(2, 3), 5);
        Assert.assertEquals(ArithmeticOperations.add(-1, 4), 3);
    }

    @Test
    public void testSubtraction() {
        Assert.assertEquals(ArithmeticOperations.subtract(10, 3), 7);
        Assert.assertEquals(ArithmeticOperations.subtract(5, 10), -5);
    }

    @Test
    public void testMultiplication() {
        Assert.assertEquals(ArithmeticOperations.multiply(4, 5), 20);
        Assert.assertEquals(ArithmeticOperations.multiply(0, 100), 0);
    }

    @Test
    public void testDivision() {
        Assert.assertEquals(ArithmeticOperations.divide(10, 2), 5.0);
        Assert.assertEquals(ArithmeticOperations.divide(9, 3), 3.0);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivisionByZero() {
        ArithmeticOperations.divide(5, 0);
    }
}