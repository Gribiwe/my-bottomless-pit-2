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
        testGetFibonacciTemplate(0, "0");
        testGetFibonacciTemplate(1, "1");
        testGetFibonacciTemplate(2, "1");
        testGetFibonacciTemplate(3, "2");
        testGetFibonacciTemplate(4, "3");
        testGetFibonacciTemplate(5, "5");
        testGetFibonacciTemplate(6, "8");
        testGetFibonacciTemplate(34, "5702887");
        testGetFibonacciTemplate(35, "9227465");

        //source - http://php.bubble.ro/fibonacci/
        testGetFibonacciTemplate(48, "4807526976");
        testGetFibonacciTemplate(49, "7778742049");
        testGetFibonacciTemplate(50, "12586269025");
        testGetFibonacciTemplate(51, "20365011074");
        testGetFibonacciTemplate(52, "32951280099");
        testGetFibonacciTemplate(53, "53316291173");
        testGetFibonacciTemplate(54, "86267571272");
        testGetFibonacciTemplate(55, "139583862445");
        testGetFibonacciTemplate(95, "31940434634990099905");
        testGetFibonacciTemplate(96, "51680708854858323072");
        testGetFibonacciTemplate(97, "83621143489848422977");
        testGetFibonacciTemplate(98, "135301852344706746049");
        testGetFibonacciTemplate(99, "218922995834555169026");
        testGetFibonacciTemplate(100, "354224848179261915075");
    }

    @Test
    public void testGetFibonacciWrongValues() {
        testGetFibonacciUnrealValuesTemplate(100001);
        testGetFibonacciUnrealValuesTemplate(100002);
        testGetFibonacciUnrealValuesTemplate(100003);
        testGetFibonacciUnrealValuesTemplate(Integer.MAX_VALUE);
        testGetFibonacciUnrealValuesTemplate(Long.MAX_VALUE);
        testGetFibonacciUnrealValuesTemplate(Integer.MIN_VALUE);
        testGetFibonacciUnrealValuesTemplate(Long.MIN_VALUE);
        testGetFibonacciUnrealValuesTemplate(-1);
        testGetFibonacciUnrealValuesTemplate(-2);
        testGetFibonacciUnrealValuesTemplate(-3);
    }

    private void testGetFibonacciTemplate(long n, String rightAnswer){
        assertEquals(testFib.getFibonacci(BigInteger.valueOf(n)), new BigInteger(rightAnswer));
    }

    private void testGetFibonacciUnrealValuesTemplate(long n){
        Assertions.assertThrows(GribiweException.class, () -> testFib.getFibonacci(BigInteger.valueOf(n)));
    }
}
