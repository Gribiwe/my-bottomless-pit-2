import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import second.ApartmentFinder;
import second.ApartmentInfo;

import java.math.BigInteger;

public class ApartmentFinderTest extends Assert {
    private static ApartmentFinder testApartmentFinder;
    private static final BigInteger LONGMAXBG = BigInteger.valueOf(Long.MAX_VALUE);
    private static final BigInteger INTMAXBG = BigInteger.valueOf(Integer.MAX_VALUE);

    private static final long INTMAX = Integer.MAX_VALUE;
    private static final long LONGMAX = Long.MAX_VALUE;

    @BeforeClass
    public static void runApartmentFinder() {
        testApartmentFinder = ApartmentFinder.getInstance();
    }

    private void testGetApartInfoTemplate(String floors, String apartmentsAtFloor, String apartmentNumber, String realFloor, String realEntrance) {
        ApartmentInfo testingApartment = testApartmentFinder.getApartInfo(
                new BigInteger(floors), new BigInteger(apartmentsAtFloor), new BigInteger(apartmentNumber));
        assertEquals(testingApartment.getEntrance().compareTo(new BigInteger(realEntrance)), 0);
        assertEquals(testingApartment.getFloor().compareTo(new BigInteger(realFloor)), 0);
    }

    private void testGetApartInfoTemplate(long floors, long apartmentsAtFloor, long apartmentNumber, long realFloor, long realEntrance) {
        testGetApartInfoTemplate(floors+"", apartmentsAtFloor+"", apartmentNumber+"", realFloor+"", realEntrance+"");
    }
    private void testGetApartInfoTemplate(long floors, long apartmentsAtFloor, BigInteger apartmentNumber, long realFloor, long realEntrance) {
        testGetApartInfoTemplate(floors+"", apartmentsAtFloor+"", apartmentNumber+"", realFloor+"", realEntrance+"");
    }

    private void testGetApartInfoUnrealValuesTemplate(long floors, long apartmentsAtFloor, long apartmentNumber) {
        assertNull(testApartmentFinder.getApartInfo(
                BigInteger.valueOf(floors), BigInteger.valueOf(apartmentsAtFloor), BigInteger.valueOf(apartmentNumber)));
    }

