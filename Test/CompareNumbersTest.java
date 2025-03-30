import org.testng.Assert;
import org.testng.annotations.Test;

public class CompareNumbersTest {

    @Test
    public void testCompareNumbers() {
        Assert.assertEquals(CompareNumbers.compare(5, 5), "Числа равны");
        Assert.assertEquals(CompareNumbers.compare(10, 5), "Первое число больше");
        Assert.assertEquals(CompareNumbers.compare(3, 8), "Второе число больше");
    }
}