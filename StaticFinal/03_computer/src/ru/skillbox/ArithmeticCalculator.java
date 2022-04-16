package ru.skillbox;
public class ArithmeticCalculator {
    public static int a = 0;
    public static int b = 0;
    public ArithmeticCalculator(int a , int b){
        this.a = a;
        this.b = b;
    }

    public static void calculate(Operation operation){
        if (operation == Operation.ADD) {
            System.out.println("ADD: " + (a + b));
        } else if (operation == Operation.SUBTRACT) {
            System.out.println("SUBTRACT: " + (a - b));
        } else {
            System.out.println("MULTIPLY: "+ (a * b));
        }



    }



}
