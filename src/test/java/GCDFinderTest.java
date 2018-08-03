import exception.GribiweException;
import gcd.GCDFinder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.math.BigInteger;

public class GCDFinderTest extends Assert {

   private static GCDFinder testGCD;

   @Before
   public void runGCDFinder() {
      testGCD = new GCDFinder();
   }

   private void testGCD(long a, long b, long c, long d, long realAnswer) {
      assertEquals(testGCD.gcd(BigInteger.valueOf(a), BigInteger.valueOf(b),
              BigInteger.valueOf(c), BigInteger.valueOf(d)), BigInteger.valueOf(realAnswer));
   }

   @Test
   public void testGCDWrongValues() {
      Assertions.assertThrows(GribiweException.class, () -> testGCD.gcd(null, BigInteger.ONE, BigInteger.ONE, BigInteger.ONE));
      Assertions.assertThrows(GribiweException.class, () -> testGCD.gcd(BigInteger.ONE, null, BigInteger.ONE, BigInteger.ONE));
      Assertions.assertThrows(GribiweException.class, () -> testGCD.gcd(BigInteger.ONE, BigInteger.ONE, null, BigInteger.ONE));
      Assertions.assertThrows(GribiweException.class, () -> testGCD.gcd(BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, null));

      Assertions.assertThrows(GribiweException.class,
              () -> testGCD.gcd(BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO));
   }

