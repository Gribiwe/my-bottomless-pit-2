package first;

import java.util.Scanner;

/**
 * Class for integration with user
 * by {@link #showMenu()} method.
 *
 * @author Gribiwe
 */
public class SwapperMenu {

   /**
    * Method for integration with user
    * via console input. Initialise
    * variables for creation of two
    * swappable numbers, then call of
    * {@code swap} method.
    *
    * @see SwappableNumber
    */
   public void showMenu() {
      Scanner scanner = new Scanner(System.in);

      System.out.println("Enter a");
      String answer = scanner.next();
      SwappableNumber a = new SwappableNumber(answer);

      System.out.println("Enter b");
      answer = scanner.next();
      SwappableNumber b = new SwappableNumber(answer);

      a.swap(b);
   }


}
