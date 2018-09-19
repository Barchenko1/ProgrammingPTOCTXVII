package ua.org.oa.evlashdv.lectures.lecture1.Calculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertEquals;


public class Tests_Calculator
{
    //testing main functions +, - , *, /
    @Test
    public void testPlus()
    {
        MetodCalc mc = new MetodCalc();
        int res= mc.calc(15, "+", 5);
        assertEquals(20, res);
    }
    @Test
    public void test_Minus()
    {
        MetodCalc mc = new MetodCalc();
        int res=mc.calc(15, "-", 5);
        assertEquals(10, res);
    }
    @Test
    public void test_Multiply()
    {
        MetodCalc mc = new MetodCalc();
        int res=mc.calc(15, "*", 5);
        assertEquals(75, res );
    }
    @Test
    public void test_Divide()
    {
        MetodCalc mc = new MetodCalc();
        int res=mc.calc(15, "/", 5);
        assertEquals(3, res );
    }
    ///////////////division by zero//////////////////////
    @Test (expected = ArithmeticException.class)
    public void test_Divide_zero()
    {
        MetodCalc mc = new MetodCalc();
        mc.calc(15, "/", 0);
    }

}