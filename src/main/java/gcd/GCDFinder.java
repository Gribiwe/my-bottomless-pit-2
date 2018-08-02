package gcd;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by nikit on 16.07.2018.
 */
public class GCDFinder {

    private static GCDFinder instance;

    public static GCDFinder getInstance() {

        if (instance == null) {
            instance = new GCDFinder();
        }

        return instance;
    }

    public long gcd(long a, long b, long c, long d) {
        return gcd(gcd(a, b), gcd(c, d));
    }

    public long gcd(long a, long b) {
        if (a == 0) return b;
        if (b == 0) return a;
        long tmp;
        while (b != 0) {
            tmp = a % b;
            a = b;
            b = tmp;
        }
        return Math.abs(a);
    }

    public void showMenu(Scanner scanner) {
        long a, b, c, d;
        System.out.println("Enter 1st number");
        a = scanner.nextLong();
        System.out.println("Enter 2nd number");
        b = scanner.nextLong();
        System.out.println("Enter 3rd number");
        c = scanner.nextLong();
        System.out.println("Enter 4th number");
        d = scanner.nextLong();
        System.out.println("GDC is " + (gcd(a, b, c, d)));
    }

}
