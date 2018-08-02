package fibbo;

import exception.GribiweException;

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FibFinder {

   public BigInteger getFibonacci(BigInteger n) {

      if (n == null) throw new GribiweException("Can't find fibonacci of null");

      if (n.compareTo(BigInteger.valueOf(100000)) > 0) {
         throw new GribiweException("Too high value. Must be from 1 to 100 000. Your is: " + n);
      } else if (n.compareTo(BigInteger.ZERO) < 0) {
         throw new GribiweException("Too low value. Must be from 1 to 100 000. Your is: " + n);
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

   public void showMenu() {
      Scanner scanner = new Scanner(System.in);

      System.out.println("What number of fibonacci you want to find?");
      BigInteger answer;

      try {
         answer = scanner.nextBigInteger();
      } catch (InputMismatchException e) {
         throw new GribiweException("You have entered stroke, which doesn't match the Integer: " + scanner.next());
      }

      System.out.println(getFibonacci(answer));
   }
}
