import dayey.DayFinder;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class DayFinderTest extends Assert{

    private static DayFinder testDayFinder;
    private final static String days[] = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    @BeforeClass
    public static void runDayFinder() {
        testDayFinder = DayFinder.getInstance();
    }

    private void testGetDayInfoTemplate(int dayOfWeekOfFirstOfJan, int month, int day, int realDayOfWeek) {
        assertEquals(testDayFinder.getDayOfWeek(dayOfWeekOfFirstOfJan, month, day), days[realDayOfWeek-1]);
    }

    private void testGetDayInfoWithUnrealDataTemplate(int dayOfWeekOfFirstOfJan, int month, int day) {
        assertEquals(testDayFinder.getDayOfWeek(dayOfWeekOfFirstOfJan, month, day), null);
    }
    @Test
    public void testGetDayInfo() {
        testGetDayInfoTemplate(1, 7, 20, 5);//ITS TODAY YEY

        // TODO: добить год

        // First day id MONDAY
        // JANUARY
        testGetDayInfoTemplate(1, 1, 1, 1);
        testGetDayInfoTemplate(1, 1, 7, 7);
        testGetDayInfoTemplate(1, 1, 8, 1);
        testGetDayInfoTemplate(1, 1, 31, 3);

        // FEBRUARY
        testGetDayInfoTemplate(1, 2, 1, 4);
        testGetDayInfoTemplate(1, 2, 7, 3);
        testGetDayInfoTemplate(1, 2, 8, 4);
        testGetDayInfoTemplate(1, 2, 28, 3);

        // MARCH
        testGetDayInfoTemplate(1, 3, 1, 4);
        testGetDayInfoTemplate(1, 3, 2, 5);
        testGetDayInfoTemplate(1, 3, 8, 4);
        testGetDayInfoTemplate(1, 3, 31, 6);

        // APRIL
        testGetDayInfoTemplate(1, 4, 1, 7);
        testGetDayInfoTemplate(1, 4, 2, 1);
        testGetDayInfoTemplate(1, 4, 8, 7);
        testGetDayInfoTemplate(1, 4, 30, 1);

        // MAY
        testGetDayInfoTemplate(1, 5, 1, 2);
        testGetDayInfoTemplate(1, 5, 2, 3);
        testGetDayInfoTemplate(1, 5, 8, 2);
        testGetDayInfoTemplate(1, 5, 31, 4);

        // JUNE
        testGetDayInfoTemplate(1, 6, 1, 5);
        testGetDayInfoTemplate(1, 6, 2, 6);
        testGetDayInfoTemplate(1, 6, 8, 5);
        testGetDayInfoTemplate(1, 6, 30, 6);

        // JULE
        testGetDayInfoTemplate(1, 7, 1, 7);
        testGetDayInfoTemplate(1, 7, 2, 1);
        testGetDayInfoTemplate(1, 7, 8, 7);
        testGetDayInfoTemplate(1, 7, 31, 2);

        // AUGUST
        testGetDayInfoTemplate(1, 8, 1, 3);
        testGetDayInfoTemplate(1, 8, 2, 4);
        testGetDayInfoTemplate(1, 8, 8, 3);
        testGetDayInfoTemplate(1, 8, 31, 5);

        // SEPTEMBER
        testGetDayInfoTemplate(1, 9, 1, 6);
        testGetDayInfoTemplate(1, 9, 2, 7);
        testGetDayInfoTemplate(1, 9, 8, 6);
        testGetDayInfoTemplate(1, 9, 30, 7);

        // OCTOBER
        testGetDayInfoTemplate(1, 10, 1, 1);
        testGetDayInfoTemplate(1, 10, 2, 2);
        testGetDayInfoTemplate(1, 10, 8, 1);
        testGetDayInfoTemplate(1, 10, 31, 3);

        // NOVEMBER
        testGetDayInfoTemplate(1, 11, 1, 4);
        testGetDayInfoTemplate(1, 11, 2, 5);
        testGetDayInfoTemplate(1, 11, 8, 4);
        testGetDayInfoTemplate(1, 11, 30, 5);

        // DECEMBER
        testGetDayInfoTemplate(1, 12, 1, 6);
        testGetDayInfoTemplate(1, 12, 2, 7);
        testGetDayInfoTemplate(1, 12, 8, 6);
        testGetDayInfoTemplate(1, 12, 31, 1);

        // First day id TUESDAY
        // JANUARY
        testGetDayInfoTemplate(2, 1, 1, 2);
        testGetDayInfoTemplate(2, 1, 7, 1);
        testGetDayInfoTemplate(2, 1, 8, 2);
        testGetDayInfoTemplate(2, 1, 31, 4);

        // FEBRUARY
        testGetDayInfoTemplate(2, 2, 1, 5);
        testGetDayInfoTemplate(2, 2, 7, 4);
        testGetDayInfoTemplate(2, 2, 8, 5);
        testGetDayInfoTemplate(2, 2, 28, 4);

        // MARCH
        testGetDayInfoTemplate(2, 3, 1, 5);
        testGetDayInfoTemplate(2, 3, 7, 4);
        testGetDayInfoTemplate(2, 3, 8, 5);
        testGetDayInfoTemplate(2, 3, 31, 7);

        // SEPTEMBER
        testGetDayInfoTemplate(2, 9, 1, 7);
        testGetDayInfoTemplate(2, 9, 2, 1);
        testGetDayInfoTemplate(2, 9, 8, 7);
        testGetDayInfoTemplate(2, 9, 30, 1);

        // DECEMBER
        testGetDayInfoTemplate(2, 12, 1, 7);
        testGetDayInfoTemplate(2, 12, 2, 1);
        testGetDayInfoTemplate(2, 12, 8, 7);
        testGetDayInfoTemplate(2, 12, 31, 2);

        // First day id SUNDAY
        // JANUARY
        testGetDayInfoTemplate(7, 1, 1, 7);
        testGetDayInfoTemplate(7, 1, 7, 6);
        testGetDayInfoTemplate(7, 1, 8, 7);
        testGetDayInfoTemplate(7, 1, 31, 2);

        // FEBRUARY
        testGetDayInfoTemplate(7, 2, 1, 3);
        testGetDayInfoTemplate(7, 2, 7, 2);
        testGetDayInfoTemplate(7, 2, 8, 3);
        testGetDayInfoTemplate(7, 2, 28, 2);

        // MARCH
        testGetDayInfoTemplate(7, 3, 1, 3);
        testGetDayInfoTemplate(7, 3, 7, 2);
        testGetDayInfoTemplate(7, 3, 8, 3);
        testGetDayInfoTemplate(7, 3, 31, 5);

        // SEPTEMBER
        testGetDayInfoTemplate(7, 9, 1, 5);
        testGetDayInfoTemplate(7, 9, 7, 4);
        testGetDayInfoTemplate(7, 9, 8, 5);
        testGetDayInfoTemplate(7, 9, 30, 6);

        // DECEMBER
        testGetDayInfoTemplate(7, 12, 1, 5);
        testGetDayInfoTemplate(7, 12, 7, 4);
        testGetDayInfoTemplate(7, 12, 8, 5);
        testGetDayInfoTemplate(7, 12, 31, 7);
    }

    @Test
    public void testGetDayInfoWithUnrealData() {
        // UNREAL FIRST DAY OF JAN
        testGetDayInfoWithUnrealDataTemplate(0, 1, 1);
        testGetDayInfoWithUnrealDataTemplate(8, 1, 1);
        testGetDayInfoWithUnrealDataTemplate(-1, 1, 1);
        testGetDayInfoWithUnrealDataTemplate(Integer.MAX_VALUE, 1, 1);
        testGetDayInfoWithUnrealDataTemplate(Integer.MIN_VALUE, 1, 1);

        // UNREAL MONTH
        testGetDayInfoWithUnrealDataTemplate(1, 0, 1);
        testGetDayInfoWithUnrealDataTemplate(1, 13, 1);
        testGetDayInfoWithUnrealDataTemplate(1, -1, 1);
        testGetDayInfoWithUnrealDataTemplate(1, Integer.MAX_VALUE, 1);
        testGetDayInfoWithUnrealDataTemplate(1, Integer.MIN_VALUE, 1);

        // UNREAL DAY
        // of january
        testGetDayInfoWithUnrealDataTemplate(1, 1, 32);
        testGetDayInfoWithUnrealDataTemplate(1, 1, Integer.MIN_VALUE);
        testGetDayInfoWithUnrealDataTemplate(1, 1, 0);
        testGetDayInfoWithUnrealDataTemplate(1, 1, -1);
        testGetDayInfoWithUnrealDataTemplate(1, 1, Integer.MAX_VALUE);

        // of february
        testGetDayInfoWithUnrealDataTemplate(1, 2, 29);
        testGetDayInfoWithUnrealDataTemplate(1, 2, Integer.MAX_VALUE);
        testGetDayInfoWithUnrealDataTemplate(1, 2, 0);
        testGetDayInfoWithUnrealDataTemplate(1, 2, -1);
        testGetDayInfoWithUnrealDataTemplate(1, 2, Integer.MIN_VALUE);

        // of march
        testGetDayInfoWithUnrealDataTemplate(1, 3, 32);
        testGetDayInfoWithUnrealDataTemplate(1, 3, Integer.MAX_VALUE);
        testGetDayInfoWithUnrealDataTemplate(1, 3, 0);
        testGetDayInfoWithUnrealDataTemplate(1, 3, -1);
        testGetDayInfoWithUnrealDataTemplate(1, 3, Integer.MIN_VALUE);

        // of september
        testGetDayInfoWithUnrealDataTemplate(1, 9, 31);
        testGetDayInfoWithUnrealDataTemplate(1, 9, Integer.MAX_VALUE);
        testGetDayInfoWithUnrealDataTemplate(1, 9, 0);
        testGetDayInfoWithUnrealDataTemplate(1, 9, -1);
        testGetDayInfoWithUnrealDataTemplate(1, 9, Integer.MIN_VALUE);

        // of december
        testGetDayInfoWithUnrealDataTemplate(1, 12, 32);
        testGetDayInfoWithUnrealDataTemplate(1, 12, Integer.MAX_VALUE);
        testGetDayInfoWithUnrealDataTemplate(1, 12, 0);
        testGetDayInfoWithUnrealDataTemplate(1, 12, -1);
        testGetDayInfoWithUnrealDataTemplate(1, 12, Integer.MIN_VALUE);

    }
}
