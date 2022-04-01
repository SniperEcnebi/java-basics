package ru.skillbox;
public class Dimension {

    public final dimenDetails details;


    public Dimension(dimenDetails details) {
        this.details = details;
    }

    public dimenDetails getDetails() {
        return details;
    }

    public String toString(){
        return "\n" + details;
    }


}

