import gcd.GCDFinder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GCDFinderTest extends Assert {

    private static GCDFinder testGCD;

    @Before
    public void runGCDFinder() {
        testGCD = GCDFinder.getInstance();
    }

    @Test
    public void testGCD() {

        // CHECKING WITH 25 AND 1
        assertEquals(testGCD.gcd(25, 25, 25, 25), 25);
        assertEquals(testGCD.gcd(1, 25, 25, 25), 1);
        assertEquals(testGCD.gcd(25, 1, 25, 25), 1);
        assertEquals(testGCD.gcd(25, 25, 1, 25), 1);
        assertEquals(testGCD.gcd(25, 25, 25, 1), 1);
        assertEquals(testGCD.gcd(1, 1, 1, 1), 1);
        assertEquals(testGCD.gcd(25, 1, 1, 1), 1);
        assertEquals(testGCD.gcd(1, 25, 1, 1), 1);
        assertEquals(testGCD.gcd(1, 1, 25, 1), 1);
        assertEquals(testGCD.gcd(1, 1, 1, 25), 1);

        // negative values
        assertEquals(testGCD.gcd(-25, -25, -25, -25), 25);
        assertEquals(testGCD.gcd(-1, -25, -25, -25), 1);
        assertEquals(testGCD.gcd(-25, -1, -25, -25), 1);
        assertEquals(testGCD.gcd(-25, -25, -1, -25), 1);
        assertEquals(testGCD.gcd(-25, -25, -25, -1), 1);
        assertEquals(testGCD.gcd(-1, -1, -1, -1), 1);
        assertEquals(testGCD.gcd(-25, -1, -1, -1), 1);
        assertEquals(testGCD.gcd(-1, -25, -1, -1), 1);
        assertEquals(testGCD.gcd(-1, -1, -25, -1), 1);
        assertEquals(testGCD.gcd(-1, -1, -1, -25), 1);

        // half-negative values
        assertEquals(testGCD.gcd(-25, 25, 25, -25), 25);
        assertEquals(testGCD.gcd(-1, 25, 25, -25), 1);
        assertEquals(testGCD.gcd(-25, 1, 25, -25), 1);
        assertEquals(testGCD.gcd(-25, 25, 1, -25), 1);
        assertEquals(testGCD.gcd(-25, 25, 25, -1), 1);
        assertEquals(testGCD.gcd(-1, 1, 1, -1), 1);
        assertEquals(testGCD.gcd(-25, 1, 1, -1), 1);
        assertEquals(testGCD.gcd(-1, 25, 1, -1), 1);
        assertEquals(testGCD.gcd(-1, 1, 25, -1), 1);
        assertEquals(testGCD.gcd(-1, 1, 1, -25), 1);

        // CHECKING WITH 25 AND 10
        assertEquals(testGCD.gcd(25, 25, 25, 25), 25);
        assertEquals(testGCD.gcd(10, 25, 25, 25), 5);
        assertEquals(testGCD.gcd(25, 10, 25, 25), 5);
        assertEquals(testGCD.gcd(25, 25, 10, 25), 5);
        assertEquals(testGCD.gcd(25, 25, 25, 10), 5);
        assertEquals(testGCD.gcd(10, 10, 10, 10), 10);
        assertEquals(testGCD.gcd(25, 10, 10, 10), 5);
        assertEquals(testGCD.gcd(10, 25, 10, 10), 5);
        assertEquals(testGCD.gcd(10, 10, 25, 10), 5);
        assertEquals(testGCD.gcd(10, 10, 10, 25), 5);

        // negative values
        assertEquals(testGCD.gcd(-25, -25, -25, -25), 25);
        assertEquals(testGCD.gcd(-10, -25, -25, -25), 5);
        assertEquals(testGCD.gcd(-25, -10, -25, -25), 5);
        assertEquals(testGCD.gcd(-25, -25, -10, -25), 5);
        assertEquals(testGCD.gcd(-25, -25, -25, -10), 5);
        assertEquals(testGCD.gcd(-10, -10, -10, -10), 10);
        assertEquals(testGCD.gcd(-25, -10, -10, -10), 5);
        assertEquals(testGCD.gcd(-10, -25, -10, -10), 5);
        assertEquals(testGCD.gcd(-10, -10, -25, -10), 5);
        assertEquals(testGCD.gcd(-10, -10, -10, -25), 5);

        // half-negative values
        assertEquals(testGCD.gcd(-25, 25, 25, -25), 25);
        assertEquals(testGCD.gcd(-10, 25, 25, -25), 5);
        assertEquals(testGCD.gcd(-25, 10, 25, -25), 5);
        assertEquals(testGCD.gcd(-25, 25, 10, -25), 5);
        assertEquals(testGCD.gcd(-25, 25, 25, -10), 5);
        assertEquals(testGCD.gcd(-10, 10, 10, -10), 10);
        assertEquals(testGCD.gcd(-25, 10, 10, -10), 5);
        assertEquals(testGCD.gcd(-10, 25, 10, -10), 5);
        assertEquals(testGCD.gcd(-10, 10, 25, -10), 5);
        assertEquals(testGCD.gcd(-10, 10, 10, -25), 5);

        // CHECKING WITH 146 AND 154
        assertEquals(testGCD.gcd(146, 146, 146, 146), 146);
        assertEquals(testGCD.gcd(154, 146, 146, 146), 2);
        assertEquals(testGCD.gcd(146, 154, 146, 146), 2);
        assertEquals(testGCD.gcd(146, 146, 154, 146), 2);
        assertEquals(testGCD.gcd(146, 146, 146, 154), 2);
        assertEquals(testGCD.gcd(154, 154, 154, 154), 154);
        assertEquals(testGCD.gcd(146, 154, 154, 154), 2);
        assertEquals(testGCD.gcd(154, 146, 154, 154), 2);
        assertEquals(testGCD.gcd(154, 154, 146, 154), 2);
        assertEquals(testGCD.gcd(154, 154, 154, 146), 2);

        // negative values
        assertEquals(testGCD.gcd(-146, -146, -146, -146), 146);
        assertEquals(testGCD.gcd(-154, -146, -146, -146), 2);
        assertEquals(testGCD.gcd(-146, -154, -146, -146), 2);
        assertEquals(testGCD.gcd(-146, -146, -154, -146), 2);
        assertEquals(testGCD.gcd(-146, -146, -146, -154), 2);
        assertEquals(testGCD.gcd(-154, -154, -154, -154), 154);
        assertEquals(testGCD.gcd(-146, -154, -154, -154), 2);
        assertEquals(testGCD.gcd(-154, -146, -154, -154), 2);
        assertEquals(testGCD.gcd(-154, -154, -146, -154), 2);
        assertEquals(testGCD.gcd(-154, -154, -154, -146), 2);

        // half-negative values
        assertEquals(testGCD.gcd(-146, 146, 146, -146), 146);
        assertEquals(testGCD.gcd(-154, 146, 146, -146), 2);
        assertEquals(testGCD.gcd(-146, 154, 146, -146), 2);
        assertEquals(testGCD.gcd(-146, 146, 154, -146), 2);
        assertEquals(testGCD.gcd(-146, 146, 146, -154), 2);
        assertEquals(testGCD.gcd(-154, 154, 154, -154), 154);
        assertEquals(testGCD.gcd(-146, 154, 154, -154), 2);
        assertEquals(testGCD.gcd(-154, 146, 154, -154), 2);
        assertEquals(testGCD.gcd(-154, 154, 146, -154), 2);
        assertEquals(testGCD.gcd(-154, 154, 154, -146), 2);

        // CHECKING WITH 146, 154, and 10
        assertEquals(testGCD.gcd(146, 146, 146, 146), 146);
        assertEquals(testGCD.gcd(146, 10, 146, 146), 2);
        assertEquals(testGCD.gcd(10, 10, 10, 10), 10);
        assertEquals(testGCD.gcd(10, 10, 146, 10), 2);
        assertEquals(testGCD.gcd(10, 10, 154, 10), 2);
        assertEquals(testGCD.gcd(154, 10, 146, 146), 2);
        assertEquals(testGCD.gcd(146, 154, 10, 146), 2);
        assertEquals(testGCD.gcd(146, 146, 154, 10), 2);
        assertEquals(testGCD.gcd(10, 146, 146, 154), 2);
        assertEquals(testGCD.gcd(154, 154, 154, 154), 154);
        assertEquals(testGCD.gcd(154, 154, 10, 154), 2);
        assertEquals(testGCD.gcd(146, 10, 154, 154), 2);
        assertEquals(testGCD.gcd(154, 146, 10, 154), 2);
        assertEquals(testGCD.gcd(154, 154, 146, 10), 2);
        assertEquals(testGCD.gcd(10, 154, 154, 146), 2);

        // negative values
        assertEquals(testGCD.gcd(-146, -146, -146, -146), 146);
        assertEquals(testGCD.gcd(-146, -10, -146, -146), 2);
        assertEquals(testGCD.gcd(-10, -10, -10, -10), 10);
        assertEquals(testGCD.gcd(-10, -10, -146, -10), 2);
        assertEquals(testGCD.gcd(-10, -10, -154, -10), 2);
        assertEquals(testGCD.gcd(-154, -10, -146, -146), 2);
        assertEquals(testGCD.gcd(-146, -154, -10, -146), 2);
        assertEquals(testGCD.gcd(-146, -146, -154, -10), 2);
        assertEquals(testGCD.gcd(-10, -146, -146, -154), 2);
        assertEquals(testGCD.gcd(-154, -154, -154, -154), 154);
        assertEquals(testGCD.gcd(-154, -10, -154, -154), 2);
        assertEquals(testGCD.gcd(-146, -10, -154, -154), 2);
        assertEquals(testGCD.gcd(-154, -146, -10, -154), 2);
        assertEquals(testGCD.gcd(-154, -154, -146, -10), 2);
        assertEquals(testGCD.gcd(-10, -154, -154, -146), 2);

        // half-negative values
        assertEquals(testGCD.gcd(-146, 146, 146, -146), 146);
        assertEquals(testGCD.gcd(-146, 10, 146, -146), 2);
        assertEquals(testGCD.gcd(-10, 10, 10, -10), 10);
        assertEquals(testGCD.gcd(-10, 10, 146, -10), 2);
        assertEquals(testGCD.gcd(-10, 10, 154, -10), 2);
        assertEquals(testGCD.gcd(-154, 10, 146, -146), 2);
        assertEquals(testGCD.gcd(-146, 154, 10, -146), 2);
        assertEquals(testGCD.gcd(-146, 146, 154, -10), 2);
        assertEquals(testGCD.gcd(-10, 146, 146, -154), 2);
        assertEquals(testGCD.gcd(-154, 154, 154, -154), 154);
        assertEquals(testGCD.gcd(-154, 10, 154, -154), 2);
        assertEquals(testGCD.gcd(-146, 10, 154, -154), 2);
        assertEquals(testGCD.gcd(-154, 146, 10, -154), 2);
        assertEquals(testGCD.gcd(-154, 154, 146, -10), 2);
        assertEquals(testGCD.gcd(-10, 154, 154, -146), 2);

        // CHECKING WITH 146, 154, 88, and 10
        assertEquals(testGCD.gcd(146, 146, 146, 146), 146);
        assertEquals(testGCD.gcd(146, 10, 146, 146), 2);
        assertEquals(testGCD.gcd(10, 10, 10, 10), 10);
        assertEquals(testGCD.gcd(88, 88, 88, 88), 88);
        assertEquals(testGCD.gcd(10, 88, 146, 10), 2);
        assertEquals(testGCD.gcd(10, 88, 154, 10), 2);
        assertEquals(testGCD.gcd(154, 10, 146, 88), 2);
        assertEquals(testGCD.gcd(146, 154, 10, 88), 2);
        assertEquals(testGCD.gcd(146, 88, 154, 10), 2);
        assertEquals(testGCD.gcd(10, 146, 88, 154), 2);
        assertEquals(testGCD.gcd(154, 154, 154, 154), 154);
        assertEquals(testGCD.gcd(154, 88, 154, 154), 22);
        assertEquals(testGCD.gcd(88, 154, 10, 154), 2);
        assertEquals(testGCD.gcd(146, 10, 88, 154), 2);
        assertEquals(testGCD.gcd(88, 146, 10, 154), 2);
        assertEquals(testGCD.gcd(154, 88, 146, 10), 2);
        assertEquals(testGCD.gcd(10, 154, 88, 146), 2);

        // negative values
        assertEquals(testGCD.gcd(-146, -146, -146, -146), 146);
        assertEquals(testGCD.gcd(-146, -10, -146, -146), 2);
        assertEquals(testGCD.gcd(-10, -10, -10, -10), 10);
        assertEquals(testGCD.gcd(-88, -88, -88, -88), 88);
        assertEquals(testGCD.gcd(-10, -88, -146, -10), 2);
        assertEquals(testGCD.gcd(-10, -88, -154, -10), 2);
        assertEquals(testGCD.gcd(-154, -10, -146, -88), 2);
        assertEquals(testGCD.gcd(-146, -154, -10, -88), 2);
        assertEquals(testGCD.gcd(-146, -88, -154, -10), 2);
        assertEquals(testGCD.gcd(-10, -146, -88, -154), 2);
        assertEquals(testGCD.gcd(-154, -154, -154, -154), 154);
        assertEquals(testGCD.gcd(-154, -88, -154, -154), 22);
        assertEquals(testGCD.gcd(-88, -154, -10, -154), 2);
        assertEquals(testGCD.gcd(-146, -10, -88, -154), 2);
        assertEquals(testGCD.gcd(-88, -146, -10, -154), 2);
        assertEquals(testGCD.gcd(-154, -88, -146, -10), 2);
        assertEquals(testGCD.gcd(-10, -154, -88, -146), 2);

        // half-negative values
        assertEquals(testGCD.gcd(-146, 146, 146, -146), 146);
        assertEquals(testGCD.gcd(-146, 10, 146, -146), 2);
        assertEquals(testGCD.gcd(-10, 10, 10, -10), 10);
        assertEquals(testGCD.gcd(-88, 88, 88, -88), 88);
        assertEquals(testGCD.gcd(-10, 88, 146, -10), 2);
        assertEquals(testGCD.gcd(-10, 88, 154, -10), 2);
        assertEquals(testGCD.gcd(-154, 10, 146, -88), 2);
        assertEquals(testGCD.gcd(-146, 154, 10, -88), 2);
        assertEquals(testGCD.gcd(-146, 88, 154, -10), 2);
        assertEquals(testGCD.gcd(-10, 146, 88, -154), 2);
        assertEquals(testGCD.gcd(-154, 154, 154, -154), 154);
        assertEquals(testGCD.gcd(-154, 88, 154, -154), 22);
        assertEquals(testGCD.gcd(-88, 154, 10, -154), 2);
        assertEquals(testGCD.gcd(-146, 10, 88, -154), 2);
        assertEquals(testGCD.gcd(-88, 146, 10, -154), 2);
        assertEquals(testGCD.gcd(-154, 88, 146, -10), 2);
        assertEquals(testGCD.gcd(-10, 154, 88, -146), 2);


        assertEquals(testGCD.gcd(1, 1, 1, 1), 1);
        assertEquals(testGCD.gcd(-1, -1, -1, -1), 1);
        assertEquals(testGCD.gcd(Long.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE), Long.MAX_VALUE);
        assertEquals(testGCD.gcd(Long.MAX_VALUE, Long.MAX_VALUE, 1, Long.MAX_VALUE), 1);
        assertEquals(testGCD.gcd(Long.MIN_VALUE, Long.MIN_VALUE, Long.MIN_VALUE, Long.MIN_VALUE), Long.MIN_VALUE);
        assertEquals(testGCD.gcd(Long.MIN_VALUE, Long.MIN_VALUE, 1, Long.MIN_VALUE), 1);
        assertEquals(testGCD.gcd(1, 1, 1, Long.MAX_VALUE), 1);
        assertEquals(testGCD.gcd(1, 1, 1, Long.MIN_VALUE), 1);
        assertEquals(testGCD.gcd(1, 1, Long.MAX_VALUE, 1), 1);
        assertEquals(testGCD.gcd(1, Long.MAX_VALUE, 1, 1), 1);

        assertEquals(testGCD.gcd(15, 10, 0, 15), 5);
        assertEquals(testGCD.gcd(0, 0, 0, 0), 0);
    }

}
