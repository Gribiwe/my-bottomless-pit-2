import exception.GribiweException;
import first.SwappableNumber;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class SwapperTest extends Assert {

    private SwappableNumber firstNum;
    private SwappableNumber secondNum;

    private void testSwapTemplate(String first, String second){

        firstNum = new SwappableNumber(first);
        secondNum = new SwappableNumber(second);

        SwappableNumber testSwappedFirstNum = new SwappableNumber(first);
        SwappableNumber testSwappedSecondNum = new SwappableNumber(second);

        testSwappedFirstNum.swap(testSwappedSecondNum);
        assertEquals(secondNum.getValue(), testSwappedFirstNum.getValue());
        assertEquals(firstNum.getValue(), testSwappedSecondNum.getValue());
    }
    private void testSwapTemplate(long first, long second){
        testSwapTemplate(first+"", second+"");
    }


    private void testSwapWrongValuesTemplate(String a, String b){
        Assertions.assertThrows(GribiweException.class, () -> new SwappableNumber(a).swap(new SwappableNumber(b)));
    }

    private void testSwapWrongValuesTemplate(double a, double b){
        testSwapWrongValuesTemplate(a+"", b+"");
    }

    @Test
    public void testSwap() {

        testSwapTemplate(0, -100);
        testSwapTemplate(0, -50);
        testSwapTemplate(0, -20);
        testSwapTemplate(0, -10);
        testSwapTemplate(0, -3);
        testSwapTemplate(0, -2);
        testSwapTemplate(0, -1);
        testSwapTemplate(0, 1);
        testSwapTemplate(0, 2);
        testSwapTemplate(0, 3);
        testSwapTemplate(0, 10);
        testSwapTemplate(0, 20);
        testSwapTemplate(0, 50);
        testSwapTemplate(0, 100);

        testSwapTemplate(-100, 0);
        testSwapTemplate(-50, 0);
        testSwapTemplate(-20, 0);
        testSwapTemplate(-10, 0);
        testSwapTemplate(-3, 0);
        testSwapTemplate(-2, 0);
        testSwapTemplate(1, 0);
        testSwapTemplate(2, 0);
        testSwapTemplate(3, 0);
        testSwapTemplate(10, 0);
        testSwapTemplate(20, 0);
        testSwapTemplate(50, 0);
        testSwapTemplate(100, 0);

        testSwapTemplate(5, -100);
        testSwapTemplate(5, -50);
        testSwapTemplate(5, -20);
        testSwapTemplate(5, -10);
        testSwapTemplate(5, -3);
        testSwapTemplate(5, -2);
        testSwapTemplate(5, -1);
        testSwapTemplate(5, 1);
        testSwapTemplate(5, 2);
        testSwapTemplate(5, 3);
        testSwapTemplate(5, 10);
        testSwapTemplate(5, 20);
        testSwapTemplate(5, 50);
        testSwapTemplate(5, 100);

        testSwapTemplate(-100, 5);
        testSwapTemplate(-50, 5);
        testSwapTemplate(-20, 5);
        testSwapTemplate(-10, 5);
        testSwapTemplate(-3, 5);
        testSwapTemplate(-2, 5);
        testSwapTemplate(1, 5);
        testSwapTemplate(2, 5);
        testSwapTemplate(3, 5);
        testSwapTemplate(10, 5);
        testSwapTemplate(20, 5);
        testSwapTemplate(50, 5);
        testSwapTemplate(100, 5);

        testSwapTemplate(55, -100);
        testSwapTemplate(55, -50);
        testSwapTemplate(55, -20);
        testSwapTemplate(55, -10);
        testSwapTemplate(55, -3);
        testSwapTemplate(55, -2);
        testSwapTemplate(55, -1);
        testSwapTemplate(55, 1);
        testSwapTemplate(55, 2);
        testSwapTemplate(55, 3);
        testSwapTemplate(55, 10);
        testSwapTemplate(55, 20);
        testSwapTemplate(55, 50);
        testSwapTemplate(55, 100);

        testSwapTemplate(-100, 55);
        testSwapTemplate(-50, 55);
        testSwapTemplate(-20, 55);
        testSwapTemplate(-10, 55);
        testSwapTemplate(-3, 55);
        testSwapTemplate(-2, 55);
        testSwapTemplate(1, 55);
        testSwapTemplate(2, 55);
        testSwapTemplate(3, 55);
        testSwapTemplate(10, 55);
        testSwapTemplate(20, 55);
        testSwapTemplate(50, 55);
        testSwapTemplate(100, 55);

        testSwapTemplate(1569, -100);
        testSwapTemplate(1569, -50);
        testSwapTemplate(1569, -20);
        testSwapTemplate(1569, -10);
        testSwapTemplate(1569, -3);
        testSwapTemplate(1569, -2);
        testSwapTemplate(1569, -1);
        testSwapTemplate(1569, 1);
        testSwapTemplate(1569, 2);
        testSwapTemplate(1569, 3);
        testSwapTemplate(1569, 10);
        testSwapTemplate(1569, 20);
        testSwapTemplate(1569, 50);
        testSwapTemplate(1569, 100);

        testSwapTemplate(-100, 1569);
        testSwapTemplate(-50, 1569);
        testSwapTemplate(-20, 1569);
        testSwapTemplate(-10, 1569);
        testSwapTemplate(-3, 1569);
        testSwapTemplate(-2, 1569);
        testSwapTemplate(1, 1569);
        testSwapTemplate(2, 1569);
        testSwapTemplate(3, 1569);
        testSwapTemplate(10, 1569);
        testSwapTemplate(20, 1569);
        testSwapTemplate(50, 1569);
        testSwapTemplate(100, 1569);

        testSwapTemplate(Integer.MAX_VALUE, -100);
        testSwapTemplate(Integer.MAX_VALUE, -50);
        testSwapTemplate(Integer.MAX_VALUE, -20);
        testSwapTemplate(Integer.MAX_VALUE, -10);
        testSwapTemplate(Integer.MAX_VALUE, -3);
        testSwapTemplate(Integer.MAX_VALUE, -2);
        testSwapTemplate(Integer.MAX_VALUE, -1);
        testSwapTemplate(Integer.MAX_VALUE, 1);
        testSwapTemplate(Integer.MAX_VALUE, 2);
        testSwapTemplate(Integer.MAX_VALUE, 3);
        testSwapTemplate(Integer.MAX_VALUE, 10);
        testSwapTemplate(Integer.MAX_VALUE, 20);
        testSwapTemplate(Integer.MAX_VALUE, 50);
        testSwapTemplate(Integer.MAX_VALUE, 100);

        testSwapTemplate(-100, Integer.MAX_VALUE);
        testSwapTemplate(-50, Integer.MAX_VALUE);
        testSwapTemplate(-20, Integer.MAX_VALUE);
        testSwapTemplate(-10, Integer.MAX_VALUE);
        testSwapTemplate(-3, Integer.MAX_VALUE);
        testSwapTemplate(-2, Integer.MAX_VALUE);
        testSwapTemplate(1, Integer.MAX_VALUE);
        testSwapTemplate(2, Integer.MAX_VALUE);
        testSwapTemplate(3, Integer.MAX_VALUE);
        testSwapTemplate(10, Integer.MAX_VALUE);
        testSwapTemplate(20, Integer.MAX_VALUE);
        testSwapTemplate(50, Integer.MAX_VALUE);
        testSwapTemplate(100, Integer.MAX_VALUE);

        testSwapTemplate(Integer.MIN_VALUE, -100);
        testSwapTemplate(Integer.MIN_VALUE, -50);
        testSwapTemplate(Integer.MIN_VALUE, -20);
        testSwapTemplate(Integer.MIN_VALUE, -10);
        testSwapTemplate(Integer.MIN_VALUE, -3);
        testSwapTemplate(Integer.MIN_VALUE, -2);
        testSwapTemplate(Integer.MIN_VALUE, -1);
        testSwapTemplate(Integer.MIN_VALUE, 1);
        testSwapTemplate(Integer.MIN_VALUE, 2);
        testSwapTemplate(Integer.MIN_VALUE, 3);
        testSwapTemplate(Integer.MIN_VALUE, 10);
        testSwapTemplate(Integer.MIN_VALUE, 20);
        testSwapTemplate(Integer.MIN_VALUE, 50);
        testSwapTemplate(Integer.MIN_VALUE, 100);

        testSwapTemplate(-100, Integer.MIN_VALUE);
        testSwapTemplate(-50, Integer.MIN_VALUE);
        testSwapTemplate(-20, Integer.MIN_VALUE);
        testSwapTemplate(-10, Integer.MIN_VALUE);
        testSwapTemplate(-3, Integer.MIN_VALUE);
        testSwapTemplate(-2, Integer.MIN_VALUE);
        testSwapTemplate(1, Integer.MIN_VALUE);
        testSwapTemplate(2, Integer.MIN_VALUE);
        testSwapTemplate(3, Integer.MIN_VALUE);
        testSwapTemplate(10, Integer.MIN_VALUE);
        testSwapTemplate(20, Integer.MIN_VALUE);
        testSwapTemplate(50, Integer.MIN_VALUE);
        testSwapTemplate(100, Integer.MIN_VALUE);

        testSwapTemplate(Integer.MAX_VALUE, Integer.MIN_VALUE);
        testSwapTemplate(Integer.MIN_VALUE, Integer.MAX_VALUE);

        //

        testSwapTemplate(Long.MAX_VALUE, -100);
        testSwapTemplate(Long.MAX_VALUE, -50);
        testSwapTemplate(Long.MAX_VALUE, -20);
        testSwapTemplate(Long.MAX_VALUE, -10);
        testSwapTemplate(Long.MAX_VALUE, -3);
        testSwapTemplate(Long.MAX_VALUE, -2);
        testSwapTemplate(Long.MAX_VALUE, -1);
        testSwapTemplate(Long.MAX_VALUE, 1);
        testSwapTemplate(Long.MAX_VALUE, 2);
        testSwapTemplate(Long.MAX_VALUE, 3);
        testSwapTemplate(Long.MAX_VALUE, 10);
        testSwapTemplate(Long.MAX_VALUE, 20);
        testSwapTemplate(Long.MAX_VALUE, 50);
        testSwapTemplate(Long.MAX_VALUE, 100);

        testSwapTemplate(-100, Long.MAX_VALUE);
        testSwapTemplate(-50, Long.MAX_VALUE);
        testSwapTemplate(-20, Long.MAX_VALUE);
        testSwapTemplate(-10, Long.MAX_VALUE);
        testSwapTemplate(-3, Long.MAX_VALUE);
        testSwapTemplate(-2, Long.MAX_VALUE);
        testSwapTemplate(1, Long.MAX_VALUE);
        testSwapTemplate(2, Long.MAX_VALUE);
        testSwapTemplate(3, Long.MAX_VALUE);
        testSwapTemplate(10, Long.MAX_VALUE);
        testSwapTemplate(20, Long.MAX_VALUE);
        testSwapTemplate(50, Long.MAX_VALUE);
        testSwapTemplate(100, Long.MAX_VALUE);

        testSwapTemplate(Long.MIN_VALUE, -100);
        testSwapTemplate(Long.MIN_VALUE, -50);
        testSwapTemplate(Long.MIN_VALUE, -20);
        testSwapTemplate(Long.MIN_VALUE, -10);
        testSwapTemplate(Long.MIN_VALUE, -3);
        testSwapTemplate(Long.MIN_VALUE, -2);
        testSwapTemplate(Long.MIN_VALUE, -1);
        testSwapTemplate(Long.MIN_VALUE, 1);
        testSwapTemplate(Long.MIN_VALUE, 2);
        testSwapTemplate(Long.MIN_VALUE, 3);
        testSwapTemplate(Long.MIN_VALUE, 10);
        testSwapTemplate(Long.MIN_VALUE, 20);
        testSwapTemplate(Long.MIN_VALUE, 50);
        testSwapTemplate(Long.MIN_VALUE, 100);

        testSwapTemplate(-100, Long.MIN_VALUE);
        testSwapTemplate(-50, Long.MIN_VALUE);
        testSwapTemplate(-20, Long.MIN_VALUE);
        testSwapTemplate(-10, Long.MIN_VALUE);
        testSwapTemplate(-3, Long.MIN_VALUE);
        testSwapTemplate(-2, Long.MIN_VALUE);
        testSwapTemplate(1, Long.MIN_VALUE);
        testSwapTemplate(2, Long.MIN_VALUE);
        testSwapTemplate(3, Long.MIN_VALUE);
        testSwapTemplate(10, Long.MIN_VALUE);
        testSwapTemplate(20, Long.MIN_VALUE);
        testSwapTemplate(50, Long.MIN_VALUE);
        testSwapTemplate(100, Long.MIN_VALUE);

        testSwapTemplate(Long.MAX_VALUE, Long.MIN_VALUE);
        testSwapTemplate(Long.MIN_VALUE, Long.MAX_VALUE);
    }

    @Test
    public void testSwapWrongValues() {
        testSwapWrongValuesTemplate(1, 0.0000004);
        testSwapWrongValuesTemplate(123.5, 12);
        testSwapWrongValuesTemplate(12, 151.12312);
        testSwapWrongValuesTemplate(123.5, 151.12312);
    }

}
