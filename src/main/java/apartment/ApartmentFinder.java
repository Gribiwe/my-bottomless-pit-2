package apartment;

import exception.GribiweException;

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class for finding information about apartment's floor and entrance.
 * Contains of methods {@link #showMenu()} for integration with
 * user and {@link #getApartInfo(BigInteger, BigInteger, BigInteger)}
 * for finding apartment's info. Uses BigInteger for representation of values
 *
 * @author Gribiwe
 * @see ApartmentInfo
 * @see BigInteger
 */
public class ApartmentFinder {

   /**
    * scanner for user's input
    */
   private Scanner scanner;

   /**
    * Method which calculates apartment's information
    * about floor and entrance having information
    * about house sizing nad apartment number.
    *
    * @param floorsAtEntrance  number of floors at entrance
    * @param apartmentsAtFloor number of apartments
    *                          at floor
    * @param apartmentNumber   number of apartment which
    *                          info you want
    * @return apartment information about entrance
    * and floor
    * @throws GribiweException if some of values
    *                          lower then 1 or are null
    */
   public ApartmentInfo getApartInfo(BigInteger floorsAtEntrance, BigInteger apartmentsAtFloor, BigInteger apartmentNumber) {
      if (floorsAtEntrance == null) {
         throw new GribiweException("Number of floors at entrance is null. Can't work with null");
      }

      if (apartmentsAtFloor == null) {
         throw new GribiweException("Number of apartments at floor is null. Can't work with null");
      }

      if (apartmentNumber == null) {
         throw new GribiweException("Apartment number is null. Can't work with null");
      }

      if (floorsAtEntrance.compareTo(BigInteger.ONE) < 0) {
         throw new GribiweException("Incorrect number of floors at entrance." +
                 "The lowest possible number is 1. Your is: " + floorsAtEntrance);
      }

      if (apartmentsAtFloor.compareTo(BigInteger.ONE) < 0) {
         throw new GribiweException("Incorrect number of apartments at floor." +
                 "The lowest possible number is 1. Your is: " + apartmentsAtFloor);
      }

      if (apartmentNumber.compareTo(BigInteger.ONE) < 0) {
         throw new GribiweException("Incorrect number of apartment number." +
                 "The lowest possible number is 1. Your is: " + apartmentNumber);
      }

      BigInteger apartmentsAtEntrance = floorsAtEntrance.multiply(apartmentsAtFloor);
      BigInteger entrance = apartmentNumber.subtract(BigInteger.ONE).divide(apartmentsAtEntrance).add(BigInteger.ONE);
      BigInteger apartmentsAtPreviousEntrances = entrance.subtract(BigInteger.ONE).multiply(apartmentsAtEntrance);
      BigInteger apartmentIndexAtEntrance = apartmentNumber.subtract(BigInteger.ONE).subtract(apartmentsAtPreviousEntrances);
      BigInteger floor = apartmentIndexAtEntrance.divide(apartmentsAtFloor).add(BigInteger.ONE);

      return new ApartmentInfo(floor, entrance);
   }

   /**
    * Method for integration with user via console
    * input for initiate variables {@code floorsAtEntrance,
    * apartmentsAtFloor, apartmentNumber} for calling of
    * {@link #getApartInfo(BigInteger, BigInteger, BigInteger)}
    * with entered values as arguments.
    *
    * @throws GribiweException if some of entered strokes doesn't
    *                          match to integer or entered some
    *                          values which lower then 1
    */
   public void showMenu() {
      scanner = new Scanner(System.in);

      System.out.println("How many floors?");
      BigInteger floorsAtEntrance = getAnswerFromConsole();
      if (floorsAtEntrance.compareTo(BigInteger.ONE) < 0) {
         throw new GribiweException("Incorrect number of floors at entrance." +
                 "The lowest possible number is 1. Your is: " + floorsAtEntrance);
      }

      System.out.println("How many apartments on floor?");
      BigInteger apartmentsAtFloor = getAnswerFromConsole();
      if (apartmentsAtFloor.compareTo(BigInteger.ONE) < 0) {
         throw new GribiweException("Incorrect number of apartments at floor." +
                 "The lowest possible number is 1. Your is: " + apartmentsAtFloor);
      }

      System.out.println("What apartment you want to find?");
      BigInteger apartmentNumber = getAnswerFromConsole();
      if (apartmentNumber.compareTo(BigInteger.ONE) < 0) {
         throw new GribiweException("Incorrect number of apartment number." +
                 "The lowest possible number is 1. Your is: " + apartmentNumber);
      }

      ApartmentInfo result = getApartInfo(floorsAtEntrance, apartmentsAtFloor, apartmentNumber);
      System.out.println("entrance: " + result.getEntrance());
      System.out.println("floor: " + result.getFloor());
   }

   /**
    * Waits until user will enter an int value
    */
   private BigInteger getAnswerFromConsole() {
      try {
         return scanner.nextBigInteger();
      } catch (InputMismatchException e) {
         throw new GribiweException("You have entered stroke, which doesn't match the Integer: " + scanner.next());
      }
   }
}