    @Test
    public void testGetApartInfo() {

        // NEW HOUSE with 1 floor
        // with 1 apartment at floor
        testGetApartInfoTemplate(1, 1, 1, 1, 1);
        testGetApartInfoTemplate(1, 1, 2, 1, 2);
        testGetApartInfoTemplate(1, 1, 3, 1, 3);
        testGetApartInfoTemplate(1, 1, 4, 1, 4);
        testGetApartInfoTemplate(1, 1, 18, 1, 18);

        // with 3 apartments at floor
        testGetApartInfoTemplate(1, 3, 1, 1, 1);
        testGetApartInfoTemplate(1, 3, 3, 1, 1);
        testGetApartInfoTemplate(1, 3, 4, 1, 2);
        testGetApartInfoTemplate(1, 3, 6, 1, 2);
        testGetApartInfoTemplate(1, 3, 6, 1, 2);
        testGetApartInfoTemplate(1, 3, 7, 1, 3);

        // with 6 apartments at floor
        testGetApartInfoTemplate(1, 6, 1, 1, 1);
        testGetApartInfoTemplate(1, 6, 6, 1, 1);
        testGetApartInfoTemplate(1, 6, 7, 1, 2);
        testGetApartInfoTemplate(1, 6, 10, 1, 2);
        testGetApartInfoTemplate(1, 6, 12, 1, 2);
        testGetApartInfoTemplate(1, 6, 13, 1, 3);

        // with 10 apartments at floor
        testGetApartInfoTemplate(1, 10, 1, 1, 1);
        testGetApartInfoTemplate(1, 10, 10, 1, 1);
        testGetApartInfoTemplate(1, 10, 11, 1, 2);
        testGetApartInfoTemplate(1, 10, 15, 1, 2);
        testGetApartInfoTemplate(1, 10, 20, 1, 2);
        testGetApartInfoTemplate(1, 10, 21, 1, 3);

        // with 32767 apartments at floor
        testGetApartInfoTemplate(1, INTMAX, 1, 1, 1);
        testGetApartInfoTemplate(1, INTMAX, INTMAX, 1, 1);
        testGetApartInfoTemplate(1, INTMAX, INTMAXBG.add(BigInteger.ONE), 1, 2);

        // with 2147483647 apartments at floor
        testGetApartInfoTemplate(1, LONGMAX, 1, 1, 1);
        testGetApartInfoTemplate(1, LONGMAX, LONGMAX, 1, 1);
        testGetApartInfoTemplate(1, LONGMAX, LONGMAXBG.add(BigInteger.ONE), 1, 2);

        // NEW HOUSE with 3 floors
        // with 1 apartment at floor
        testGetApartInfoTemplate(3, 1, 1, 1, 1);
        testGetApartInfoTemplate(3, 1, 3, 3, 1);
        testGetApartInfoTemplate(3, 1, 4, 1, 2);
        testGetApartInfoTemplate(3, 1, 5, 2, 2);
        testGetApartInfoTemplate(3, 1, 6, 3, 2);
        testGetApartInfoTemplate(3, 1, 7, 1, 3);
        testGetApartInfoTemplate(3, 1, 7, 1, 3);

        // with 3 apartments at floor
        testGetApartInfoTemplate(3, 3, 1, 1, 1);
        testGetApartInfoTemplate(3, 3, 3, 1, 1);
        testGetApartInfoTemplate(3, 3, 4, 2, 1);
        testGetApartInfoTemplate(3, 3, 7, 3, 1);
        testGetApartInfoTemplate(3, 3, 9, 3, 1);
        testGetApartInfoTemplate(3, 3, 10, 1, 2);
        testGetApartInfoTemplate(3, 3, 18, 3, 2);

        // with 6 apartments at floor
        testGetApartInfoTemplate(3, 6, 1, 1, 1);
        testGetApartInfoTemplate(3, 6, 6, 1, 1);
        testGetApartInfoTemplate(3, 6, 7, 2, 1);
        testGetApartInfoTemplate(3, 6, 13, 3, 1);
        testGetApartInfoTemplate(3, 6, 18, 3, 1);
        testGetApartInfoTemplate(3, 6, 19, 1, 2);
        testGetApartInfoTemplate(3, 6, 32, 3, 2);

        // with 10 apartments at floor
        testGetApartInfoTemplate(3, 10, 1, 1, 1);
        testGetApartInfoTemplate(3, 10, 10, 1, 1);
        testGetApartInfoTemplate(3, 10, 11, 2, 1);
        testGetApartInfoTemplate(3, 10, 28, 3, 1);
        testGetApartInfoTemplate(3, 10, 30, 3, 1);
        testGetApartInfoTemplate(3, 10, 31, 1, 2);
        testGetApartInfoTemplate(3, 10, 60, 3, 2);

        // with 32767 apartments at floor
        testGetApartInfoTemplate(3, INTMAX, 1, 1, 1);
        testGetApartInfoTemplate(3, INTMAX, INTMAX, 1, 1);
        testGetApartInfoTemplate(3, INTMAX, INTMAXBG.multiply(BigInteger.valueOf(3)), 3, 1);
        testGetApartInfoTemplate(3, INTMAX, INTMAXBG.multiply(BigInteger.valueOf(3)).add(BigInteger.ONE), 1, 2);

        // with 2147483647 apartments at floor
        testGetApartInfoTemplate(3, LONGMAX, 1, 1, 1);
        testGetApartInfoTemplate(3, LONGMAX, LONGMAX, 1, 1);
        testGetApartInfoTemplate(3, LONGMAX, LONGMAXBG.multiply(BigInteger.valueOf(3)), 3, 1);
        testGetApartInfoTemplate(3, LONGMAX, LONGMAXBG.multiply(BigInteger.valueOf(3)).add(BigInteger.ONE), 1, 2);

        // NEW HOUSE with 6 floors
        // with 1 apartment at floor
        testGetApartInfoTemplate(6, 1, 1, 1, 1);
        testGetApartInfoTemplate(6, 1, 6, 6, 1);
        testGetApartInfoTemplate(6, 1, 7, 1, 2);
        testGetApartInfoTemplate(6, 1, 9, 3, 2);
        testGetApartInfoTemplate(6, 1, 12, 6, 2);
        testGetApartInfoTemplate(6, 1, 13, 1, 3);

        // with 3 apartments at floor
        testGetApartInfoTemplate(6, 3, 1, 1, 1);
        testGetApartInfoTemplate(6, 3, 3, 1, 1);
        testGetApartInfoTemplate(6, 3, 4, 2, 1);
        testGetApartInfoTemplate(6, 3, 12, 4, 1);
        testGetApartInfoTemplate(6, 3, 18, 6, 1);
        testGetApartInfoTemplate(6, 3, 19, 1, 2);

        // with 6 apartments at floor
        testGetApartInfoTemplate(6, 6, 1, 1, 1);
        testGetApartInfoTemplate(6, 6, 6, 1, 1);
        testGetApartInfoTemplate(6, 6, 7, 2, 1);
        testGetApartInfoTemplate(6, 6, 36, 6, 1);
        testGetApartInfoTemplate(6, 6, 37, 1, 2);

        // with 10 apartments at floor
        testGetApartInfoTemplate(6, 10, 1, 1, 1);
        testGetApartInfoTemplate(6, 10, 10, 1, 1);
        testGetApartInfoTemplate(6, 10, 11, 2, 1);
        testGetApartInfoTemplate(6, 10, 60, 6, 1);
        testGetApartInfoTemplate(6, 10, 61, 1, 2);

        // with 32767 apartments at floor
        testGetApartInfoTemplate(6, INTMAX, 1, 1, 1);
        testGetApartInfoTemplate(6, INTMAX, INTMAX, 1, 1);
        testGetApartInfoTemplate(6, INTMAX, INTMAXBG.multiply(BigInteger.valueOf(6)), 6, 1);
        testGetApartInfoTemplate(6, INTMAX, INTMAXBG.multiply(BigInteger.valueOf(6)).add(BigInteger.ONE), 1, 2);

        // with 2147483647 apartments at floor
        testGetApartInfoTemplate(6, LONGMAX, 1, 1, 1);
        testGetApartInfoTemplate(6, LONGMAX, LONGMAX, 1, 1);
        testGetApartInfoTemplate(6, LONGMAX, LONGMAXBG.multiply(BigInteger.valueOf(6)), 6, 1);
        testGetApartInfoTemplate(6, LONGMAX, LONGMAXBG.multiply(BigInteger.valueOf(6)).add(BigInteger.ONE), 1, 2);

        // NEW HOUSE with 12 floors
        // with 5 apartments at floor
        testGetApartInfoTemplate(12, 5, 1, 1, 1);
        testGetApartInfoTemplate(12, 5, 5, 1, 1);
        testGetApartInfoTemplate(12, 5, 6, 2, 1);
        testGetApartInfoTemplate(12, 5, 21, 5, 1);
        testGetApartInfoTemplate(12, 5, 24, 5, 1);
        testGetApartInfoTemplate(12, 5, 25, 5, 1);
        testGetApartInfoTemplate(12, 5, 30, 6, 1);
        testGetApartInfoTemplate(12, 5, 31, 7, 1);
        testGetApartInfoTemplate(12, 5, 32, 7, 1);
        testGetApartInfoTemplate(12, 5, 59, 12, 1);
        testGetApartInfoTemplate(12, 5, 60, 12, 1);
        testGetApartInfoTemplate(12, 5, 61, 1, 2);

        // with 10 apartments at floor
        testGetApartInfoTemplate(12, 10, 1, 1, 1);
        testGetApartInfoTemplate(12, 10, 10, 1, 1);
        testGetApartInfoTemplate(12, 10, 11, 2, 1);
        testGetApartInfoTemplate(12, 10, 39, 4, 1);
        testGetApartInfoTemplate(12, 10, 40, 4, 1);
        testGetApartInfoTemplate(12, 10, 41, 5, 1);
        testGetApartInfoTemplate(12, 10, 63, 7, 1);
        testGetApartInfoTemplate(12, 10, 98, 10, 1);
        testGetApartInfoTemplate(12, 10, 99, 10, 1);
        testGetApartInfoTemplate(12, 10, 120, 12, 1);
        testGetApartInfoTemplate(12, 10, 121, 1, 2);

        // with 32767 apartments at floor
        testGetApartInfoTemplate(12, INTMAX, 1, 1, 1);
        testGetApartInfoTemplate(12, INTMAX, INTMAX, 1, 1);
        testGetApartInfoTemplate(12, INTMAX, INTMAXBG.multiply(BigInteger.valueOf(12)), 12, 1);
        testGetApartInfoTemplate(12, INTMAX, INTMAXBG.multiply(BigInteger.valueOf(12)).add(BigInteger.ONE), 1, 2);
        // with 2147483647 apartments at floor
        testGetApartInfoTemplate(12, LONGMAX, 1, 1, 1);
        testGetApartInfoTemplate(12, LONGMAX, LONGMAX, 1, 1);
        testGetApartInfoTemplate(12, LONGMAX, LONGMAXBG.multiply(BigInteger.valueOf(12)), 12, 1);
        testGetApartInfoTemplate(12, LONGMAX, LONGMAXBG.multiply(BigInteger.valueOf(12)).add(BigInteger.ONE), 1, 2);

        // NEW HOUSE with 9 floors
        // with 5 apartments at floor
        testGetApartInfoTemplate(9, 5, 1, 1, 1);
        testGetApartInfoTemplate(9, 5, 5, 1, 1);
        testGetApartInfoTemplate(9, 5, 6, 2, 1);
        testGetApartInfoTemplate(9, 5, 21, 5, 1);
        testGetApartInfoTemplate(9, 5, 24, 5, 1);
        testGetApartInfoTemplate(9, 5, 25, 5, 1);
        testGetApartInfoTemplate(9, 5, 26, 6, 1);
        testGetApartInfoTemplate(9, 5, 27, 6, 1);
        testGetApartInfoTemplate(9, 5, 44, 9, 1);
        testGetApartInfoTemplate(9, 5, 45, 9, 1);
        testGetApartInfoTemplate(9, 5, 46, 1, 2);

        // with 10 apartments at floor
        testGetApartInfoTemplate(9, 10, 1, 1, 1);
        testGetApartInfoTemplate(9, 10, 11, 2, 1);
        testGetApartInfoTemplate(9, 10, 40, 4, 1);
        testGetApartInfoTemplate(9, 10, 41, 5, 1);
        testGetApartInfoTemplate(9, 10, 44, 5, 1);
        testGetApartInfoTemplate(9, 10, 45, 5, 1);
        testGetApartInfoTemplate(9, 10, 46, 5, 1);
        testGetApartInfoTemplate(9, 10, 50, 5, 1);
        testGetApartInfoTemplate(9, 10, 90, 9, 1);
        testGetApartInfoTemplate(9, 10, 91, 1, 2);
        testGetApartInfoTemplate(9, 10, 180, 9, 2);

        // with 32767 apartments at floor
        testGetApartInfoTemplate(9, INTMAX, 1, 1, 1);
        testGetApartInfoTemplate(9, INTMAX, INTMAX, 1, 1);
        testGetApartInfoTemplate(9, INTMAX, INTMAXBG.multiply(BigInteger.valueOf(9)), 9, 1);
        testGetApartInfoTemplate(9, INTMAX, INTMAXBG.multiply(BigInteger.valueOf(9)).add(BigInteger.ONE), 1, 2);

        // with 2147483647 apartments at floor
        testGetApartInfoTemplate(9, Long.MAX_VALUE, 1, 1, 1);
        testGetApartInfoTemplate(9, Long.MAX_VALUE, Long.MAX_VALUE, 1, 1);
        testGetApartInfoTemplate(9, LONGMAX, LONGMAXBG.multiply(BigInteger.valueOf(9)), 9, 1);
        testGetApartInfoTemplate(9, LONGMAX, LONGMAXBG.multiply(BigInteger.valueOf(9)).add(BigInteger.ONE), 1, 2);

        // LOOKING FOR Integer.MAX_VALUE AND Long.MAX_VALUE HOUSES
        // house with 32767 apartments at each floor and 32767 floor count
        testGetApartInfoTemplate(INTMAX, INTMAX, 1, 1, 1);
        testGetApartInfoTemplate(INTMAX, INTMAX, Integer.MAX_VALUE, 1, 1);
        testGetApartInfoTemplate(INTMAX, INTMAX, INTMAXBG.add(BigInteger.ONE), 2, 1);
        testGetApartInfoTemplate(INTMAX, INTMAX, INTMAXBG.multiply(INTMAXBG), INTMAX, 1);
        testGetApartInfoTemplate(INTMAX, INTMAX, INTMAXBG.multiply(INTMAXBG).add(BigInteger.ONE), 1, 2);

        // house with 2147483647 apartments at each floor and 2147483647 floor count
        testGetApartInfoTemplate(LONGMAX, LONGMAX, 1, 1, 1);
        testGetApartInfoTemplate(LONGMAX, LONGMAX, LONGMAX, 1, 1);
        testGetApartInfoTemplate(LONGMAX, LONGMAX, LONGMAXBG.add(BigInteger.ONE), 2, 1);
        testGetApartInfoTemplate(LONGMAX, LONGMAX, LONGMAXBG.multiply(LONGMAXBG), LONGMAX, 1);
        testGetApartInfoTemplate(LONGMAX, LONGMAX, LONGMAXBG.multiply(LONGMAXBG).add(BigInteger.ONE), 1, 2);
    }

