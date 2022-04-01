package ru.skillbox;
public class dimenDetails {

    public int length;
    public int width;
    public int height;
    public int totalVolume;

    public dimenDetails() {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public int getTotalVolume(){
        totalVolume = length * width * height;
        return totalVolume;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String toString(){
        return "\n" + "length: " + length + "\n" + "width: " +  width + "\n" + "height: " + height;
    }
}

