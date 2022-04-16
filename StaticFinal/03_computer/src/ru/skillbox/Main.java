package ru.skillbox;
public class Main {
    public static void main(String[] args) {
            ArithmeticCalculator calculator = new ArithmeticCalculator(2,5);
            ArithmeticCalculator.calculate(Operation.MULTIPLY);
            ArithmeticCalculator.calculate(Operation.ADD);
            ArithmeticCalculator.calculate(Operation.SUBTRACT);

        }

}
