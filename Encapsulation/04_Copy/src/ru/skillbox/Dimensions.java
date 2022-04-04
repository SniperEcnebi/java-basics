package ru.skillbox;
public class Dimensions {

    public final double length;
    public final double width;
    public final double height;
    public double totalVolume;

    public Dimensions(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public Dimensions(){
        length = 0;
        width = 0;
        height = 0;
    }

    public double getTotalVolume(){
        totalVolume = length * width * height;
        return totalVolume;
    }

    public double getLength() {
        return length;
    }

    public Dimensions setLength(double length) {
        return new Dimensions(length, width, height);
    }

    public double getWidth() {
        return width;
    }

    public Dimensions setWidth(double width) {
        return new Dimensions(length, width, height);
    }

    public double getHeight() {
        return height;
    }

    public Dimensions setHeight(double height) {
        return new Dimensions(length, width, height);
    }

    public String toString(){
        return "\n" + "length: " +
                length + "\n" +
                "width: " +
                width + "\n" +
                "height: " + height;
    }
}

