package first;


import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by nikit on 16.07.2018.
 */
public class VariableSwapper {

    private static VariableSwapper instance;

    public static VariableSwapper getInstance() {

        if (instance == null) {
            instance = new VariableSwapper();
        }

        return instance;
    }

    public void showMenu(Scanner scanner) {
        System.out.println("");
        System.out.println("Enter a");
        String answ = scanner.next();
        SwappableNumber a = new SwappableNumber(answ);
        System.out.println("Enter b");
        answ = scanner.next();
        SwappableNumber b = new SwappableNumber(answ);
        a.swap(b);
    }


}
