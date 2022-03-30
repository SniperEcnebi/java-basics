package ru.skillbox;

public class Country {

    private String name;
    private int population = 329500000;
    private double areaOfLand = 9834132.345;
    private String capital = "Washington";
    private boolean seaAccess = true;

    public Country(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Country country = new Country("USA");
        System.out.println(country.getName());
        System.out.println(country.getPopulation());
        System.out.println(country.getAreaOfLand());
        System.out.println(country.getCapital());
        System.out.println(country.isSeaAccess());

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getAreaOfLand() {
        return areaOfLand;
    }

    public void setAreaOfLand(double areaOfLand) {
        this.areaOfLand = areaOfLand;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public boolean isSeaAccess() {
        return seaAccess;
    }

    public void setSeaAccess(boolean seaAccess) {
        this.seaAccess = seaAccess;
    }

}
