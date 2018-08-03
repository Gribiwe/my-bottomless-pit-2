import exception.GribiweException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import second.ApartmentFinder;
import second.ApartmentInfo;

import java.math.BigInteger;

public class ApartmentFinderTest extends Assert {
    private static ApartmentFinder testApartmentFinder;

    private static final BigInteger LONG_MAX_BI = BigInteger.valueOf(Long.MAX_VALUE);
    private static final BigInteger INT_MAX_BI = BigInteger.valueOf(Integer.MAX_VALUE);

    private static final long INT_MAX = Integer.MAX_VALUE;
    private static final long LONG_MAX = Long.MAX_VALUE;

    @BeforeClass
    public static void runApartmentFinder() {
        testApartmentFinder = new ApartmentFinder();
    }

    @Test
    public void testGetApartInfo() {

        // NEW HOUSE with 1 floor
        // with 1 apartment at floor
        testGetApartInfo(1, 1, 1, 1, 1);
        testGetApartInfo(1, 1, 2, 1, 2);
        testGetApartInfo(1, 1, 3, 1, 3);
        testGetApartInfo(1, 1, 4, 1, 4);
        testGetApartInfo(1, 1, 18, 1, 18);

        // with 3 apartments at floor
        testGetApartInfo(1, 3, 1, 1, 1);
        testGetApartInfo(1, 3, 3, 1, 1);
        testGetApartInfo(1, 3, 4, 1, 2);
        testGetApartInfo(1, 3, 6, 1, 2);
        testGetApartInfo(1, 3, 6, 1, 2);
        testGetApartInfo(1, 3, 7, 1, 3);

        // with 6 apartments at floor
        testGetApartInfo(1, 6, 1, 1, 1);
        testGetApartInfo(1, 6, 6, 1, 1);
        testGetApartInfo(1, 6, 7, 1, 2);
        testGetApartInfo(1, 6, 10, 1, 2);
        testGetApartInfo(1, 6, 12, 1, 2);
        testGetApartInfo(1, 6, 13, 1, 3);

        // with 10 apartments at floor
        testGetApartInfo(1, 10, 1, 1, 1);
        testGetApartInfo(1, 10, 10, 1, 1);
        testGetApartInfo(1, 10, 11, 1, 2);
        testGetApartInfo(1, 10, 15, 1, 2);
        testGetApartInfo(1, 10, 20, 1, 2);
        testGetApartInfo(1, 10, 21, 1, 3);

        // with Integer.MAX_VALUE apartments at floor
        testGetApartInfo(1, INT_MAX, 1, 1, 1);
        testGetApartInfo(1, INT_MAX, INT_MAX, 1, 1);
        testGetApartInfo(1, INT_MAX, INT_MAX_BI.add(BigInteger.ONE), 1, 2);

        // with Long.MAX_VALUE apartments at floor
        testGetApartInfo(1, LONG_MAX, 1, 1, 1);
        testGetApartInfo(1, LONG_MAX, LONG_MAX, 1, 1);
        testGetApartInfo(1, LONG_MAX, LONG_MAX_BI.add(BigInteger.ONE), 1, 2);

        // NEW HOUSE with 3 floors
        // with 1 apartment at floor
        testGetApartInfo(3, 1, 1, 1, 1);
        testGetApartInfo(3, 1, 3, 3, 1);
        testGetApartInfo(3, 1, 4, 1, 2);
        testGetApartInfo(3, 1, 5, 2, 2);
        testGetApartInfo(3, 1, 6, 3, 2);
        testGetApartInfo(3, 1, 7, 1, 3);
        testGetApartInfo(3, 1, 7, 1, 3);

        // with 3 apartments at floor
        testGetApartInfo(3, 3, 1, 1, 1);
        testGetApartInfo(3, 3, 3, 1, 1);
        testGetApartInfo(3, 3, 4, 2, 1);
        testGetApartInfo(3, 3, 7, 3, 1);
        testGetApartInfo(3, 3, 9, 3, 1);
        testGetApartInfo(3, 3, 10, 1, 2);
        testGetApartInfo(3, 3, 18, 3, 2);

        // with 6 apartments at floor
        testGetApartInfo(3, 6, 1, 1, 1);
        testGetApartInfo(3, 6, 6, 1, 1);
        testGetApartInfo(3, 6, 7, 2, 1);
        testGetApartInfo(3, 6, 13, 3, 1);
        testGetApartInfo(3, 6, 18, 3, 1);
        testGetApartInfo(3, 6, 19, 1, 2);
        testGetApartInfo(3, 6, 32, 3, 2);

        // with 10 apartments at floor
        testGetApartInfo(3, 10, 1, 1, 1);
        testGetApartInfo(3, 10, 10, 1, 1);
        testGetApartInfo(3, 10, 11, 2, 1);
        testGetApartInfo(3, 10, 28, 3, 1);
        testGetApartInfo(3, 10, 30, 3, 1);
        testGetApartInfo(3, 10, 31, 1, 2);
        testGetApartInfo(3, 10, 60, 3, 2);

        // with Integer.MAX_VALUE apartments at floor
        testGetApartInfo(3, INT_MAX, 1, 1, 1);
        testGetApartInfo(3, INT_MAX, INT_MAX, 1, 1);
        testGetApartInfo(3, INT_MAX, INT_MAX_BI.multiply(BigInteger.valueOf(3)), 3, 1);
        testGetApartInfo(3, INT_MAX, INT_MAX_BI.multiply(BigInteger.valueOf(3)).add(BigInteger.ONE), 1, 2);

        // with Long.MAX_VALUE apartments at floor
        testGetApartInfo(3, LONG_MAX, 1, 1, 1);
        testGetApartInfo(3, LONG_MAX, LONG_MAX, 1, 1);
        testGetApartInfo(3, LONG_MAX, LONG_MAX_BI.multiply(BigInteger.valueOf(3)), 3, 1);
        testGetApartInfo(3, LONG_MAX, LONG_MAX_BI.multiply(BigInteger.valueOf(3)).add(BigInteger.ONE), 1, 2);

        // NEW HOUSE with 6 floors
        // with 1 apartment at floor
        testGetApartInfo(6, 1, 1, 1, 1);
        testGetApartInfo(6, 1, 6, 6, 1);
        testGetApartInfo(6, 1, 7, 1, 2);
        testGetApartInfo(6, 1, 9, 3, 2);
        testGetApartInfo(6, 1, 12, 6, 2);
        testGetApartInfo(6, 1, 13, 1, 3);

        // with 3 apartments at floor
        testGetApartInfo(6, 3, 1, 1, 1);
        testGetApartInfo(6, 3, 3, 1, 1);
        testGetApartInfo(6, 3, 4, 2, 1);
        testGetApartInfo(6, 3, 12, 4, 1);
        testGetApartInfo(6, 3, 18, 6, 1);
        testGetApartInfo(6, 3, 19, 1, 2);

        // with 6 apartments at floor
        testGetApartInfo(6, 6, 1, 1, 1);
        testGetApartInfo(6, 6, 6, 1, 1);
        testGetApartInfo(6, 6, 7, 2, 1);
        testGetApartInfo(6, 6, 36, 6, 1);
        testGetApartInfo(6, 6, 37, 1, 2);

        // with 10 apartments at floor
        testGetApartInfo(6, 10, 1, 1, 1);
        testGetApartInfo(6, 10, 10, 1, 1);
        testGetApartInfo(6, 10, 11, 2, 1);
        testGetApartInfo(6, 10, 60, 6, 1);
        testGetApartInfo(6, 10, 61, 1, 2);

        // with Integer.MAX_VALUE apartments at floor
        testGetApartInfo(6, INT_MAX, 1, 1, 1);
        testGetApartInfo(6, INT_MAX, INT_MAX, 1, 1);
        testGetApartInfo(6, INT_MAX, INT_MAX_BI.multiply(BigInteger.valueOf(6)), 6, 1);
        testGetApartInfo(6, INT_MAX, INT_MAX_BI.multiply(BigInteger.valueOf(6)).add(BigInteger.ONE), 1, 2);

        // with Long.MAX_VALUE apartments at floor
        testGetApartInfo(6, LONG_MAX, 1, 1, 1);
        testGetApartInfo(6, LONG_MAX, LONG_MAX, 1, 1);
        testGetApartInfo(6, LONG_MAX, LONG_MAX_BI.multiply(BigInteger.valueOf(6)), 6, 1);
        testGetApartInfo(6, LONG_MAX, LONG_MAX_BI.multiply(BigInteger.valueOf(6)).add(BigInteger.ONE), 1, 2);

        // NEW HOUSE with 12 floors
        // with 5 apartments at floor
        testGetApartInfo(12, 5, 1, 1, 1);
        testGetApartInfo(12, 5, 5, 1, 1);
        testGetApartInfo(12, 5, 6, 2, 1);
        testGetApartInfo(12, 5, 21, 5, 1);
        testGetApartInfo(12, 5, 24, 5, 1);
        testGetApartInfo(12, 5, 25, 5, 1);
        testGetApartInfo(12, 5, 30, 6, 1);
        testGetApartInfo(12, 5, 31, 7, 1);
        testGetApartInfo(12, 5, 32, 7, 1);
        testGetApartInfo(12, 5, 59, 12, 1);
        testGetApartInfo(12, 5, 60, 12, 1);
        testGetApartInfo(12, 5, 61, 1, 2);

        // with 10 apartments at floor
        testGetApartInfo(12, 10, 1, 1, 1);
        testGetApartInfo(12, 10, 10, 1, 1);
        testGetApartInfo(12, 10, 11, 2, 1);
        testGetApartInfo(12, 10, 39, 4, 1);
        testGetApartInfo(12, 10, 40, 4, 1);
        testGetApartInfo(12, 10, 41, 5, 1);
        testGetApartInfo(12, 10, 63, 7, 1);
        testGetApartInfo(12, 10, 98, 10, 1);
        testGetApartInfo(12, 10, 99, 10, 1);
        testGetApartInfo(12, 10, 120, 12, 1);
        testGetApartInfo(12, 10, 121, 1, 2);

        // with Integer.MAX_VALUE apartments at floor
        testGetApartInfo(12, INT_MAX, 1, 1, 1);
        testGetApartInfo(12, INT_MAX, INT_MAX, 1, 1);
        testGetApartInfo(12, INT_MAX, INT_MAX_BI.multiply(BigInteger.valueOf(12)), 12, 1);
        testGetApartInfo(12, INT_MAX, INT_MAX_BI.multiply(BigInteger.valueOf(12)).add(BigInteger.ONE), 1, 2);
        // with Long.MAX_VALUE apartments at floor
        testGetApartInfo(12, LONG_MAX, 1, 1, 1);
        testGetApartInfo(12, LONG_MAX, LONG_MAX, 1, 1);
        testGetApartInfo(12, LONG_MAX, LONG_MAX_BI.multiply(BigInteger.valueOf(12)), 12, 1);
        testGetApartInfo(12, LONG_MAX, LONG_MAX_BI.multiply(BigInteger.valueOf(12)).add(BigInteger.ONE), 1, 2);

        // NEW HOUSE with 9 floors
        // with 5 apartments at floor
        testGetApartInfo(9, 5, 1, 1, 1);
        testGetApartInfo(9, 5, 5, 1, 1);
        testGetApartInfo(9, 5, 6, 2, 1);
        testGetApartInfo(9, 5, 21, 5, 1);
        testGetApartInfo(9, 5, 24, 5, 1);
        testGetApartInfo(9, 5, 25, 5, 1);
        testGetApartInfo(9, 5, 26, 6, 1);
        testGetApartInfo(9, 5, 27, 6, 1);
        testGetApartInfo(9, 5, 44, 9, 1);
        testGetApartInfo(9, 5, 45, 9, 1);
        testGetApartInfo(9, 5, 46, 1, 2);

        // with 10 apartments at floor
        testGetApartInfo(9, 10, 1, 1, 1);
        testGetApartInfo(9, 10, 11, 2, 1);
        testGetApartInfo(9, 10, 40, 4, 1);
        testGetApartInfo(9, 10, 41, 5, 1);
        testGetApartInfo(9, 10, 44, 5, 1);
        testGetApartInfo(9, 10, 45, 5, 1);
        testGetApartInfo(9, 10, 46, 5, 1);
        testGetApartInfo(9, 10, 50, 5, 1);
        testGetApartInfo(9, 10, 90, 9, 1);
        testGetApartInfo(9, 10, 91, 1, 2);
        testGetApartInfo(9, 10, 180, 9, 2);

        // with Integer.MAX_VALUE apartments at floor
        testGetApartInfo(9, INT_MAX, 1, 1, 1);
        testGetApartInfo(9, INT_MAX, INT_MAX, 1, 1);
        testGetApartInfo(9, INT_MAX, INT_MAX_BI.multiply(BigInteger.valueOf(9)), 9, 1);
        testGetApartInfo(9, INT_MAX, INT_MAX_BI.multiply(BigInteger.valueOf(9)).add(BigInteger.ONE), 1, 2);

        // with Long.MAX_VALUE apartments at floor
        testGetApartInfo(9, Long.MAX_VALUE, 1, 1, 1);
        testGetApartInfo(9, Long.MAX_VALUE, Long.MAX_VALUE, 1, 1);
        testGetApartInfo(9, LONG_MAX, LONG_MAX_BI.multiply(BigInteger.valueOf(9)), 9, 1);
        testGetApartInfo(9, LONG_MAX, LONG_MAX_BI.multiply(BigInteger.valueOf(9)).add(BigInteger.ONE), 1, 2);

        // LOOKING FOR Integer.MAX_VALUE AND Long.MAX_VALUE HOUSES
        // house with Integer.MAX_VALUE apartments at each floor and Integer.MAX_VALUE floor count
        testGetApartInfo(INT_MAX, INT_MAX, 1, 1, 1);
        testGetApartInfo(INT_MAX, INT_MAX, Integer.MAX_VALUE, 1, 1);
        testGetApartInfo(INT_MAX, INT_MAX, INT_MAX_BI.add(BigInteger.ONE), 2, 1);
        testGetApartInfo(INT_MAX, INT_MAX, INT_MAX_BI.multiply(INT_MAX_BI), INT_MAX, 1);
        testGetApartInfo(INT_MAX, INT_MAX, INT_MAX_BI.multiply(INT_MAX_BI).add(BigInteger.ONE), 1, 2);

        // house with Long.MAX_VALUE apartments at each floor and Long.MAX_VALUE floor count
        testGetApartInfo(LONG_MAX, LONG_MAX, 1, 1, 1);
        testGetApartInfo(LONG_MAX, LONG_MAX, LONG_MAX, 1, 1);
        testGetApartInfo(LONG_MAX, LONG_MAX, LONG_MAX_BI.add(BigInteger.ONE), 2, 1);
        testGetApartInfo(LONG_MAX, LONG_MAX, LONG_MAX_BI.multiply(LONG_MAX_BI), LONG_MAX, 1);
        testGetApartInfo(LONG_MAX, LONG_MAX, LONG_MAX_BI.multiply(LONG_MAX_BI).add(BigInteger.ONE), 1, 2);
    }

