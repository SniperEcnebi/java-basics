package core;

public class Stations {

    private String numLine;
    private String name;

    public Stations(String name, String numLine)
    {
        this.name = name;
        this.numLine = numLine;
    }

    public String getLine()
    {
        return numLine;
    }

    public String getName()
    {
        return name;
    }

    public String toString()
    {
        return name;
    }




}
