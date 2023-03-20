import org.example.CalcService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.InputMismatchException;


public class CalcServiceTest {

    private CalcService calcService;
    private int num1;
    private char symbol;
    private int num2;

    @Before
    public void init() {
        calcService = new CalcService();
    }

    @Test
    public void calculatorCounterTest() {
        num1 = 3;
        symbol = '+';
        num2 = 7;
        int expectedInt = 10;
        Assertions.assertEquals(expectedInt, calcService.calculator(num1, symbol, num2));
    }

    @Test(expected=java.lang.ArithmeticException.class)
    public void DivideByZeroTest() {
        num1 = 3;
        symbol = '/';
        num2 = 0;
        calcService.calculator(num1, symbol, num2);
    }

    @Test(expected= InputMismatchException.class)
    public void InputMismatchTest() {
        num1 = 3;
        symbol = '.';
        num2 = 0;
        calcService.calculator(num1, symbol, num2);
    }
}