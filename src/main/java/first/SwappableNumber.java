package first;

import exception.GribiweException;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Class of number which can to swap
 * with another swappable numbers
 * without third variable.
 * Uses BigInteger so you can use really big values.
 *
 * @author Gribiwe
 * @see BigInteger
 */
public class SwappableNumber {

   /**
    * represents value of swappable number
    */
   private BigInteger value;

   /**
    * Translates String representation of
    * number into BigInteger value of
    * swappable number.
    *
    * @param value String representation of number
    * @throws GribiweException if {@code value} doesn't
    *                          match to Integer {@code value} is null
    */
   public SwappableNumber(String value) {
      BigInteger valueBigInteger;

      if (value == null) throw new GribiweException("Can't create swappable number of null");

      try {
         valueBigInteger = new BigInteger(value);

      } catch (NumberFormatException e) {
         throw new GribiweException("Can't create swappable number. Your value is not a number: " + value, e);
      }

      this.value = valueBigInteger;
   }

   public void setValue(BigInteger value) {
      this.value = value;
   }

   public BigInteger getValue() {
      return value;
   }

   /**
    * Method for swapping value of current
    * swappable number with value of another
    * swappable number without third variable.
    *
    * @param b another one of Swappable numbers.
    * @throws GribiweException if {@code b} is null
    */
   public void swap(SwappableNumber b) {

      if (b == null) throw new GribiweException("Can't swap with null!");

      value = value.add(b.getValue());
      b.setValue(b.getValue().subtract(value).negate());
      value = value.subtract(b.getValue());

   }

   @Override
   public String toString() {
      return value.toString();
   }
}
