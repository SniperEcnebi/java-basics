package ru.skillbox;

import java.security.Key;

public class KeyBoard {


    @Override
    public String toString() {
        return "KeyBoard{" +
                "type='" + type + '\'' +
                ", backlight=" + backlight +
                ", weight=" + weight +
                '}';
    }

    public final String type;
    public final boolean backlight;
    public static  double weight;

    public KeyBoard(String type, boolean backlight, double weight) {
        this.type = type;
        this.backlight = backlight;
        this.weight = weight;
    }

    public KeyBoard setType(String type) {
        return new KeyBoard(type, backlight, weight);
    }

    public KeyBoard setIsBacklight(boolean backlight) {
        return new KeyBoard(type, backlight, weight);
    }

    public KeyBoard setWeight(double weight) {
        return new KeyBoard(type, backlight, weight);
    }


    public String getType() {
        return type;
    }

    public boolean isBacklight() {
        return backlight;
    }

    public static double getWeight() {
        return weight;
    }


}
