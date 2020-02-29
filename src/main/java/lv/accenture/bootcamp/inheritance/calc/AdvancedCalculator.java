package lv.accenture.bootcamp.inheritance.calc;

public class AdvancedCalculator extends StandardCalculator implements AdvancedOperations {
    @Override
    public double power(double x, double y) {
        return Math.pow(x, y);
    }

    @Override
    public double sqrt(double x) {
        return Math.sqrt(x);
    }
}
