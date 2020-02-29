package lv.accenture.bootcamp.inheritance.calc;

public class CalculatorLauncher {

    public static void main(String[] args) {
        AdvancedCalculator advancedCalculator = new AdvancedCalculator();
        System.out.println("Sum(2,3) : " + advancedCalculator.sum(2, 3));
        System.out.println("Substract(2,3) : " + advancedCalculator.substract(2, 3));
        System.out.println("Multiply(2,3) : " + advancedCalculator.multiply(2, 3));
        System.out.println("Divide(2,3) : " + advancedCalculator.divide(2, 3));
        System.out.println("Power(2,3) : " + advancedCalculator.power(2, 3));
        System.out.println("Sqrt(2) : " + advancedCalculator.sqrt(2));
    }

}
