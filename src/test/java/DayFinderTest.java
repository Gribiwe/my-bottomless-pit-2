import dayey.DayFinder;
import exception.GribiweException;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.time.DayOfWeek;
import java.time.Month;

public class DayFinderTest extends Assert {

   private static InputStream oldIn;
   private static PrintStream oldOut;
   private static ByteArrayOutputStream newOut;

   private static DayFinder testDayFinder;

   @BeforeClass
   public static void runDayFinder() {
      testDayFinder = new DayFinder();

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
   public void testShowMenuGetDayInfo() {
      testGetDayInfo(1, 7, 20, 5);//ITS TODAY YEY

      // First day id MONDAY
      // JANUARY
      testShowMenuGetDayInfo(1, 1, 1, 1);
      testShowMenuGetDayInfo(1, 1, 7, 7);
      testShowMenuGetDayInfo(1, 1, 8, 1);
      testShowMenuGetDayInfo(1, 1, 31, 3);

      // FEBRUARY
      testShowMenuGetDayInfo(1, 2, 1, 4);
      testShowMenuGetDayInfo(1, 2, 7, 3);
      testShowMenuGetDayInfo(1, 2, 8, 4);
      testShowMenuGetDayInfo(1, 2, 28, 3);

      // MARCH
      testShowMenuGetDayInfo(1, 3, 1, 4);
      testShowMenuGetDayInfo(1, 3, 2, 5);
      testShowMenuGetDayInfo(1, 3, 8, 4);
      testShowMenuGetDayInfo(1, 3, 31, 6);

      // APRIL
      testShowMenuGetDayInfo(1, 4, 1, 7);
      testShowMenuGetDayInfo(1, 4, 2, 1);
      testShowMenuGetDayInfo(1, 4, 8, 7);
      testShowMenuGetDayInfo(1, 4, 30, 1);

      // MAY
      testShowMenuGetDayInfo(1, 5, 1, 2);
      testShowMenuGetDayInfo(1, 5, 2, 3);
      testShowMenuGetDayInfo(1, 5, 8, 2);
      testShowMenuGetDayInfo(1, 5, 31, 4);

      // JUNE
      testShowMenuGetDayInfo(1, 6, 1, 5);
      testShowMenuGetDayInfo(1, 6, 2, 6);
      testShowMenuGetDayInfo(1, 6, 8, 5);
      testShowMenuGetDayInfo(1, 6, 30, 6);

      // JULE
      testShowMenuGetDayInfo(1, 7, 1, 7);
      testShowMenuGetDayInfo(1, 7, 2, 1);
      testShowMenuGetDayInfo(1, 7, 8, 7);
      testShowMenuGetDayInfo(1, 7, 31, 2);

      // AUGUST
      testShowMenuGetDayInfo(1, 8, 1, 3);
      testShowMenuGetDayInfo(1, 8, 2, 4);
      testShowMenuGetDayInfo(1, 8, 8, 3);
      testShowMenuGetDayInfo(1, 8, 31, 5);

      // SEPTEMBER
      testShowMenuGetDayInfo(1, 9, 1, 6);
      testShowMenuGetDayInfo(1, 9, 2, 7);
      testShowMenuGetDayInfo(1, 9, 8, 6);
      testShowMenuGetDayInfo(1, 9, 30, 7);

      // OCTOBER
      testShowMenuGetDayInfo(1, 10, 1, 1);
      testShowMenuGetDayInfo(1, 10, 2, 2);
      testShowMenuGetDayInfo(1, 10, 8, 1);
      testShowMenuGetDayInfo(1, 10, 31, 3);

      // NOVEMBER
      testShowMenuGetDayInfo(1, 11, 1, 4);
      testShowMenuGetDayInfo(1, 11, 2, 5);
      testShowMenuGetDayInfo(1, 11, 8, 4);
      testShowMenuGetDayInfo(1, 11, 30, 5);

      // DECEMBER
      testShowMenuGetDayInfo(1, 12, 1, 6);
      testShowMenuGetDayInfo(1, 12, 2, 7);
      testShowMenuGetDayInfo(1, 12, 8, 6);
      testShowMenuGetDayInfo(1, 12, 31, 1);

      // First day id TUESDAY
      // JANUARY
      testShowMenuGetDayInfo(2, 1, 1, 2);
      testShowMenuGetDayInfo(2, 1, 7, 1);
      testShowMenuGetDayInfo(2, 1, 8, 2);
      testShowMenuGetDayInfo(2, 1, 31, 4);

      // FEBRUARY
      testShowMenuGetDayInfo(2, 2, 1, 5);
      testShowMenuGetDayInfo(2, 2, 7, 4);
      testShowMenuGetDayInfo(2, 2, 8, 5);
      testShowMenuGetDayInfo(2, 2, 28, 4);

      // MARCH
      testShowMenuGetDayInfo(2, 3, 1, 5);
      testShowMenuGetDayInfo(2, 3, 7, 4);
      testShowMenuGetDayInfo(2, 3, 8, 5);
      testShowMenuGetDayInfo(2, 3, 31, 7);

      // SEPTEMBER
      testShowMenuGetDayInfo(2, 9, 1, 7);
      testShowMenuGetDayInfo(2, 9, 2, 1);
      testShowMenuGetDayInfo(2, 9, 8, 7);
      testShowMenuGetDayInfo(2, 9, 30, 1);

      // DECEMBER
      testShowMenuGetDayInfo(2, 12, 1, 7);
      testShowMenuGetDayInfo(2, 12, 2, 1);
      testShowMenuGetDayInfo(2, 12, 8, 7);
      testShowMenuGetDayInfo(2, 12, 31, 2);

      // First day id SUNDAY
      // JANUARY
      testShowMenuGetDayInfo(7, 1, 1, 7);
      testShowMenuGetDayInfo(7, 1, 7, 6);
      testShowMenuGetDayInfo(7, 1, 8, 7);
      testShowMenuGetDayInfo(7, 1, 31, 2);

      // FEBRUARY
      testShowMenuGetDayInfo(7, 2, 1, 3);
      testShowMenuGetDayInfo(7, 2, 7, 2);
      testShowMenuGetDayInfo(7, 2, 8, 3);
      testShowMenuGetDayInfo(7, 2, 28, 2);

      // MARCH
      testShowMenuGetDayInfo(7, 3, 1, 3);
      testShowMenuGetDayInfo(7, 3, 7, 2);
      testShowMenuGetDayInfo(7, 3, 8, 3);
      testShowMenuGetDayInfo(7, 3, 31, 5);

      // SEPTEMBER
      testShowMenuGetDayInfo(7, 9, 1, 5);
      testShowMenuGetDayInfo(7, 9, 7, 4);
      testShowMenuGetDayInfo(7, 9, 8, 5);
      testShowMenuGetDayInfo(7, 9, 30, 6);

      // DECEMBER
      testShowMenuGetDayInfo(7, 12, 1, 5);
      testShowMenuGetDayInfo(7, 12, 7, 4);
      testShowMenuGetDayInfo(7, 12, 8, 5);
      testShowMenuGetDayInfo(7, 12, 31, 7);
   }

   @Test
   public void testGetDayInfoWithUnrealData() {

      // UNREAL DAY
      // of january
      testShowMenuGetDayInfoUnrealData(1, 32);
      testShowMenuGetDayInfoUnrealData(1, Integer.MIN_VALUE);
      testShowMenuGetDayInfoUnrealData(1, 0);
      testShowMenuGetDayInfoUnrealData(1, -1);
      testShowMenuGetDayInfoUnrealData(1, Integer.MAX_VALUE);

      // of february
      testShowMenuGetDayInfoUnrealData(2, 29);
      testShowMenuGetDayInfoUnrealData(2, Integer.MAX_VALUE);
      testShowMenuGetDayInfoUnrealData(2, 0);
      testShowMenuGetDayInfoUnrealData(2, -1);
      testShowMenuGetDayInfoUnrealData(2, Integer.MIN_VALUE);

      // of march
      testShowMenuGetDayInfoUnrealData(3, 32);
      testShowMenuGetDayInfoUnrealData(3, Integer.MAX_VALUE);
      testShowMenuGetDayInfoUnrealData(3, 0);
      testShowMenuGetDayInfoUnrealData(3, -1);
      testShowMenuGetDayInfoUnrealData(3, Integer.MIN_VALUE);

      // of september
      testShowMenuGetDayInfoUnrealData(9, 31);
      testShowMenuGetDayInfoUnrealData(9, Integer.MAX_VALUE);
      testShowMenuGetDayInfoUnrealData(9, 0);
      testShowMenuGetDayInfoUnrealData(9, -1);
      testShowMenuGetDayInfoUnrealData(9, Integer.MIN_VALUE);

      // of december
      testShowMenuGetDayInfoUnrealData(12, 32);
      testShowMenuGetDayInfoUnrealData(12, Integer.MAX_VALUE);
      testShowMenuGetDayInfoUnrealData(12, 0);
      testShowMenuGetDayInfoUnrealData(12, -1);
      testShowMenuGetDayInfoUnrealData(12, Integer.MIN_VALUE);
   }

   @Test
   public void testGetDayInfoNull() {
      Assertions.assertThrows(GribiweException.class,
              () -> testDayFinder.getDayOfWeek(null, Month.APRIL, 1));
      Assertions.assertThrows(GribiweException.class,
              () -> testDayFinder.getDayOfWeek(DayOfWeek.FRIDAY, null, 1));
      Assertions.assertThrows(GribiweException.class,
              () -> testDayFinder.getDayOfWeek(null, null, 1));
   }


   private void testGetDayInfo(int dayOfWeekOfFirstOfJan, int month, int day, int realDayOfWeek) {
      assertEquals(testDayFinder.getDayOfWeek(DayOfWeek.of(dayOfWeekOfFirstOfJan), Month.of(month), day), DayOfWeek.of(realDayOfWeek));
   }

   private void testShowMenuGetDayInfoUnrealData(int month, int dayOfMonth) {
      testGetDayInfoWithUnrealData(month, dayOfMonth);
      testShowMenuUnrealData(month, dayOfMonth);
   }

   private void testShowMenuUnrealData(int month, int dayOfMonth) {
      newOut.reset();
      System.setIn(new ByteArrayInputStream(("1\r\n" + month + "\r\n" + dayOfMonth + "\r\n").getBytes()));

      Assertions.assertThrows(GribiweException.class, () -> testDayFinder.showMenu());
   }

   private void testGetDayInfoWithUnrealData(int month, int day) {
      Assertions.assertThrows(GribiweException.class, () -> testDayFinder.getDayOfWeek(DayOfWeek.of(1), Month.of(month), day));
   }

   private void testShowMenu(int firstOfJanDayOfWeek, int month, int dayOfMonth, int realDayOfWeek) {
      newOut.reset();
      System.setIn(new ByteArrayInputStream((firstOfJanDayOfWeek + "\r\n" + month + "\r\n" + dayOfMonth + "\r\n").getBytes()));

      testDayFinder.showMenu();
      String expectedOut = "What is the 1st of january day of week?\r\n" +
              "What month?\r\nWhat day of month?\r\n" + DayOfWeek.of(realDayOfWeek) + "\r\n";

      assertEquals(expectedOut, newOut.toString());
   }

   private void testShowMenuGetDayInfo(int firstOfJanDayOfWeek, int month, int dayOfMonth, int realDayOfWeek) {
      testShowMenu(firstOfJanDayOfWeek, month, dayOfMonth, realDayOfWeek);
      testGetDayInfo(firstOfJanDayOfWeek, month, dayOfMonth, realDayOfWeek);
   }
}
