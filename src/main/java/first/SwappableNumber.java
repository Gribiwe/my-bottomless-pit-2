package first;

import java.math.BigDecimal;
import java.math.BigInteger;

public class SwappableNumber {

    public SwappableNumber(String value) {
        BigDecimal valueBigDecimal = new BigDecimal(value);
        if (valueBigDecimal.add(new BigDecimal(valueBigDecimal.toBigInteger().negate())).compareTo(BigDecimal.ZERO) != 0) {
            value = null;
        } else {
            this.value = valueBigDecimal.toBigInteger();
        }
    }

    public SwappableNumber(BigInteger value) {
        this.value = value;
    }

    private BigInteger value;

    public void setValue(BigInteger value) {
        this.value = value;
    }

    public BigInteger getValue() {
        return value;
    }

    public SwappableNumber swap(SwappableNumber b) {
        if (value == null) {
            System.err.println("decimal was found, returned null");
            return null;
        } else if (b.getValue() == null){
            System.err.println("decimal was found, returned null");
            return null;
        }
        value = value.add(b.getValue());
        b.setValue(b.getValue().add(value.negate()).negate());
        value = value.add(b.getValue().negate());

        return this;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
