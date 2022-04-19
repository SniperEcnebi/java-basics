package ru.skillbox;

public class HardDrive {

    @Override
    public String toString() {
        return "HardDrive{" +
                "type='" + type + '\'' +
                ", volumeGb=" + volumeGb +
                ", weight=" + weight +
                '}';
    }

    public final String type;
    public final int volumeGb;
    public static double weight;

    public HardDrive(String type, int volumeGb, double weight) {
        this.type = type;
        this.volumeGb = volumeGb;
        this.weight = weight;
    }

    public HardDrive setType(String type){
        return new HardDrive(type, volumeGb, weight);
    }
    public HardDrive setVolumeGb(){
        return new HardDrive(type, volumeGb, weight);
    }
    public HardDrive setWeight(double weight){
        return new HardDrive(type, volumeGb, weight);
    }

    public String getType() {
        return type;
    }

    public double getVolumeGb() {
        return volumeGb;
    }

    public static double getWeight() {
        return weight;
    }

}
