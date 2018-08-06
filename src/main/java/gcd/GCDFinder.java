package gcd;

import exception.GribiweException;

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class for finding GCD of 4 numbers.
 * contains of methods {@link #gcd(BigInteger, BigInteger, BigInteger, BigInteger)}
 * for calculating GCD nad {@link #showMenu()} for integration with user.
 *
 * @author Gribiwe
 * @see BigInteger
 */
public class GCDFinder {

   /**
    * scanner for user's input
    */
   private Scanner scanner;

   /**
    * Method for calculating GCD of 4 numbers.
    *
    * @param a first variable
    * @param b second variable
    * @param c third variable
    * @param d fourth variable
    * @return GCD of a, b, c, d
    * @throws GribiweException if all of values is zero
    *                          or some of values is null
    */
   public BigInteger gcd(BigInteger a, BigInteger b, BigInteger c, BigInteger d) {
      if (a == null) {
         throw new GribiweException("a is null. Can't find gcd with null values");
      }
      if (b == null) {
         throw new GribiweException("b is null. Can't find gcd with null values");
      }
      if (c == null) {
         throw new GribiweException("c is null. Can't find gcd with null values");
      }
      if (d == null) {
         throw new GribiweException("d is null. Can't find gcd with null values");
      }

      if (a.compareTo(BigInteger.ZERO) == 0 &&
              b.compareTo(BigInteger.ZERO) == 0 &&
              c.compareTo(BigInteger.ZERO) == 0 &&
              d.compareTo(BigInteger.ZERO) == 0) {
         throw new GribiweException("Can't find gcd of zeros because of gcd of zeros is plus infinite");
      }

      return gcd(gcd(a,b), gcd(c,d));
   }

   /**
    * Calculates gcd of two variables
    * uses for calculation gcd of four nums
    *
    * @param a first number
    * @param b second number
    * @return gcd of a and b numbers
    */
   private BigInteger gcd(BigInteger a, BigInteger b) {
      BigInteger tmp;
      a = a.abs();
      b = b.abs();
      while (b.compareTo(BigInteger.ZERO) != 0){
         tmp = a.mod(b);
         a = b;
         b = tmp;
      }
      return a;
   }

   /**
    * Method for integration with user via console
    * input for initiate variables {@code a, b, c, d}
    * then calls of {@link #gcd(BigInteger, BigInteger, BigInteger, BigInteger)}
    *
    * @throws GribiweException if some of entered strokes
    *                          doesn't match to Integer
    */
   public void showMenu() {
      scanner = new Scanner(System.in);

      System.out.println("Enter 1st number");
      BigInteger a = getAnswerFromConsole();

      System.out.println("Enter 2nd number");
      BigInteger b = getAnswerFromConsole();

      System.out.println("Enter 3rd number");
      BigInteger c = getAnswerFromConsole();

      System.out.println("Enter 4th number");
      BigInteger d = getAnswerFromConsole();

      System.out.println("GDC is " + (gcd(a, b, c, d)));
   }

   /**
    * Waits until user will enter an BigInteger value
    */
   private BigInteger getAnswerFromConsole() {
      try {
         return scanner.nextBigInteger();
      } catch (InputMismatchException e) {
         throw new GribiweException("You have entered stroke, which doesn't match the Integer: " + scanner.next());
      }
   }

}
