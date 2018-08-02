package second;

import java.math.BigInteger;

/**
 * Created by nikit on 16.07.2018.
 */
public class ApartmentInfo {


    private BigInteger floor;
    private BigInteger entrance;

    public ApartmentInfo(String floor, String entrance) {
        this.floor = new BigInteger(floor);
        this.entrance = new BigInteger(entrance);
    }

    public ApartmentInfo(BigInteger floor, BigInteger entrance) {
        this.floor = floor;
        this.entrance = entrance;
    }

    public void setFloor(BigInteger floor) {

        this.floor = floor;
    }

    public void setEntrance(BigInteger entrance) {
        this.entrance = entrance;
    }

    public BigInteger getFloor() {

        return floor;
    }

    public BigInteger getEntrance() {
        return entrance;
    }
}
