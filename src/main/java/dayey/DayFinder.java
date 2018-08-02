package dayey;

import exception.GribiweException;
import second.ApartmentFinder;

import java.time.DayOfWeek;
import java.time.Month;
import java.util.Scanner;

/**
 * Created by nikit on 16.07.2018.
 */
public class DayFinder {

   public DayOfWeek getDayOfWeek(DayOfWeek firstOfJanuaryDayOfWeek, Month month, int dayOfMonth) {
      if (dayOfMonth < 1 || dayOfMonth > month.minLength()) {
         throw new GribiweException("This day doesn't exist in this month. It must be from 1 to " + month.minLength());
      }

      int dayOfYear = dayOfMonth + firstOfJanuaryDayOfWeek.getValue();
      for (int i = 1; i < month.getValue(); i++) {
         dayOfYear += month.minLength();
      }

      dayOfYear = ((dayOfYear - 1) % 7);
      dayOfYear = dayOfYear == 0 ? 7 : dayOfYear;

      return DayOfWeek.of(dayOfYear);
   }

   public void showMenu() {

      Scanner scanner = new Scanner(System.in);

      System.out.println("1st of Jan is (1 - Mon, 7 - Sun): ");
      byte fJanDay = scanner.nextByte();
      if (fJanDay < 1 || fJanDay > 7) {
         System.out.println("incorrect value");
      }

      System.out.println("what day you want to find?");
      int n = scanner.nextInt();
      if (fJanDay < 1 || fJanDay > 31) {
         System.out.println("incorrect value");
      }


      System.out.println("btw, that month?");
      int month = scanner.nextInt();
      if (fJanDay < 1 || fJanDay > 12) {
         System.out.println("incorrect value");
      }

      System.out.println(getDayOfWeek(fJanDay, month, n));

   }

}
