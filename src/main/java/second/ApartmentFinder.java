package second;

import exception.GribiweException;

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ApartmentFinder {

   public ApartmentInfo getApartInfo(BigInteger floorsAtEntrance, BigInteger apartmentsAtFloor, BigInteger apartmentNumber) {

      if (floorsAtEntrance.compareTo(BigInteger.ONE) < 0)
         throw new GribiweException("Incorrect number of floors at entrance." +
                 "The lowest possible number is 1. Your is: " + floorsAtEntrance);

      if (apartmentsAtFloor.compareTo(BigInteger.ONE) < 0)
         throw new GribiweException("Incorrect number of apartments at floor." +
                 "The lowest possible number is 1. Your is: " + apartmentsAtFloor);

      if (apartmentNumber.compareTo(BigInteger.ONE) < 0)
         throw new GribiweException("Incorrect number of apartment number." +
                 "The lowest possible number is 1. Your is: " + apartmentNumber);


      BigInteger apartmentsAtEntrance = floorsAtEntrance.multiply(apartmentsAtFloor);

      BigInteger entrance = (apartmentNumber.add(BigInteger.ONE.negate()))
              .divide(apartmentsAtEntrance).add(BigInteger.ONE);

      BigInteger apartmentsAtPreviousEntrances = (entrance.add(BigInteger.ONE.negate()).negate())
              .multiply(apartmentsAtEntrance);

      BigInteger apartmentIndexAtEntrance = ((apartmentNumber.add(BigInteger.ONE.negate()))
              .add(apartmentsAtPreviousEntrances));

      BigInteger floor = apartmentIndexAtEntrance.divide(apartmentsAtFloor).add(BigInteger.ONE);

      return new ApartmentInfo(floor, entrance);
   }


   public void showMenu() {
      Scanner scanner = new Scanner(System.in);

      System.out.println("How many floors?");
      BigInteger floorsAtEntrance;
      try {
         floorsAtEntrance = scanner.nextBigInteger();
      } catch (InputMismatchException e) {
         throw new GribiweException("You have entered stroke, which doesn't match the Integer: " + scanner.next());
      }

      if (floorsAtEntrance.compareTo(BigInteger.ONE) < 0)
         throw new GribiweException("Incorrect number of floors at entrance." +
                 "The lowest possible number is 1. Your is: " + floorsAtEntrance);

      System.out.println("How many apartments on floor?");
      BigInteger apartmentsAtFloor;
      try {
         apartmentsAtFloor = scanner.nextBigInteger();
      } catch (InputMismatchException e) {
         throw new GribiweException("You have entered stroke, which doesn't match the Integer: " + scanner.next());
      }
      if (apartmentsAtFloor.compareTo(BigInteger.ONE) < 0)
         throw new GribiweException("Incorrect number of apartments at floor." +
                 "The lowest possible number is 1. Your is: " + apartmentsAtFloor);


      System.out.println("What apartment you want to find?");
      BigInteger apartmentNumber;
      try {
         apartmentNumber = scanner.nextBigInteger();
      } catch (InputMismatchException e) {
         throw new GribiweException("You have entered stroke, which doesn't match the Integer: " + scanner.next());
      }
      if (apartmentNumber.compareTo(BigInteger.ONE) < 0)
         throw new GribiweException("Incorrect number of apartment number." +
                 "The lowest possible number is 1. Your is: " + apartmentNumber);


      ApartmentInfo result = getApartInfo(floorsAtEntrance, apartmentsAtFloor, apartmentNumber);
      System.out.println("entrance: " + result.getEntrance());
      System.out.println("floor: " + result.getFloor());
   }
}
