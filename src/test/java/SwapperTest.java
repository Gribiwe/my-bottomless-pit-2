import exception.GribiweException;
import swap.SwappableNumber;
import swap.SwapperMenu;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * Class for testing SwapperNumber
 *
 * @author Gribiwe
 * @see SwapperMenu
 * @see SwappableNumber
 */
public class SwapperTest extends Assert {

   /**
    * Testing of swap().
    * Using methods:
    * {@link #testSwap(long, long)},
    */
   @Test
   public void testSwap() {
      // (a, a), (a, -a), (-a, a), (-a, -a)
      //zeros
      testSwap(0, 0);
      testSwap(-0, 0);
      testSwap(0, -0);
      testSwap(-0, -0);

      //(a % 2 == 1)
      testSwap(1, 1);
      testSwap(-1, -1);
      testSwap(-1, 1);
      testSwap(1, -1);

      testSwap(21, 21);
      testSwap(-21, -21);
      testSwap(-21, 21);
      testSwap(21, -21);

      testSwap(15, 15);
      testSwap(-15, -15);
      testSwap(-15, 15);
      testSwap(15, -15);

      // (a % 2 == 2)
      testSwap(4, 4);
      testSwap(-4, -4);
      testSwap(4, -4);
      testSwap(-4, 4);

      testSwap(20, 20);
      testSwap(-20, -20);
      testSwap(20, -20);
      testSwap(-20, 20);

      testSwap(14, 14);
      testSwap(-14, -14);
      testSwap(14, -14);
      testSwap(-14, 14);

      //simple number
      testSwap(7, 7);
      testSwap(-7, -7);
      testSwap(7, -7);
      testSwap(-7, 7);

      testSwap(3, 3);
      testSwap(-3, -3);
      testSwap(3, -3);
      testSwap(-3, 3);

      testSwap(Long.MAX_VALUE, Long.MIN_VALUE);
      testSwap(Long.MIN_VALUE, Long.MAX_VALUE);
      testSwap(Long.MAX_VALUE, Long.MAX_VALUE);
      testSwap(Long.MIN_VALUE, Long.MIN_VALUE);

      // zeros
      testSwap(0, -100);
      testSwap(0, -50);
      testSwap(0, -20);
      testSwap(0, -10);
      testSwap(0, -3);
      testSwap(0, -2);
      testSwap(0, -1);
      testSwap(0, 0);
      testSwap(0, 1);
      testSwap(0, 2);
      testSwap(0, 3);
      testSwap(0, 10);
      testSwap(0, 20);
      testSwap(0, 50);
      testSwap(0, 100);

      testSwap(-100, 0);
      testSwap(-50, 0);
      testSwap(-20, 0);
      testSwap(-10, 0);
      testSwap(-3, 0);
      testSwap(-2, 0);
      testSwap(0, 0);
      testSwap(1, 0);
      testSwap(2, 0);
      testSwap(3, 0);
      testSwap(10, 0);
      testSwap(20, 0);
      testSwap(50, 0);
      testSwap(100, 0);

      testSwap(5, -100);
      testSwap(5, -50);
      testSwap(5, -20);
      testSwap(5, -10);
      testSwap(5, -3);
      testSwap(5, -2);
      testSwap(5, -1);
      testSwap(5, 5);
      testSwap(5, 1);
      testSwap(5, 2);
      testSwap(5, 3);
      testSwap(5, 10);
      testSwap(5, 20);
      testSwap(5, 50);
      testSwap(5, 100);

      testSwap(-100, 5);
      testSwap(-50, 5);
      testSwap(-20, 5);
      testSwap(-10, 5);
      testSwap(-3, 5);
      testSwap(-2, 5);
      testSwap(1, 5);
      testSwap(5, 5);
      testSwap(2, 5);
      testSwap(3, 5);
      testSwap(10, 5);
      testSwap(20, 5);
      testSwap(50, 5);
      testSwap(100, 5);

      testSwap(55, -100);
      testSwap(55, -50);
      testSwap(55, -20);
      testSwap(55, -10);
      testSwap(55, -3);
      testSwap(55, -2);
      testSwap(55, -1);
      testSwap(55, 55);
      testSwap(55, 1);
      testSwap(55, 2);
      testSwap(55, 3);
      testSwap(55, 10);
      testSwap(55, 20);
      testSwap(55, 50);
      testSwap(55, 100);

      testSwap(-100, 55);
      testSwap(-50, 55);
      testSwap(-20, 55);
      testSwap(-10, 55);
      testSwap(-3, 55);
      testSwap(-2, 55);
      testSwap(1, 55);
      testSwap(55, 55);
      testSwap(2, 55);
      testSwap(3, 55);
      testSwap(10, 55);
      testSwap(20, 55);
      testSwap(50, 55);
      testSwap(100, 55);

      testSwap(1569, -100);
      testSwap(1569, -50);
      testSwap(1569, -20);
      testSwap(1569, -10);
      testSwap(1569, -3);
      testSwap(1569, -2);
      testSwap(1569, -1);
      testSwap(1569, 1569);
      testSwap(1569, 1);
      testSwap(1569, 2);
      testSwap(1569, 3);
      testSwap(1569, 10);
      testSwap(1569, 20);
      testSwap(1569, 50);
      testSwap(1569, 100);

      testSwap(-100, 1569);
      testSwap(-50, 1569);
      testSwap(-20, 1569);
      testSwap(-10, 1569);
      testSwap(-3, 1569);
      testSwap(-2, 1569);
      testSwap(1569, 1569);
      testSwap(1, 1569);
      testSwap(2, 1569);
      testSwap(3, 1569);
      testSwap(10, 1569);
      testSwap(20, 1569);
      testSwap(50, 1569);
      testSwap(100, 1569);

      testSwap(Integer.MAX_VALUE, -100);
      testSwap(Integer.MAX_VALUE, -50);
      testSwap(Integer.MAX_VALUE, -20);
      testSwap(Integer.MAX_VALUE, -10);
      testSwap(Integer.MAX_VALUE, -3);
      testSwap(Integer.MAX_VALUE, -2);
      testSwap(Integer.MAX_VALUE, -1);
      testSwap(Integer.MAX_VALUE, Integer.MAX_VALUE);
      testSwap(Integer.MAX_VALUE, 1);
      testSwap(Integer.MAX_VALUE, 2);
      testSwap(Integer.MAX_VALUE, 3);
      testSwap(Integer.MAX_VALUE, 10);
      testSwap(Integer.MAX_VALUE, 20);
      testSwap(Integer.MAX_VALUE, 50);
      testSwap(Integer.MAX_VALUE, 100);

      testSwap(-100, Integer.MAX_VALUE);
      testSwap(-50, Integer.MAX_VALUE);
      testSwap(-20, Integer.MAX_VALUE);
      testSwap(-10, Integer.MAX_VALUE);
      testSwap(-3, Integer.MAX_VALUE);
      testSwap(-2, Integer.MAX_VALUE);
      testSwap(1, Integer.MAX_VALUE);
      testSwap(2, Integer.MAX_VALUE);
      testSwap(3, Integer.MAX_VALUE);
      testSwap(10, Integer.MAX_VALUE);
      testSwap(20, Integer.MAX_VALUE);
      testSwap(50, Integer.MAX_VALUE);
      testSwap(100, Integer.MAX_VALUE);

      testSwap(Integer.MIN_VALUE, -100);
      testSwap(Integer.MIN_VALUE, -50);
      testSwap(Integer.MIN_VALUE, -20);
      testSwap(Integer.MIN_VALUE, -10);
      testSwap(Integer.MIN_VALUE, -3);
      testSwap(Integer.MIN_VALUE, -2);
      testSwap(Integer.MIN_VALUE, -1);
      testSwap(Integer.MIN_VALUE, Integer.MIN_VALUE);
      testSwap(Integer.MIN_VALUE, 1);
      testSwap(Integer.MIN_VALUE, 2);
      testSwap(Integer.MIN_VALUE, 3);
      testSwap(Integer.MIN_VALUE, 10);
      testSwap(Integer.MIN_VALUE, 20);
      testSwap(Integer.MIN_VALUE, 50);
      testSwap(Integer.MIN_VALUE, 100);

      testSwap(-100, Integer.MIN_VALUE);
      testSwap(-50, Integer.MIN_VALUE);
      testSwap(-20, Integer.MIN_VALUE);
      testSwap(-10, Integer.MIN_VALUE);
      testSwap(-3, Integer.MIN_VALUE);
      testSwap(-2, Integer.MIN_VALUE);
      testSwap(1, Integer.MIN_VALUE);
      testSwap(2, Integer.MIN_VALUE);
      testSwap(3, Integer.MIN_VALUE);
      testSwap(10, Integer.MIN_VALUE);
      testSwap(20, Integer.MIN_VALUE);
      testSwap(50, Integer.MIN_VALUE);
      testSwap(100, Integer.MIN_VALUE);

      testSwap(Integer.MAX_VALUE, Integer.MIN_VALUE);
      testSwap(Integer.MIN_VALUE, Integer.MAX_VALUE);

      testSwap(Long.MAX_VALUE, -100);
      testSwap(Long.MAX_VALUE, -50);
      testSwap(Long.MAX_VALUE, -20);
      testSwap(Long.MAX_VALUE, -10);
      testSwap(Long.MAX_VALUE, -3);
      testSwap(Long.MAX_VALUE, -2);
      testSwap(Long.MAX_VALUE, -1);
      testSwap(Long.MAX_VALUE, 1);
      testSwap(Long.MAX_VALUE, Long.MAX_VALUE);
      testSwap(Long.MAX_VALUE, 2);
      testSwap(Long.MAX_VALUE, 3);
      testSwap(Long.MAX_VALUE, 10);
      testSwap(Long.MAX_VALUE, 20);
      testSwap(Long.MAX_VALUE, 50);
      testSwap(Long.MAX_VALUE, 100);

      testSwap(-100, Long.MAX_VALUE);
      testSwap(-50, Long.MAX_VALUE);
      testSwap(-20, Long.MAX_VALUE);
      testSwap(-10, Long.MAX_VALUE);
      testSwap(-3, Long.MAX_VALUE);
      testSwap(-2, Long.MAX_VALUE);
      testSwap(1, Long.MAX_VALUE);
      testSwap(2, Long.MAX_VALUE);
      testSwap(3, Long.MAX_VALUE);
      testSwap(10, Long.MAX_VALUE);
      testSwap(20, Long.MAX_VALUE);
      testSwap(50, Long.MAX_VALUE);
      testSwap(100, Long.MAX_VALUE);

      testSwap(Long.MIN_VALUE, -100);
      testSwap(Long.MIN_VALUE, -50);
      testSwap(Long.MIN_VALUE, -20);
      testSwap(Long.MIN_VALUE, -10);
      testSwap(Long.MIN_VALUE, -3);
      testSwap(Long.MIN_VALUE, -2);
      testSwap(Long.MIN_VALUE, -1);
      testSwap(Long.MIN_VALUE, 1);
      testSwap(Long.MIN_VALUE, Long.MIN_VALUE);
      testSwap(Long.MIN_VALUE, 2);
      testSwap(Long.MIN_VALUE, 3);
      testSwap(Long.MIN_VALUE, 10);
      testSwap(Long.MIN_VALUE, 20);
      testSwap(Long.MIN_VALUE, 50);
      testSwap(Long.MIN_VALUE, 100);

      testSwap(-100, Long.MIN_VALUE);
      testSwap(-50, Long.MIN_VALUE);
      testSwap(-20, Long.MIN_VALUE);
      testSwap(-10, Long.MIN_VALUE);
      testSwap(-3, Long.MIN_VALUE);
      testSwap(-2, Long.MIN_VALUE);
      testSwap(1, Long.MIN_VALUE);
      testSwap(2, Long.MIN_VALUE);
      testSwap(3, Long.MIN_VALUE);
      testSwap(10, Long.MIN_VALUE);
      testSwap(20, Long.MIN_VALUE);
      testSwap(50, Long.MIN_VALUE);
      testSwap(100, Long.MIN_VALUE);
   }

