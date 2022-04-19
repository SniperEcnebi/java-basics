package ru.skillbox;

public class CPU{

    @Override
    public String toString() {
        return "CPU{" +
                "hz=" + hz +
                ", cores=" + cores +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    public final double hz;
    public final int cores;
    public final String name;
    private static double weight ;

    public CPU(double hz, int cores, String name, double weight) {
        this.hz = hz;
        this.cores = cores;
        this.name = name;
        this.weight = weight;
    }

    public CPU setHz(double hz){
        return new CPU(hz, cores, name, weight);
    }

    public CPU setCores(int cores){
        return new CPU(hz, cores, name, weight);
    }

    public CPU setName(String name){
        return new CPU(hz, cores, name, weight);
    }

    public CPU setWeight(double weight){
        return new CPU(hz, cores, name, weight);
    }

    public double getHz() {
        return hz;
    }

    public int getCores() {
        return cores;
    }

    public String getName() {
        return name;
    }

    public static double getWeight() {
        return weight;
    }


}
