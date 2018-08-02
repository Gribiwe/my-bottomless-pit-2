import fibbo.FibFinder;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigInteger;

public class FibFinderTest extends Assert{

    private static FibFinder testFib;
    private static final String[] RIGHT_ARRAY =
            {"0", "1", "1", "2", "3", "5", "8", "13", "21", "34", "55", "89", "144", "233", "377", "610", "987", "1597", "2584", "4181", "6765", "10946", "17711",
             "28657", "46368", "75025", "121393", "196418", "317811", "514229", "832040", "1346269", "2178309", "3524578", "5702887", "9227465",
             "14930352", "24157817", "39088169", "63245986", "102334155", "165580141", "267914296", "433494437", "701408733", "1134903170",
             "1836311903", "2971215073", "4807526976", "7778742049", "12586269025", "20365011074", "32951280099", "53316291173",
             "86267571272", "139583862445", "225851433717", "365435296162", "591286729879", "956722026041", "1548008755920", "2504730781961",
             "4052739537881", "6557470319842", "10610209857723", "17167680177565", "27777890035288", "44945570212853", "72723460248141",
             "117669030460994", "190392490709135", "308061521170129", "498454011879264", "806515533049393", "1304969544928657",
             "2111485077978050", "3416454622906707", "5527939700884757", "8944394323791464", "14472334024676221", "23416728348467685",
             "37889062373143906", "61305790721611591", "99194853094755497", "259695496911122585", "420196140727489673",
             "679891637638612258", "1100087778366101931", "1779979416004714189", "1779979416004714189", "2880067194370816120",
             "4660046610375530309", "7540113804746346429 ", "12200160415121876738", "19740274219868223167", "31940434634990099905",
             "51680708854858323072", "83621143489848422977", "135301852344706746049", "218922995834555169026", "354224848179261915075"}; //source - http://php.bubble.ro/fibonacci/

    @BeforeClass
    public static void runFibFinder() {
        testFib = new FibFinder();
    }

    private void testGetFibonacciTemplate(long n){
        assertEquals(testFib.getFibonacci(BigInteger.valueOf(n)), new BigInteger(RIGHT_ARRAY[(int) n]));
    }

    private void testGetFibonacciUnrealValuesTemplate(long n){
        assertEquals(testFib.getFibonacci(BigInteger.valueOf(n)), null);
    }

    @Test
    public void testGetFibonacci() {
        testGetFibonacciUnrealValuesTemplate(100001);
        testGetFibonacciUnrealValuesTemplate(-1);

        testGetFibonacciTemplate(0);
        testGetFibonacciTemplate(1);
        testGetFibonacciTemplate(2);
        testGetFibonacciTemplate(3);
        testGetFibonacciTemplate(4);
        testGetFibonacciTemplate(5);
        testGetFibonacciTemplate(6);
        testGetFibonacciTemplate(34);
        testGetFibonacciTemplate(35);
        testGetFibonacciTemplate(48);
        testGetFibonacciTemplate(49);
        testGetFibonacciTemplate(50);
        testGetFibonacciTemplate(51);
        testGetFibonacciTemplate(52);
        testGetFibonacciTemplate(53);
        testGetFibonacciTemplate(54);
        testGetFibonacciTemplate(55);
        testGetFibonacciTemplate(95);
        testGetFibonacciTemplate(96);
        testGetFibonacciTemplate(97);
        testGetFibonacciTemplate(98);
        testGetFibonacciTemplate(99);
        testGetFibonacciTemplate(100);
    }
    @Test
    public void testGetFibonacciWrongValues() {
        testGetFibonacciUnrealValuesTemplate(100001);
        testGetFibonacciUnrealValuesTemplate(100002);
        testGetFibonacciUnrealValuesTemplate(100003);
        testGetFibonacciUnrealValuesTemplate(Integer.MAX_VALUE);
        testGetFibonacciUnrealValuesTemplate(Long.MAX_VALUE);
        testGetFibonacciUnrealValuesTemplate(Integer.MIN_VALUE);
        testGetFibonacciUnrealValuesTemplate(Long.MIN_VALUE);
        testGetFibonacciUnrealValuesTemplate(-1);
        testGetFibonacciUnrealValuesTemplate(-2);
        testGetFibonacciUnrealValuesTemplate(-3);
    }
}
