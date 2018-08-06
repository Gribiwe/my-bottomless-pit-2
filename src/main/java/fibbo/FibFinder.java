package fibbo;

import exception.GribiweException;

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class for finding of fibonacci number
 * of n. Fibonacci number is number, which
 * being a sum of two previous numbers of
 * Fibonacci. First number in sequence is 0.
 * Second is 1.
 * <p>Contain methods {@link #getFibonacci(BigInteger)}
 * for calculating fibonacci and {@link #showMenu()} for
 * integration with user.
 *
 * @author Gribiwe
 * @see BigInteger
 */
public class FibFinder {

   /**
    * Max possible value of the number of fibonacci
    * number index for this implementation
    */
   private final static BigInteger MAX_VALUE = BigInteger.valueOf(50000);

   /**
    * Method which finding fibonacci number at
    * position {@code n} in fibonacci sequence.
    *
    * @param n is a number of index of the fibonacci
    *          number at sequence. Starts from 1 up to 50 000
    * @return fibonacci number of {@code n}
    * @throws GribiweException if {@code n} is lower then 1 and higher
    *                          then 100 000 or n is null.
    */
   public BigInteger getFibonacci(BigInteger n) {
      if (n == null) {
         throw new GribiweException("Can't find fibonacci of null");
      }

      if (n.compareTo(MAX_VALUE) > 0) {
         throw new GribiweException("Too high value. Must be from 1 to 50 000. Your is: " + n);
      }

      if (n.compareTo(BigInteger.ZERO) < 0) {
         throw new GribiweException("Too low value. Must be from 1 to 50 000. Your is: " + n);
      }

      BigInteger current = BigInteger.ZERO;
      BigInteger previous = BigInteger.ONE;
      BigInteger tmp;

      for (int i = 0; i < n.intValue(); i++) {
         tmp = previous;
         previous = previous.add(current);
         current = tmp;
      }
      return current;
   }

   /**
    * Method for integration with
    * user via console input for initialisation
    * of variable for calling of {@link #getFibonacci(BigInteger)}
    *
    * @throws GribiweException if entered value can't be match
    *                          to Integer.
    */
   public void showMenu() {
      Scanner scanner = new Scanner(System.in);

      System.out.println("What number of fibonacci you want to find?");
      BigInteger answer;
      try {
         answer = scanner.nextBigInteger();
      } catch (InputMismatchException e) {
         throw new GribiweException("You have entered stroke, which doesn't match the Integer: " + scanner.next());
      }

      System.out.println("answer: "+getFibonacci(answer));
   }
}
