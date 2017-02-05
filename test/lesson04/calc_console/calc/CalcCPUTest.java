package lesson04.calc_console.calc;

//import lesson04.calc_console.calc.CalcCPU;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by eriol4ik on 25/12/2016.
 */
public class CalcCPUTest extends Assert {

    @Test
    public void parseTest1() {
        CalcCPU.parse("2 + 2 = ");
        assertEquals("First number", (int)CalcCPU.getFirst(), 2);
        assertEquals("Second number", (int)CalcCPU.getSecond(), 2);
        assertEquals("Operation", CalcCPU.getOperation(), "+");
        assertEquals("Equals", CalcCPU.getEquals(), "=");
    }

    @Test
    public void parseTest2() {
        CalcCPU.parse("-2 / -2 = ");
        assertEquals("First number", (int)CalcCPU.getFirst(), -2);
        assertEquals("Second number", (int)CalcCPU.getSecond(), -2);
        assertEquals("Operation", CalcCPU.getOperation(), "/");
        assertEquals("Equals", CalcCPU.getEquals(), "=");
    }

    @Test
    public void parseTest3() {
        CalcCPU.parse("2222 - -56762 = ");
        assertEquals("First number", (int)CalcCPU.getFirst(), 2222);
        assertEquals("Second number", (int)CalcCPU.getSecond(), -56762);
        assertEquals("Operation", CalcCPU.getOperation(), "-");
        assertEquals("Equals", CalcCPU.getEquals(), "=");
    }

    /*@Test
    public void testCalcAdd() {
        // Ожидаемый результат должен быть равен фактическому
        assertEquals("Додавання", 4, (int) CalcCPU.calc(2, "+", 2));
        // Ожидаемый результат не должет быть равен фактическому
        assertNotEquals("Додавання", 5, (int)CalcCPU.calc(2, "+", 2));
    }

    @Test
    public void testCalcSubtract() {
        assertEquals("Віднімання", 78, (int)CalcCPU.calc(100, "-", 22));
        assertNotEquals("Віднімання", 5, (int)CalcCPU.calc(2, "-", 2));
    }

    @Test
    public void testCalcMultiply() {
        assertEquals("Множення", 45, (int)CalcCPU.calc(5, "*", 9));
        assertNotEquals("Множення", 5, (int)CalcCPU.calc(2, "*", 2));
    }

    @Test
    public void testCalcDivide() {
        assertEquals("Ділення", 7, (int)CalcCPU.calc(49, "/", 7));
        assertNotEquals("Ділення", 5, (int)CalcCPU.calc(2, "/", 2));
    }


//    @Test(expected = <Класс исключения>.class) <- указываемый ожидаемый класс исключения
    @Test(expected = ArithmeticException.class)
    public void testCalcDivideByZero() {
        CalcCPU.calc(4, "/", 0);
    }*/
}