package lv.accenture.bootcamp.inheritance.calc;

public class StandardCalculator implements StandardOperations {
    @Override
    public double sum(double x, double y) {
        return x + y;
    }

    @Override
    public double substract(double x, double y) {
        return x - y;
    }

    @Override
    public double multiply(double x, double y) {
        return x * y;
    }

    @Override
    public double divide(double x, double y) {
        return x / y;
    }
}
