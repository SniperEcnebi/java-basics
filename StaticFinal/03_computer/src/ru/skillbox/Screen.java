package ru.skillbox;

public class Screen {


    @Override
    public String toString() {
        return "Screen{" +
                "diagonal=" + diagonal +
                ", type='" + type + '\'' +
                ", weight=" + weight +
                '}';
    }

    public final double diagonal;
    private final String type;
    private static double weight;

    public Screen(double diagonal, String type, double weight) {
        this.diagonal = diagonal;
        this.type = type;
        this.weight = weight;
    }

    public Screen setDiagonal(double diagonal) {
        return new Screen(diagonal, type, weight );
    }

    public Screen setType(String type) {
        return new Screen(diagonal, type, weight );
    }

    public Screen setWeight(double weight) {
        return new Screen(diagonal, type, weight );
    }

    public double getDiagonal() {
        return diagonal;
    }

    public String getType() {
        return type;
    }

    public static double getWeight() {
        return weight;
    }

}