    @Test
    public void testGetApartInfoWithWrongValues() {

        // testing wrong 1st value
        testGetApartInfoUnrealValues(0, 1, 1);
        testGetApartInfoUnrealValues(-1, 1, 1);
        testGetApartInfoUnrealValues(Integer.MIN_VALUE, 1, 1);
        testGetApartInfoUnrealValues(Long.MIN_VALUE, 1, 1);

        // testing wrong 2nd value
        testGetApartInfoUnrealValues(1, 0, 1);
        testGetApartInfoUnrealValues(1, -1, 1);
        testGetApartInfoUnrealValues(1, Integer.MIN_VALUE, 1);
        testGetApartInfoUnrealValues(1, Long.MIN_VALUE, 1);

        // testing wrong 3rd value
        testGetApartInfoUnrealValues(1, 1, 0);
        testGetApartInfoUnrealValues(1, 1, -1);
        testGetApartInfoUnrealValues(1, 1, Integer.MIN_VALUE);
        testGetApartInfoUnrealValues(1, 1, Long.MIN_VALUE);

        // testing wrong 1st and 2nd value
        testGetApartInfoUnrealValues(0, 0, 1);
        testGetApartInfoUnrealValues(-1, -1, 1);
        testGetApartInfoUnrealValues(Integer.MIN_VALUE, Integer.MIN_VALUE, 1);
        testGetApartInfoUnrealValues(Long.MIN_VALUE, Long.MIN_VALUE, 1);

        // testing wrong 1st and 3rd value
        testGetApartInfoUnrealValues(0, 1, 0);
        testGetApartInfoUnrealValues(-1, 1, -1);
        testGetApartInfoUnrealValues(Integer.MIN_VALUE, 1, Integer.MIN_VALUE);
        testGetApartInfoUnrealValues(Long.MIN_VALUE, 1, Long.MIN_VALUE);

        // testing wrong 2nd and 3rd value
        testGetApartInfoUnrealValues(1, 0, 0);
        testGetApartInfoUnrealValues(1, -1, -1);
        testGetApartInfoUnrealValues(1, Integer.MIN_VALUE, Integer.MIN_VALUE);
        testGetApartInfoUnrealValues(1, Long.MIN_VALUE, Long.MIN_VALUE);

        // testing wrong 1st, 2nd and 3rd value
        testGetApartInfoUnrealValues(0, 0, 0);
        testGetApartInfoUnrealValues(-1, -1, -1);
        testGetApartInfoUnrealValues(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
        testGetApartInfoUnrealValues(Long.MIN_VALUE, Long.MIN_VALUE, Long.MIN_VALUE);
    }

   @Test
   public void testGetApartInfoNull() {
         testGetApartInfoNull(null, null, null);
         testGetApartInfoNull(null, BigInteger.ONE, BigInteger.ONE);
         testGetApartInfoNull(BigInteger.ONE, null, BigInteger.ONE);
         testGetApartInfoNull(BigInteger.ONE, BigInteger.ONE, null);
   }

   public void testGetApartInfoNull(BigInteger floors, BigInteger apartmentsAtFloor, BigInteger apartmentNumber) {
         Assertions.assertThrows(GribiweException.class, () -> testApartmentFinder.getApartInfo(floors, apartmentsAtFloor, apartmentNumber));
   }

   private void testGetApartInfo(String floors, String apartmentsAtFloor, String apartmentNumber, String realFloor, String realEntrance) {
      ApartmentInfo testingApartment = testApartmentFinder.getApartInfo(
              new BigInteger(floors), new BigInteger(apartmentsAtFloor), new BigInteger(apartmentNumber));
      assertEquals(testingApartment.getEntrance().compareTo(new BigInteger(realEntrance)), 0);
      assertEquals(testingApartment.getFloor().compareTo(new BigInteger(realFloor)), 0);
   }

   private void testGetApartInfo(long floors, long apartmentsAtFloor, long apartmentNumber, long realFloor, long realEntrance) {
      testGetApartInfo(floors+"", apartmentsAtFloor+"",
              apartmentNumber+"", realFloor+"", realEntrance+"");
   }
   private void testGetApartInfo(long floors, long apartmentsAtFloor, BigInteger apartmentNumber, long realFloor, long realEntrance) {
      testGetApartInfo(floors+"", apartmentsAtFloor+"",
              apartmentNumber+"", realFloor+"", realEntrance+"");
   }

   private void testGetApartInfoUnrealValues(long floors, long apartmentsAtFloor, long apartmentNumber) {
      Assertions.assertThrows(GribiweException.class,
              () -> testApartmentFinder.getApartInfo(BigInteger.valueOf(floors),
                      BigInteger.valueOf(apartmentsAtFloor), BigInteger.valueOf(apartmentNumber)));
   }
}