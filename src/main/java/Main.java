import dayey.DayFinder;
import exception.GribiweException;
import fibbo.FibFinder;
import first.VariableSwapper;
import second.ApartmentFinder;
import gcd.GCDFinder;

import java.util.Scanner;

/**
 * Created by nikit on 16.07.2018.
 */
public class Main {

   public static void main(String[] args) {

      Scanner scanner = new Scanner(System.in);

         System.out.println("what do you want to check?");
         System.out.println("1 - swapping of variables");
         System.out.println("2 - find my apartment");
         System.out.println("3 - find gcd of numbers");
         System.out.println("4 - find fibanacci");
         System.out.println("5 - find dayof the week of a day");
         System.out.println("0 - exit");

         try {

            switch (scanner.next()) {

               case "0":
                  System.out.println("See you next time!");
                  System.exit(0);
                  break;
               case "1":
                  VariableSwapper.getInstance().showMenu(scanner);
                  break;
               case "2":
                  ApartmentFinder.getInstance().showMenu(scanner);
                  break;
               case "3":
                  GCDFinder.getInstance().showMenu(scanner);
                  break;
               case "4":
                  FibFinder.getInstance().showMenu(scanner);
                  break;
               case "5":
                  new DayFinder().showMenu();
                  break;
               default:
                  System.out.println("What?");
                  break;
            }
         } catch (GribiweException e){
            System.out.println(e.getMessage());
         }
   }
}
