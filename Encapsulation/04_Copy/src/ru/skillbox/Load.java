package ru.skillbox;
public class Load {

    private final LoadDetails load;
    private final boolean flip;
    private final String  regNumber;
    private final boolean breakable;

    public Load(LoadDetails load, boolean flip, String regNumber, boolean breakable) {
        this.flip = flip;
        this.regNumber = regNumber;
        this.breakable = breakable;
        this.load = load;
    }


    public LoadDetails getLoad() {
        return load;
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
        return load + "\n" + "can flip: " + flip + "\n" + "reg number: " +  regNumber + "\n" +
                "is breakable: " + breakable;
    }
}


