package second;

import java.math.BigInteger;

/**
 * Class for representation of
 * apartment's information about
 * entrance and floor of apartment
 */
public class ApartmentInfo {

    private BigInteger floor;
    private BigInteger entrance;

    /**
     * Translates information of
     * apartment's floor and entrance into
     * composite apartment information
     *
     * @param floor number of apartment's floor
     * @param entrance number of apartment's entrance
     */
    public ApartmentInfo(BigInteger floor, BigInteger entrance) {
        this.floor = floor;
        this.entrance = entrance;
    }


    public BigInteger getFloor() {

        return floor;
    }

    public BigInteger getEntrance() {
        return entrance;
    }
}
