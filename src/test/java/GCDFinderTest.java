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

   @Test
   public void testGCDWrongValuesAndNull() {
      testGCDWrongValues(null, BigInteger.ONE, BigInteger.ONE, BigInteger.ONE);
      testGCDWrongValues(BigInteger.ONE, null, BigInteger.ONE, BigInteger.ONE);
      testGCDWrongValues(BigInteger.ONE, BigInteger.ONE, null, BigInteger.ONE);
      testGCDWrongValues(BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, null);

      testGCDWrongValues(BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO);
   }

   @Test
   public void testGCD() {

      // source 1 - paper
      // source 2 - https://ru.onlinemschool.com/math/assistance/number_theory/nod_nok/
      // source 3 - https://planetcalc.ru/323/
      // source 4 - https://planetcalc.ru/3298/

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
      testGCD(5, 6, 124, 9, 1);

      // number which delivers to 2 up to they can't
      testGCD(26, 40, 32, 12, 2);
      testGCD(26, 20, 16, 6, 2);
      testGCD(13, 10, 8, 3, 1);
      testGCD(13, 5, 4, 3, 1);
      testGCD(13, 5, 2, 3, 1);

      // all numbers % 2 = 0
      testGCD(16, 2, 4, 6, 2);
      testGCD(160, 12, 14, 16, 2);
      testGCD(8, 16, 14, 4, 2);
      testGCD(8, 16, 32, 4, 4);

      // all numbers % 2 = 1
      testGCD(13, 3, 7, 19, 1);
      testGCD(19, 9, 17, 35, 1);
      testGCD(7, 35, 83, 41, 1);
      testGCD(15, 33, 71, 37, 1);

      // n * 10 values
      testGCD(40, 30, 20, 50, 10);
      testGCD(100, 50, 30, 10, 10);
      testGCD(130, 60, 50, 20, 10);
      testGCD(20, 20, 40, 60, 20);

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

      BigInteger longMaxPlusOne = BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.ONE);

      testGCD(longMaxPlusOne, longMaxPlusOne, longMaxPlusOne, longMaxPlusOne, longMaxPlusOne);

      testGCD(15, 10, 0, 15, 5);

   }

   private void testGCD(long a, long b, long c, long d, long realAnswer) {
      assertEquals(BigInteger.valueOf(realAnswer), testGCD.gcd(BigInteger.valueOf(a), BigInteger.valueOf(b),
              BigInteger.valueOf(c), BigInteger.valueOf(d)));
   }

   private void testGCD(BigInteger a, BigInteger b, BigInteger c, BigInteger d, BigInteger realAnswer) {
      assertEquals(testGCD.gcd(a, b, c, d), realAnswer);
   }

   private void testGCDWrongValues(BigInteger a, BigInteger b, BigInteger c, BigInteger d) {
      Assertions.assertThrows(GribiweException.class, () -> testGCD.gcd(a, b, c, d));
   }
}
