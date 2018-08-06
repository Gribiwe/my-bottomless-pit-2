package dayey;

import exception.GribiweException;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.Month;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class for finding day of week
 * of some day of some month with having
 * information about day of week of the first
 * of january.
 *
 * <p>Have method {@link #getDayOfWeek(DayOfWeek, Month, int)}
 * for finding day of week and {@link #showMenu()} for
 * integration with user via console input.
 *
 * @author Gribiwe
 * @see DayOfWeek
 * @see Month
 */
public class DayFinder {

   /**
    * scanner for user's input
    */
   private Scanner scanner;

   /**
    * Method for finding day of week.
    *
    * @param firstOfJanuaryDayOfWeek day of week of
    *                                first of january.
    *                                Must be from 1 to 7.
    * @param month                   month, which contains a day, which needed to
    *                                find a day of week. Must be from 1 to 12.
    * @param dayOfMonth              day of month, which needed to find a day of week.
    * @return day of week of {@code dayOfMonth}
    * @throws GribiweException if {@code dayOfMonth}
    *                          doesn't exist in this {@code month} in real life
    *                          or some values is null
    */
   public DayOfWeek getDayOfWeek(DayOfWeek firstOfJanuaryDayOfWeek, Month month, int dayOfMonth) {
      if (firstOfJanuaryDayOfWeek == null) {
         throw new GribiweException("day of week of first of january is null. Can't work with null.");
      }
      if (month == null) {
         throw new GribiweException("month is null. Can't work with null.");
      }
      if (dayOfMonth < 1 || dayOfMonth > month.minLength()) {
         throw new GribiweException("This day doesn't exist in this month. It must be from 1 to " + month.minLength() + ". Your day of month is: " + dayOfMonth);
      }

      int dayOfYear = dayOfMonth + firstOfJanuaryDayOfWeek.getValue();
      for (int i = 1; i < month.getValue(); i++) {
         dayOfYear += Month.of(i).minLength();
      }

      dayOfYear = ((dayOfYear - 1) % 7);
      if (dayOfYear == 0) {
         dayOfYear = 7;
      }

      return DayOfWeek.of(dayOfYear);
   }

   /**
    * Method for integration with user
    * via console input. Initialise
    * variables for call of
    * {@link #getDayOfWeek(DayOfWeek, Month, int)}
    * method.
    *
    * @throws GribiweException if some of
    *                          variables is not integers or cant exist
    *                          int real life.
    */
   public void showMenu() {
      scanner = new Scanner(System.in);

      System.out.println("What is the 1st of january day of week?");
      int answer = getAnswerFromConsole();
      DayOfWeek firstOfJanuaryDayOfWeek;
      try {
         firstOfJanuaryDayOfWeek = DayOfWeek.of(answer);
      } catch (DateTimeException e) {
         throw new GribiweException("This day of week doesn't exists! It's must from 1 to 7. Your is: " + answer);
      }

      System.out.println("What month?");
      answer = getAnswerFromConsole();
      Month month;
      try {
         month = Month.of(answer);
      } catch (DateTimeException e) {
         throw new GribiweException("This month doesn't exists! It's must from 1 to 12. Your is: " + answer);
      }

      System.out.println("What day of month?");
      int dayOfMonth = getAnswerFromConsole();
      if (dayOfMonth < 1 || dayOfMonth > month.minLength()) {
         System.out.println("This day doesn't exist in this month. It must be from 1 to "
                 + month.minLength() + ". Your day of month is: " + dayOfMonth);
      }

      System.out.println(getDayOfWeek(firstOfJanuaryDayOfWeek, month, dayOfMonth));
   }

   /**
    * Waits until user will enter an int value
    */
   private int getAnswerFromConsole() {
      try {
         return scanner.nextInt();
      } catch (InputMismatchException e) {
         throw new GribiweException("You have entered stroke, which doesn't match the Integer: " + scanner.next());
      }
   }
}