   /**
    * Testing swap() with
    * wrong arguments.
    * Used methods:
    * {@link #testSwapWrongValues(double, double)}
    * {@link #testSwapWrongValues(String, String)}
    */
   @Test
   public void testSwapWrongValues() {
      testSwapWrongValues(1, 0.0000004);
      testSwapWrongValues(123.5, 12);
      testSwapWrongValues(12, 151.12312);
      testSwapWrongValues(123.5, 151.12312);
      testSwapWrongValues(".", "2");
      testSwapWrongValues("2", ".");
      testSwapWrongValues("!", ".");
      testSwapWrongValues("!", "2");
      testSwapWrongValues("?", "2");
      testSwapWrongValues("*", "2");
      testSwapWrongValues("$", "2");
      testSwapWrongValues("2", "*");
      testSwapWrongValues("2", "$");
   }

   /**
    * Template for testing swap()
    * with values which is null
    */
   @Test
   public void testSwapNull() {
      Assertions.assertThrows(GribiweException.class, () -> new SwappableNumber(null));
      Assertions.assertThrows(GribiweException.class, () -> new SwappableNumber("1").swap(null));
   }

   /**
    * Template for testing swap()
    *
    * @param first  swap number for swap
    * @param second apartment number for swap
    */
   private void testSwap(String first, String second) {
      SwappableNumber firstNum = new SwappableNumber(first);
      SwappableNumber secondNum = new SwappableNumber(second);

      SwappableNumber testSwappedFirstNum = new SwappableNumber(first);
      SwappableNumber testSwappedSecondNum = new SwappableNumber(second);

      testSwappedFirstNum.swap(testSwappedSecondNum);
      assertEquals(secondNum.getValue(), testSwappedFirstNum.getValue());
      assertEquals(firstNum.getValue(), testSwappedSecondNum.getValue());
   }

   /**
    * Method for calling of {@link #testSwap(String, String)}
    *
    * @param first  long value of swap number for swapping
    * @param second long value of apartment number for swapping
    */
   private void testSwap(long first, long second) {
      testSwap(String.valueOf(first), String.valueOf(second));
   }

   /**
    * Template for testing swap() with
    * wrong values of arguments
    *
    * @param a String value of swap number for swapping
    * @param b String value of apartment number for swapping
    */
   private void testSwapWrongValues(String a, String b) {
      Assertions.assertThrows(GribiweException.class, () -> new SwappableNumber(a).swap(new SwappableNumber(b)));
   }

   /**
    * Template for testing swap() with
    * wrong values of arguments. In actually
    * there is testing of exceptions thrown via
    * using double values
    *
    * @param a Double value of swap number for swapping
    * @param b Double value of apartment number for swapping
    */
   private void testSwapWrongValues(double a, double b) {
      testSwapWrongValues(String.valueOf(a), String.valueOf(b));
   }
}
