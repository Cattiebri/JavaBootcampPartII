package lv.accenture.bootcamp.unit;

import junit.framework.TestCase;

public class SimpleCalculatorTest extends TestCase {

    private SimpleCalculator simpleCalculator;

    public void setUp() {
        simpleCalculator = new SimpleCalculator();
    }

    public void testSum() {
        int actual = simpleCalculator.sum(2, 3);
        assertEquals("Sum result comparison failed!", 5, actual);

        actual = simpleCalculator.sum(4, 5);
        assertEquals(9, actual);
    }

    public void testSubtraction() {
        assertEquals(3, simpleCalculator.substract(9, 6));
        assertEquals(15, simpleCalculator.substract(9, -6));
    }

    public void testMultiplying() {
        assertEquals(6, simpleCalculator.multiply(2 ,3));
        assertEquals(-6, simpleCalculator.multiply(2 ,-3));
        assertEquals(-6, simpleCalculator.multiply(-2 ,3));
        assertEquals(6, simpleCalculator.multiply(-2 ,-3));
        assertEquals(0, simpleCalculator.multiply(2 ,0));
    }

    public void testDivide() {
        assertDivideIsCorrect(5, 4, false);
        assertDivideIsCorrect(5, 0, true);
    }

    private void assertDivideIsCorrect(int a, int b, boolean exceptionExpected) {
        try {
            simpleCalculator.divide(a, b);
            if(exceptionExpected) {
                fail();
            }
        } catch (IllegalArgumentException e) {
            if(!exceptionExpected) {
                fail();
            }
        }
    }

}
