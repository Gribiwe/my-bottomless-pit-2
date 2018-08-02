package second;

import java.math.BigInteger;
import java.util.Scanner;

public class ApartmentFinder {
    private static ApartmentFinder instance;

    public static ApartmentFinder getInstance() {

        if (instance == null) {
            instance = new ApartmentFinder();
        }

        return instance;
    }

    public BigInteger getEntrance(BigInteger floorCount, BigInteger apartmentsAtFloor, BigInteger apartNumber) {
        BigInteger entranceApartCount = getEntranceApartCount(floorCount, apartmentsAtFloor);
        return (apartNumber.add(BigInteger.ONE.negate())).divide(entranceApartCount).add(BigInteger.ONE);
    }

    public BigInteger getEntranceApartCount(BigInteger floorCount, BigInteger apartmentsAtFloor) {
        return floorCount.multiply(apartmentsAtFloor);
    }

    public BigInteger getFloor(BigInteger floorCount, BigInteger apartmentsAtFloor, BigInteger apartNumber) {

        return (((apartNumber.add(BigInteger.ONE.negate()))
                .add((getEntrance(floorCount, apartmentsAtFloor, apartNumber)
                        .add(BigInteger.ONE.negate()).negate()).multiply(getEntranceApartCount(floorCount, apartmentsAtFloor))))
                .divide(apartmentsAtFloor)).add(BigInteger.ONE);

    }

    public ApartmentInfo getApartInfo(BigInteger floorCount, BigInteger apartmentsAtFloor, BigInteger apartNumber) {

        if (floorCount.compareTo(BigInteger.ZERO) < 1) {
            System.out.println("Value of floor is incorrect");
            return null;
        } else if (apartmentsAtFloor.compareTo(BigInteger.ZERO) < 1) {
            System.out.println("Value of apartments at floor is incorrect");
            return null;
        } else if (apartNumber.compareTo(BigInteger.ZERO) < 1 ) {
            System.out.println("Value of apartment number is incorrect");
            return null;
        }

        BigInteger entrance = getEntrance(floorCount, apartmentsAtFloor, apartNumber);
        BigInteger floor = getFloor(floorCount, apartmentsAtFloor, apartNumber);

        return new ApartmentInfo(floor, entrance);
    }


    public void showMenu(Scanner scanner) {
        System.out.println("How many floors?");
        BigInteger floorCount = scanner.nextBigInteger();

        System.out.println("How many apartments on floor?");
        BigInteger apartmentsAtFloor = scanner.nextBigInteger();

        System.out.println("What apartment you want to find?");
        BigInteger apartNumber = scanner.nextBigInteger();

        ApartmentInfo result = getApartInfo(floorCount, apartmentsAtFloor, apartNumber);
        if (result != null) {
            System.out.println("entrance: " + result.getEntrance());
            System.out.println("floor: " + result.getFloor());
        }
    }
}
