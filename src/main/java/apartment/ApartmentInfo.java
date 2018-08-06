package apartment;

import java.math.BigInteger;

/**
 * Class for representation of
 * apartment's information about
 * entrance and floor of apartment
 */
public class ApartmentInfo {

   /**
    * Number of apartment's floor
    * where apartment is being
    */
   private BigInteger floor;
   /**
    * Number of apartment's entrance
    * where apartment is being
    */
   private BigInteger entrance;

   /**
    * Translates information of
    * apartment's floor and entrance into
    * composite apartment information
    *
    * @param floor    number of apartment's floor
    * @param entrance number of apartment's entrance
    */
   ApartmentInfo(BigInteger floor, BigInteger entrance) {
      this.floor = floor;
      this.entrance = entrance;
   }

   /**
    * @return apartment's floor BigInteger value
    */
   public BigInteger getFloor() {
      return floor;
   }

   /**
    * @return apartment's entrance BigInteger value
    */
   public BigInteger getEntrance() {
      return entrance;
   }
}
