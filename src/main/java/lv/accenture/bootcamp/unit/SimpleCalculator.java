package lv.accenture.bootcamp.unit;

import lv.accenture.bootcamp.exc.Arithmetic;

public class SimpleCalculator {

    public int sum(int a, int b) {
        return a + b;
    }

    public int substract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        int result = 0;
        boolean bIsNegative = (b < 0);
        for (int i = 0; i < Math.abs(b); i++) {
            result += a;
        }

        if (bIsNegative) {
            return -result;
        } else {
            return result;
        }
    }

    public int divide(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("Can't divide by zero!");
        }
    }

}
