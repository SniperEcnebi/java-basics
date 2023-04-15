package core;



public class Stations {

    private String numLine;
    private String name;
    private String nameLine;
    private String date;
    private int depth;
    private boolean hasConnection;


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



}

