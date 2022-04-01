package ru.skillbox;
public class Main {
    public static void main(String[] args) {
        LoadDetails loadDetails = new LoadDetails();
        loadDetails.setMass(164);
        loadDetails.setAddress("Avenue 7");
        Load load = new Load(loadDetails, true, "XY6",false);
        System.out.println(load);
        dimenDetails dimensionsDetails = new dimenDetails();
        dimensionsDetails.setLength(150);
        dimensionsDetails.setWidth(70);
        dimensionsDetails.setHeight(8);
        Dimension dimension = new Dimension(dimensionsDetails);
        System.out.println(dimension);
        System.out.println("Обьем груза: " + dimensionsDetails.getTotalVolume());

    }
}
