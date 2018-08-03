import dayey.DayFinder;
import exception.GribiweException;
import fibbo.FibFinder;
import first.SwapperMenu;
import second.ApartmentFinder;
import gcd.GCDFinder;

import java.util.Scanner;

/**
 * Class of start of program
 * asks to user select program
 * which needed to run via
 * console input.
 *
 * @author Gribiwe
 * @see DayFinder
 * @see FibFinder
 * @see SwapperMenu
 * @see GCDFinder
 * @see ApartmentFinder
 */
public class Main {

   public static void main(String[] args) {

      Scanner scanner = new Scanner(System.in);

      System.out.println("what do you want to check?");
      System.out.println("1 - swapping of variables");
      System.out.println("2 - find my apartment");
      System.out.println("3 - find gcd of numbers");
      System.out.println("4 - find fibonacci");
      System.out.println("5 - find day of the week of a day");
      System.out.println("0 - exit");

      try {
         String answer = scanner.next();

         if (answer.equals("0")) {
            System.out.println("See you next time!");
            System.exit(0);

         } else if (answer.equals("1")) {
            new SwapperMenu().showMenu();

         } else if (answer.equals("2")) {
            new ApartmentFinder().showMenu();

         } else if (answer.equals("3")) {
            new GCDFinder().showMenu();

         } else if (answer.equals("4")) {
            new FibFinder().showMenu();

         } else if (answer.equals("5")) {
            new DayFinder().showMenu();

         } else {
            System.out.println("What?");
            System.exit(0);
         }
      } catch (GribiweException e) {
         System.out.println(e.getMessage());
      }
   }
}
