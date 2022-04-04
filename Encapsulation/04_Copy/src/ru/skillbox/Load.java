package ru.skillbox;
public class Load {

    private final Dimensions dimensions;

    private final int mass;
    private final String address;
    private final boolean flip;
    private final String regNumber;
    private final boolean breakable;

    public Load(Dimensions dimensions, int mass, String address, boolean flip, String regNumber, boolean breakable) {
        this.dimensions = dimensions;
        this.mass = mass;
        this.address = address;
        this.flip = flip;
        this.regNumber = regNumber;
        this.breakable = breakable;

    }


    public Load setMass(int mass) {
        return new Load(dimensions, mass,address,flip, regNumber, breakable);
    }

    public Load setAddress(String address) {
        return new Load(dimensions, mass,address,flip, regNumber, breakable);
    }

    public int getMass() {
        return mass;
    }

    public String getAddress() {
        return address;
    }


    public boolean isFlip() {
        return flip;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public boolean isBreakable() {
        return breakable;
    }

    public String toString() {
        return  "Dimensions: "+ dimensions + "\n" +
                "Mass: "  + mass + "\n" +
                "Address: " + address +
                "\n" + "can flip: " + flip + "\n" +
                "reg number: " +  regNumber + "\n" +
                "is breakable: " + breakable;
    }

}





