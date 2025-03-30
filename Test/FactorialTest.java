import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialTest {

    @Test
    public void testFactorial() {
        Assert.assertEquals(Factorial.factorial(0), 1);
        Assert.assertEquals(Factorial.factorial(1), 1);
        Assert.assertEquals(Factorial.factorial(5), 120);
        Assert.assertEquals(Factorial.factorial(10), 3_628_800);
        Assert.assertEquals(Factorial.factorial(20), 2_432_902_008_176_640_000L);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegative() {
        Factorial.factorial(-1);
    }

    }
