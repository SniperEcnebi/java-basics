package ru.skillbox;

public class Main {
    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions();
        dimensions.setLength(134.45);
        dimensions.setWidth(76.43);
        dimensions.setHeight(7.89);
        Load load = new Load(dimensions, 165, "Avenue 5", true, "XY8",false) ;
        load.setMass(134);
        load.setAddress("Avenue 7");
        System.out.println(load);





    }
}