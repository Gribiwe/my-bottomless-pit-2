package fibbo;

import java.math.BigInteger;
import java.util.Scanner;

public class FibFinder {
    private static FibFinder instance;

    public static FibFinder getInstance() {

        if (instance == null) {
            instance = new FibFinder();
        }

        return instance;
    }

    public BigInteger getFibonacci(BigInteger n) {
        if (n.compareTo(BigInteger.valueOf(100000)) > 0) {
            System.out.println("Too high value");
            return null;
        } else if (n.compareTo(BigInteger.ZERO) < 0) {
            System.out.println("Too low value");
            return null;
        }

        BigInteger pre = BigInteger.ZERO;
        BigInteger cur = BigInteger.ONE;
        BigInteger tmp;
        for (int i = 0; i < n.intValue(); i++) {
            tmp = cur;
//            cur += pre;
            cur = cur.add(pre);
            pre = tmp;
        }
//        return null;
        return pre;
//        return 0;

    }

    public void showMenu(Scanner scanner) {
        System.out.println("What number of fibonacci you want to find?");
        BigInteger answer = getFibonacci(scanner.nextBigInteger());
        if (answer != null) {

            System.out.println("Answer is: " + answer);

        }
    }
}