    @Test
    public void testGetApartInfoWithWrongValues() {

        // testing wrong 1st value
        testGetApartInfoUnrealValuesTemplate(0, 1, 1);
        testGetApartInfoUnrealValuesTemplate(-1, 1, 1);
        testGetApartInfoUnrealValuesTemplate(Integer.MIN_VALUE, 1, 1);
        testGetApartInfoUnrealValuesTemplate(Long.MIN_VALUE, 1, 1);

        // testing wrong 2nd value
        testGetApartInfoUnrealValuesTemplate(1, 0, 1);
        testGetApartInfoUnrealValuesTemplate(1, -1, 1);
        testGetApartInfoUnrealValuesTemplate(1, Integer.MIN_VALUE, 1);
        testGetApartInfoUnrealValuesTemplate(1, Long.MIN_VALUE, 1);

        // testing wrong 3rd value
        testGetApartInfoUnrealValuesTemplate(1, 1, 0);
        testGetApartInfoUnrealValuesTemplate(1, 1, -1);
        testGetApartInfoUnrealValuesTemplate(1, 1, Integer.MIN_VALUE);
        testGetApartInfoUnrealValuesTemplate(1, 1, Long.MIN_VALUE);

        // testing wrong 1st and 2nd value
        testGetApartInfoUnrealValuesTemplate(0, 0, 1);
        testGetApartInfoUnrealValuesTemplate(-1, -1, 1);
        testGetApartInfoUnrealValuesTemplate(Integer.MIN_VALUE, Integer.MIN_VALUE, 1);
        testGetApartInfoUnrealValuesTemplate(Long.MIN_VALUE, Long.MIN_VALUE, 1);

        // testing wrong 1st and 3rd value
        testGetApartInfoUnrealValuesTemplate(0, 1, 0);
        testGetApartInfoUnrealValuesTemplate(-1, 1, -1);
        testGetApartInfoUnrealValuesTemplate(Integer.MIN_VALUE, 1, Integer.MIN_VALUE);
        testGetApartInfoUnrealValuesTemplate(Long.MIN_VALUE, 1, Long.MIN_VALUE);

        // testing wrong 2nd and 3rd value
        testGetApartInfoUnrealValuesTemplate(1, 0, 0);
        testGetApartInfoUnrealValuesTemplate(1, -1, -1);
        testGetApartInfoUnrealValuesTemplate(1, Integer.MIN_VALUE, Integer.MIN_VALUE);
        testGetApartInfoUnrealValuesTemplate(1, Long.MIN_VALUE, Long.MIN_VALUE);

        // testing wrong 1st, 2nd and 3rd value
        testGetApartInfoUnrealValuesTemplate(0, 0, 0);
        testGetApartInfoUnrealValuesTemplate(-1, -1, -1);
        testGetApartInfoUnrealValuesTemplate(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
        testGetApartInfoUnrealValuesTemplate(Long.MIN_VALUE, Long.MIN_VALUE, Long.MIN_VALUE);
    }
}