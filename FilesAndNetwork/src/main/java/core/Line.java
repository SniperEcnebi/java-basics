package core;
import com.google.gson.annotations.Expose;
import java.util.ArrayList;

public class Line {

    private String name;
    private String number;
    @Expose
    private ArrayList<Station> listStation = new ArrayList<>();

    public Line(String name, String number)
    {
        this.name = name;
        this.number = number;
    }

    public String getName()
    {
        return name;
    }

    public String getNumber()
    {
        return number;
    }

    public ArrayList<Station> getListStation()
    {
        return listStation;
    }

    public void setListStation(ArrayList<Station> listStation)
    {
        this.listStation = listStation;
    }
}