   @Test
   public void testGCD() {

      // simple numbers
      testGCD(7, 7, 7, 7, 7);
      testGCD(3, 3, 3, 3, 3);
      testGCD(7, 3, 7, 3, 1);
      testGCD(3, 7, 3, 7, 1);
      testGCD(23, 13, 3, 7, 1);
      testGCD(19, 17, 3, 7, 1);

      // simple to other numbers
      testGCD(7, 6, 4, 2, 1);
      testGCD(3, 7, 8, 40, 1);
      testGCD(17, 19, 7, 3, 1);
      testGCD(22, 16, 9, 7, 1);
      testGCD(6, 8, 9, 16, 1);


      // CHECKING WITH 25 AND 1
      testGCD(25, 25, 25, 25, 25);
      testGCD(1, 25, 25, 25, 1);
      testGCD(25, 1, 25, 25, 1);
      testGCD(25, 25, 1, 25, 1);
      testGCD(25, 25, 25, 1, 1);
      testGCD(1, 1, 1, 1, 1);
      testGCD(25, 1, 1, 1, 1);
      testGCD(1, 25, 1, 1, 1);
      testGCD(1, 1, 25, 1, 1);
      testGCD(1, 1, 1, 25, 1);

      // negative values
      testGCD(-25, -25, -25, -25, 25);
      testGCD(-1, -25, -25, -25, 1);
      testGCD(-25, -1, -25, -25, 1);
      testGCD(-25, -25, -1, -25, 1);
      testGCD(-25, -25, -25, -1, 1);
      testGCD(-1, -1, -1, -1, 1);
      testGCD(-25, -1, -1, -1, 1);
      testGCD(-1, -25, -1, -1, 1);
      testGCD(-1, -1, -25, -1, 1);
      testGCD(-1, -1, -1, -25, 1);

      // half-negative values
      testGCD(-25, 25, 25, -25, 25);
      testGCD(-1, 25, 25, -25, 1);
      testGCD(-25, 1, 25, -25, 1);
      testGCD(-25, 25, 1, -25, 1);
      testGCD(-25, 25, 25, -1, 1);
      testGCD(-1, 1, 1, -1, 1);
      testGCD(-25, 1, 1, -1, 1);
      testGCD(-1, 25, 1, -1, 1);
      testGCD(-1, 1, 25, -1, 1);
      testGCD(-1, 1, 1, -25, 1);

      // CHECKING WITH 25 AND 10
      testGCD(25, 25, 25, 25, 25);
      testGCD(10, 25, 25, 25, 5);
      testGCD(25, 10, 25, 25, 5);
      testGCD(25, 25, 10, 25, 5);
      testGCD(25, 25, 25, 10, 5);
      testGCD(10, 10, 10, 10, 10);
      testGCD(25, 10, 10, 10, 5);
      testGCD(10, 25, 10, 10, 5);
      testGCD(10, 10, 25, 10, 5);
      testGCD(10, 10, 10, 25, 5);

      // negative values
      testGCD(-25, -25, -25, -25, 25);
      testGCD(-10, -25, -25, -25, 5);
      testGCD(-25, -10, -25, -25, 5);
      testGCD(-25, -25, -10, -25, 5);
      testGCD(-25, -25, -25, -10, 5);
      testGCD(-10, -10, -10, -10, 10);
      testGCD(-25, -10, -10, -10, 5);
      testGCD(-10, -25, -10, -10, 5);
      testGCD(-10, -10, -25, -10, 5);
      testGCD(-10, -10, -10, -25, 5);

      // half-negative values
      testGCD(-25, 25, 25, -25, 25);
      testGCD(-10, 25, 25, -25, 5);
      testGCD(-25, 10, 25, -25, 5);
      testGCD(-25, 25, 10, -25, 5);
      testGCD(-25, 25, 25, -10, 5);
      testGCD(-10, 10, 10, -10, 10);
      testGCD(-25, 10, 10, -10, 5);
      testGCD(-10, 25, 10, -10, 5);
      testGCD(-10, 10, 25, -10, 5);
      testGCD(-10, 10, 10, -25, 5);

      // CHECKING WITH 146 AND 154
      testGCD(146, 146, 146, 146, 146);
      testGCD(154, 146, 146, 146, 2);
      testGCD(146, 154, 146, 146, 2);
      testGCD(146, 146, 154, 146, 2);
      testGCD(146, 146, 146, 154, 2);
      testGCD(154, 154, 154, 154, 154);
      testGCD(146, 154, 154, 154, 2);
      testGCD(154, 146, 154, 154, 2);
      testGCD(154, 154, 146, 154, 2);
      testGCD(154, 154, 154, 146, 2);

      // negative values
      testGCD(-146, -146, -146, -146, 146);
      testGCD(-154, -146, -146, -146, 2);
      testGCD(-146, -154, -146, -146, 2);
      testGCD(-146, -146, -154, -146, 2);
      testGCD(-146, -146, -146, -154, 2);
      testGCD(-154, -154, -154, -154, 154);
      testGCD(-146, -154, -154, -154, 2);
      testGCD(-154, -146, -154, -154, 2);
      testGCD(-154, -154, -146, -154, 2);
      testGCD(-154, -154, -154, -146, 2);

      // half-negative values
      testGCD(-146, 146, 146, -146, 146);
      testGCD(-154, 146, 146, -146, 2);
      testGCD(-146, 154, 146, -146, 2);
      testGCD(-146, 146, 154, -146, 2);
      testGCD(-146, 146, 146, -154, 2);
      testGCD(-154, 154, 154, -154, 154);
      testGCD(-146, 154, 154, -154, 2);
      testGCD(-154, 146, 154, -154, 2);
      testGCD(-154, 154, 146, -154, 2);
      testGCD(-154, 154, 154, -146, 2);

      // CHECKING WITH 146, 154, and 10
      testGCD(146, 146, 146, 146, 146);
      testGCD(146, 10, 146, 146, 2);
      testGCD(10, 10, 10, 10, 10);
      testGCD(10, 10, 146, 10, 2);
      testGCD(10, 10, 154, 10, 2);
      testGCD(154, 10, 146, 146, 2);
      testGCD(146, 154, 10, 146, 2);
      testGCD(146, 146, 154, 10, 2);
      testGCD(10, 146, 146, 154, 2);
      testGCD(154, 154, 154, 154, 154);
      testGCD(154, 154, 10, 154, 2);
      testGCD(146, 10, 154, 154, 2);
      testGCD(154, 146, 10, 154, 2);
      testGCD(154, 154, 146, 10, 2);
      testGCD(10, 154, 154, 146, 2);

      // negative values
      testGCD(-146, -146, -146, -146, 146);
      testGCD(-146, -10, -146, -146, 2);
      testGCD(-10, -10, -10, -10, 10);
      testGCD(-10, -10, -146, -10, 2);
      testGCD(-10, -10, -154, -10, 2);
      testGCD(-154, -10, -146, -146, 2);
      testGCD(-146, -154, -10, -146, 2);
      testGCD(-146, -146, -154, -10, 2);
      testGCD(-10, -146, -146, -154, 2);
      testGCD(-154, -154, -154, -154, 154);
      testGCD(-154, -10, -154, -154, 2);
      testGCD(-146, -10, -154, -154, 2);
      testGCD(-154, -146, -10, -154, 2);
      testGCD(-154, -154, -146, -10, 2);
      testGCD(-10, -154, -154, -146, 2);

      // half-negative values
      testGCD(-146, 146, 146, -146, 146);
      testGCD(-146, 10, 146, -146, 2);
      testGCD(-10, 10, 10, -10, 10);
      testGCD(-10, 10, 146, -10, 2);
      testGCD(-10, 10, 154, -10, 2);
      testGCD(-154, 10, 146, -146, 2);
      testGCD(-146, 154, 10, -146, 2);
      testGCD(-146, 146, 154, -10, 2);
      testGCD(-10, 146, 146, -154, 2);
      testGCD(-154, 154, 154, -154, 154);
      testGCD(-154, 10, 154, -154, 2);
      testGCD(-146, 10, 154, -154, 2);
      testGCD(-154, 146, 10, -154, 2);
      testGCD(-154, 154, 146, -10, 2);
      testGCD(-10, 154, 154, -146, 2);

      // CHECKING WITH 146, 154, 88, and 10
      testGCD(146, 146, 146, 146, 146);
      testGCD(146, 10, 146, 146, 2);
      testGCD(10, 10, 10, 10, 10);
      testGCD(88, 88, 88, 88, 88);
      testGCD(10, 88, 146, 10, 2);
      testGCD(10, 88, 154, 10, 2);
      testGCD(154, 10, 146, 88, 2);
      testGCD(146, 154, 10, 88, 2);
      testGCD(146, 88, 154, 10, 2);
      testGCD(10, 146, 88, 154, 2);
      testGCD(154, 154, 154, 154, 154);
      testGCD(154, 88, 154, 154, 22);
      testGCD(88, 154, 10, 154, 2);
      testGCD(146, 10, 88, 154, 2);
      testGCD(88, 146, 10, 154, 2);
      testGCD(154, 88, 146, 10, 2);
      testGCD(10, 154, 88, 146, 2);

      // negative values
      testGCD(-146, -146, -146, -146, 146);
      testGCD(-146, -10, -146, -146, 2);
      testGCD(-10, -10, -10, -10, 10);
      testGCD(-88, -88, -88, -88, 88);
      testGCD(-10, -88, -146, -10, 2);
      testGCD(-10, -88, -154, -10, 2);
      testGCD(-154, -10, -146, -88, 2);
      testGCD(-146, -154, -10, -88, 2);
      testGCD(-146, -88, -154, -10, 2);
      testGCD(-10, -146, -88, -154, 2);
      testGCD(-154, -154, -154, -154, 154);
      testGCD(-154, -88, -154, -154, 22);
      testGCD(-88, -154, -10, -154, 2);
      testGCD(-146, -10, -88, -154, 2);
      testGCD(-88, -146, -10, -154, 2);
      testGCD(-154, -88, -146, -10, 2);
      testGCD(-10, -154, -88, -146, 2);

      // half-negative values
      testGCD(-146, 146, 146, -146, 146);
      testGCD(-146, 10, 146, -146, 2);
      testGCD(-10, 10, 10, -10, 10);
      testGCD(-88, 88, 88, -88, 88);
      testGCD(-10, 88, 146, -10, 2);
      testGCD(-10, 88, 154, -10, 2);
      testGCD(-154, 10, 146, -88, 2);
      testGCD(-146, 154, 10, -88, 2);
      testGCD(-146, 88, 154, -10, 2);
      testGCD(-10, 146, 88, -154, 2);
      testGCD(-154, 154, 154, -154, 154);
      testGCD(-154, 88, 154, -154, 22);
      testGCD(-88, 154, 10, -154, 2);
      testGCD(-146, 10, 88, -154, 2);
      testGCD(-88, 146, 10, -154, 2);
      testGCD(-154, 88, 146, -10, 2);
      testGCD(-10, 154, 88, -146, 2);


      testGCD(1, 1, 1, 1, 1);
      testGCD(-1, -1, -1, -1, 1);
      testGCD(Long.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE);
      testGCD(Long.MAX_VALUE, Long.MAX_VALUE, 1, Long.MAX_VALUE, 1);
      testGCD(Long.MIN_VALUE, Long.MIN_VALUE, 1, Long.MIN_VALUE, 1);
      testGCD(1, 1, 1, Long.MAX_VALUE, 1);
      testGCD(1, 1, 1, Long.MIN_VALUE, 1);
      testGCD(1, 1, Long.MAX_VALUE, 1, 1);
      testGCD(1, Long.MAX_VALUE, 1, 1, 1);

      testGCD(15, 10, 0, 15, 5);

   }

}
