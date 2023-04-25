import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import core.Line;
import core.Station;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class HtmlParser {

    private String path;
    private final String PATH_TO_CREATE_FILE = "C:/skillbox/java_basics/FilesAndNetwork/FilesAndNetwork/src/main/java";;
    final static String TAG_SELECT_LINE = "span.js-metro-line";
    final static String TAG_SELECT_STATION = "p.single-station";

    private ArrayList<Station> stationList = new ArrayList<>();
    private ArrayList<Line> lineList = new ArrayList<>();
    public ArrayList<String> listConnection = new ArrayList<>();

    public ArrayList getStationList()
    {
        staffingStation();
        return stationList;
    }
    public ArrayList getLineList()
    {
        return lineList;
    }
    public HtmlParser(String path)
    {
        this.path = path;
    }

    private void staffingStation()
    {
        lineList.forEach(line ->
            stationList.addAll(line.getListStation()));
    }
    public void createHasConnection()
    {
        Document doc = Jsoup.parse(path);
        Elements connect = doc.select(".t-icon-metroln[title]");
        connect.forEach(con ->
        listConnection.add(con.attr("title")));
    }


    private void linesAndStationInJson()
    {
        Document doc = Jsoup.parse(path);
        lineList.forEach(line -> {
            Elements stationFromLine = doc.getElementsByAttributeValue("data-line", line.getNumber());
            stationFromLine.select(TAG_SELECT_STATION).forEach(station -> {
                stationList.add(new Station(station.text().
                replaceAll("[0-9]*\\. ", ""), "",""));

                stationList.forEach(stationSet ->
                stationSet.setLine(line.getName()));

            });
            line.setListStation(stationList);
        });
    }




    private void createLines()
    {
        Document doc = Jsoup.parse(path);
        Elements lines = doc.select(TAG_SELECT_LINE);

        lines.forEach(element ->
                lineList.add(new Line(element.text(),
                        element.attr("data-line"))));
    }


    public void writeToJson()
    {
        Gson gson= new GsonBuilder().setPrettyPrinting().create();
        Gson gsonNotStationList= new GsonBuilder().
                excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        try(FileWriter writer =
                new FileWriter(PATH_TO_CREATE_FILE + "LineAndStation.json"))
        {
            createLines();
            gsonNotStationList.toJson(lineList, writer);

            linesAndStationInJson();
            gson.toJson(lineList, writer);

        }catch (Exception ex) {
            ex.getStackTrace();
        }
    }
}
