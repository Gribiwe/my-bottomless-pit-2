import exception.GribiweException;
import fibbo.FibFinder;
import org.junit.*;
import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Scanner;

public class FibFinderTest extends Assert {

   private static FibFinder testFib;
   private static InputStream oldIn;
   private static PrintStream oldOut;
   private static ByteArrayOutputStream newOut;

   @BeforeClass
   public static void runFibFinder() {
      testFib = new FibFinder();

      newOut = new ByteArrayOutputStream();

      oldIn = System.in;
      oldOut = System.out;

      System.setOut(new PrintStream(newOut));
   }

   @AfterClass
   public static void setUpBack() {
      System.setOut(oldOut);
      System.setIn(oldIn);
   }

   @Test
   public void testGetFibonacci() {

      //source - https://oeis.org/A000045
      testShowMenuGetFibonacci(0, "0");
      testShowMenuGetFibonacci(1, "1");
      testShowMenuGetFibonacci(2, "1");
      testShowMenuGetFibonacci(3, "2");
      testShowMenuGetFibonacci(4, "3");
      testShowMenuGetFibonacci(5, "5");
      testShowMenuGetFibonacci(6, "8");
      testShowMenuGetFibonacci(34, "5702887");
      testShowMenuGetFibonacci(35, "9227465");

      //source - http://php.bubble.ro/fibonacci/
      testShowMenuGetFibonacci(48, "4807526976");
      testShowMenuGetFibonacci(49, "7778742049");
      testShowMenuGetFibonacci(50, "12586269025");
      testShowMenuGetFibonacci(51, "20365011074");
      testShowMenuGetFibonacci(52, "32951280099");
      testShowMenuGetFibonacci(53, "53316291173");
      testShowMenuGetFibonacci(54, "86267571272");
      testShowMenuGetFibonacci(55, "139583862445");
      testShowMenuGetFibonacci(95, "31940434634990099905");
      testShowMenuGetFibonacci(96, "51680708854858323072");
      testShowMenuGetFibonacci(97, "83621143489848422977");
      testShowMenuGetFibonacci(98, "135301852344706746049");
      testShowMenuGetFibonacci(99, "218922995834555169026");
      testShowMenuGetFibonacci(100, "354224848179261915075");
   }

   @Test
   public void testGetFibonacciNull(){
      Assertions.assertThrows(GribiweException.class, () -> testFib.getFibonacci(null));
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

   private void testGetFibonacci(long n, String rightAnswer) {
      assertEquals(testFib.getFibonacci(BigInteger.valueOf(n)), new BigInteger(rightAnswer));
   }

   private void testGetFibonacciUnrealValues(long n) {
      Assertions.assertThrows(GribiweException.class, () -> testFib.getFibonacci(BigInteger.valueOf(n)));
   }

   private void testShowMenu(int n, String realAnswer) {
      newOut.reset();
      System.setIn(new ByteArrayInputStream((n + "\r\n").getBytes()));

      testFib.showMenu();
      String expectedOut = "What number of fibonacci you want to find?\r\nanswer: " + realAnswer + "\r\n";

      assertEquals(expectedOut, newOut.toString());
   }

   private void testShowMenuGetFibonacci(int n, String realAnswer) {
      testShowMenu(n, realAnswer);
      testGetFibonacci(n, realAnswer);
   }
}
