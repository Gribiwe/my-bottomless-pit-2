import dayey.DayFinder;
import exception.GribiweException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.DayOfWeek;
import java.time.Month;

public class DayFinderTest extends Assert{

    private static DayFinder testDayFinder;

    @BeforeClass
    public static void runDayFinder() {
        testDayFinder = new DayFinder();
    }

    @Test
    public void testGetDayInfo() {
        testGetDayInfo(1, 7, 20, 5);//ITS TODAY YEY

        // First day id MONDAY
        // JANUARY
        testGetDayInfo(1, 1, 1, 1);
        testGetDayInfo(1, 1, 7, 7);
        testGetDayInfo(1, 1, 8, 1);
        testGetDayInfo(1, 1, 31, 3);

        // FEBRUARY
        testGetDayInfo(1, 2, 1, 4);
        testGetDayInfo(1, 2, 7, 3);
        testGetDayInfo(1, 2, 8, 4);
        testGetDayInfo(1, 2, 28, 3);

        // MARCH
        testGetDayInfo(1, 3, 1, 4);
        testGetDayInfo(1, 3, 2, 5);
        testGetDayInfo(1, 3, 8, 4);
        testGetDayInfo(1, 3, 31, 6);

        // APRIL
        testGetDayInfo(1, 4, 1, 7);
        testGetDayInfo(1, 4, 2, 1);
        testGetDayInfo(1, 4, 8, 7);
        testGetDayInfo(1, 4, 30, 1);

        // MAY
        testGetDayInfo(1, 5, 1, 2);
        testGetDayInfo(1, 5, 2, 3);
        testGetDayInfo(1, 5, 8, 2);
        testGetDayInfo(1, 5, 31, 4);

        // JUNE
        testGetDayInfo(1, 6, 1, 5);
        testGetDayInfo(1, 6, 2, 6);
        testGetDayInfo(1, 6, 8, 5);
        testGetDayInfo(1, 6, 30, 6);

        // JULE
        testGetDayInfo(1, 7, 1, 7);
        testGetDayInfo(1, 7, 2, 1);
        testGetDayInfo(1, 7, 8, 7);
        testGetDayInfo(1, 7, 31, 2);

        // AUGUST
        testGetDayInfo(1, 8, 1, 3);
        testGetDayInfo(1, 8, 2, 4);
        testGetDayInfo(1, 8, 8, 3);
        testGetDayInfo(1, 8, 31, 5);

        // SEPTEMBER
        testGetDayInfo(1, 9, 1, 6);
        testGetDayInfo(1, 9, 2, 7);
        testGetDayInfo(1, 9, 8, 6);
        testGetDayInfo(1, 9, 30, 7);

        // OCTOBER
        testGetDayInfo(1, 10, 1, 1);
        testGetDayInfo(1, 10, 2, 2);
        testGetDayInfo(1, 10, 8, 1);
        testGetDayInfo(1, 10, 31, 3);

        // NOVEMBER
        testGetDayInfo(1, 11, 1, 4);
        testGetDayInfo(1, 11, 2, 5);
        testGetDayInfo(1, 11, 8, 4);
        testGetDayInfo(1, 11, 30, 5);

        // DECEMBER
        testGetDayInfo(1, 12, 1, 6);
        testGetDayInfo(1, 12, 2, 7);
        testGetDayInfo(1, 12, 8, 6);
        testGetDayInfo(1, 12, 31, 1);

        // First day id TUESDAY
        // JANUARY
        testGetDayInfo(2, 1, 1, 2);
        testGetDayInfo(2, 1, 7, 1);
        testGetDayInfo(2, 1, 8, 2);
        testGetDayInfo(2, 1, 31, 4);

        // FEBRUARY
        testGetDayInfo(2, 2, 1, 5);
        testGetDayInfo(2, 2, 7, 4);
        testGetDayInfo(2, 2, 8, 5);
        testGetDayInfo(2, 2, 28, 4);

        // MARCH
        testGetDayInfo(2, 3, 1, 5);
        testGetDayInfo(2, 3, 7, 4);
        testGetDayInfo(2, 3, 8, 5);
        testGetDayInfo(2, 3, 31, 7);

        // SEPTEMBER
        testGetDayInfo(2, 9, 1, 7);
        testGetDayInfo(2, 9, 2, 1);
        testGetDayInfo(2, 9, 8, 7);
        testGetDayInfo(2, 9, 30, 1);

        // DECEMBER
        testGetDayInfo(2, 12, 1, 7);
        testGetDayInfo(2, 12, 2, 1);
        testGetDayInfo(2, 12, 8, 7);
        testGetDayInfo(2, 12, 31, 2);

        // First day id SUNDAY
        // JANUARY
        testGetDayInfo(7, 1, 1, 7);
        testGetDayInfo(7, 1, 7, 6);
        testGetDayInfo(7, 1, 8, 7);
        testGetDayInfo(7, 1, 31, 2);

        // FEBRUARY
        testGetDayInfo(7, 2, 1, 3);
        testGetDayInfo(7, 2, 7, 2);
        testGetDayInfo(7, 2, 8, 3);
        testGetDayInfo(7, 2, 28, 2);

        // MARCH
        testGetDayInfo(7, 3, 1, 3);
        testGetDayInfo(7, 3, 7, 2);
        testGetDayInfo(7, 3, 8, 3);
        testGetDayInfo(7, 3, 31, 5);

        // SEPTEMBER
        testGetDayInfo(7, 9, 1, 5);
        testGetDayInfo(7, 9, 7, 4);
        testGetDayInfo(7, 9, 8, 5);
        testGetDayInfo(7, 9, 30, 6);

        // DECEMBER
        testGetDayInfo(7, 12, 1, 5);
        testGetDayInfo(7, 12, 7, 4);
        testGetDayInfo(7, 12, 8, 5);
        testGetDayInfo(7, 12, 31, 7);
    }
    @Test
    public void testGetDayInfoWithUnrealData() {

        // UNREAL DAY
        // of january
        testGetDayInfoWithUnrealData(1, 1, 32);
        testGetDayInfoWithUnrealData(1, 1, Integer.MIN_VALUE);
        testGetDayInfoWithUnrealData(1, 1, 0);
        testGetDayInfoWithUnrealData(1, 1, -1);
        testGetDayInfoWithUnrealData(1, 1, Integer.MAX_VALUE);

        // of february
        testGetDayInfoWithUnrealData(1, 2, 29);
        testGetDayInfoWithUnrealData(1, 2, Integer.MAX_VALUE);
        testGetDayInfoWithUnrealData(1, 2, 0);
        testGetDayInfoWithUnrealData(1, 2, -1);
        testGetDayInfoWithUnrealData(1, 2, Integer.MIN_VALUE);

        // of march
        testGetDayInfoWithUnrealData(1, 3, 32);
        testGetDayInfoWithUnrealData(1, 3, Integer.MAX_VALUE);
        testGetDayInfoWithUnrealData(1, 3, 0);
        testGetDayInfoWithUnrealData(1, 3, -1);
        testGetDayInfoWithUnrealData(1, 3, Integer.MIN_VALUE);

        // of september
        testGetDayInfoWithUnrealData(1, 9, 31);
        testGetDayInfoWithUnrealData(1, 9, Integer.MAX_VALUE);
        testGetDayInfoWithUnrealData(1, 9, 0);
        testGetDayInfoWithUnrealData(1, 9, -1);
        testGetDayInfoWithUnrealData(1, 9, Integer.MIN_VALUE);

        // of december
        testGetDayInfoWithUnrealData(1, 12, 32);
        testGetDayInfoWithUnrealData(1, 12, Integer.MAX_VALUE);
        testGetDayInfoWithUnrealData(1, 12, 0);
        testGetDayInfoWithUnrealData(1, 12, -1);
        testGetDayInfoWithUnrealData(1, 12, Integer.MIN_VALUE);

    }

    private void testGetDayInfo(int dayOfWeekOfFirstOfJan, int month, int day, int realDayOfWeek) {
        assertEquals(testDayFinder.getDayOfWeek(DayOfWeek.of(dayOfWeekOfFirstOfJan), Month.of(month), day), DayOfWeek.of(realDayOfWeek));
    }

    private void testGetDayInfoWithUnrealData(int dayOfWeekOfFirstOfJan, int month, int day) {
        Assertions.assertThrows(GribiweException.class, () -> testDayFinder.getDayOfWeek(DayOfWeek.of(dayOfWeekOfFirstOfJan), Month.of(month), day));
    }
}
