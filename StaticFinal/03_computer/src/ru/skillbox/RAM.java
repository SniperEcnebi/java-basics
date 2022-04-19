package ru.skillbox;

public class RAM {

    @Override
    public String toString() {
        return "RAM{" +
                "type='" + type + '\'' +
                ", volume=" + volume +
                ", weight=" + weight +
                '}';
    }

    public final String type;
    public  final int volume;
    public static double weight = 0;

    public RAM(String type, int volume, double weight) {
        this.type = type;
        this.volume = volume;
        this.weight = weight;
    }

    public RAM setType(String type){
        return new RAM(type, volume, weight);
    }

    public RAM setVolume(int volume){
        return new RAM(type, volume, weight);
    }

    public RAM setWeight(double weight){
        return new RAM(type, volume, weight);
    }


    public String getType() {
        return type;
    }

    public int getVolume() {
        return volume;
    }

    public static double getWeight() {
        return weight;
    }

}
