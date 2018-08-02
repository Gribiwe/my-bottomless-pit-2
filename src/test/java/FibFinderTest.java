import exception.GribiweException;
import fibbo.FibFinder;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.math.BigInteger;

public class FibFinderTest extends Assert{

    private static FibFinder testFib;

    @BeforeClass
    public static void runFibFinder() {
        testFib = new FibFinder();
    }

    @Test
    public void testGetFibonacci() {

        //source - https://oeis.org/A000045
        testGetFibonacci(0, "0");
        testGetFibonacci(1, "1");
        testGetFibonacci(2, "1");
        testGetFibonacci(3, "2");
        testGetFibonacci(4, "3");
        testGetFibonacci(5, "5");
        testGetFibonacci(6, "8");
        testGetFibonacci(34, "5702887");
        testGetFibonacci(35, "9227465");

        //source - http://php.bubble.ro/fibonacci/
        testGetFibonacci(48, "4807526976");
        testGetFibonacci(49, "7778742049");
        testGetFibonacci(50, "12586269025");
        testGetFibonacci(51, "20365011074");
        testGetFibonacci(52, "32951280099");
        testGetFibonacci(53, "53316291173");
        testGetFibonacci(54, "86267571272");
        testGetFibonacci(55, "139583862445");
        testGetFibonacci(95, "31940434634990099905");
        testGetFibonacci(96, "51680708854858323072");
        testGetFibonacci(97, "83621143489848422977");
        testGetFibonacci(98, "135301852344706746049");
        testGetFibonacci(99, "218922995834555169026");
        testGetFibonacci(100, "354224848179261915075");
    }

    @Test
    public void testGetFibonacciWrongValues() {

        testGetFibonacciUnrealValues(100001);
        testGetFibonacciUnrealValues(100002);
        testGetFibonacciUnrealValues(100003);
        testGetFibonacciUnrealValues(Integer.MAX_VALUE);
        testGetFibonacciUnrealValues(Long.MAX_VALUE);
        testGetFibonacciUnrealValues(Integer.MIN_VALUE);
        testGetFibonacciUnrealValues(Long.MIN_VALUE);
        testGetFibonacciUnrealValues(-1);
        testGetFibonacciUnrealValues(-2);
        testGetFibonacciUnrealValues(-3);
    }

    private void testGetFibonacci(long n, String rightAnswer){
        assertEquals(testFib.getFibonacci(BigInteger.valueOf(n)), new BigInteger(rightAnswer));
    }

    private void testGetFibonacciUnrealValues(long n){
        Assertions.assertThrows(GribiweException.class, () -> testFib.getFibonacci(BigInteger.valueOf(n)));
    }
}
