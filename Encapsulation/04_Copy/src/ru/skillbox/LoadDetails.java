package ru.skillbox;
public class LoadDetails {

    private int mass;
    private String address;



    public LoadDetails() {
        this.mass = mass;
        this.address = address;

    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString(){
        return "Mass: "  + mass + "\n" +
                "Address: " + address;
    }



}

