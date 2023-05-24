
import core.Stations;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import org.jsoup.nodes.Document;

import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class JsonLinesWriter {

    static JSONObject connections = new JSONObject();
    static List<Stations> Stations;

    public static void linesWriter(String path){
        JSONObject json = new JSONObject();

        JSONObject stations = new JSONObject();






        try {
            Document doc = Jsoup.connect("https://skillbox-java.github.io/").maxBodySize(0).get();
            Elements linesList = doc.select("div.js-metro-stations");
            Elements conStations = doc.select(".t-icon-metroln");
            addStations(conStations);
            for (int i = 0; i < linesList.size(); i++) {
                Element line = linesList.get(i);
                String lineName = line.attr("data-line");
                Elements stationsList = line.select("p");
                JSONArray lineStations = new JSONArray();
                for (Element station : stationsList) {
                    lineStations.put(station.text());
                }
                stations.put(lineName, lineStations);
            }



            json.put("stations", stations);
            json.put("connections", Stations);


            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write(json.toString(4));
            fileWriter.flush();
            fileWriter.close();

            System.out.println("JSON file created successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void addStations(Elements elements){
        Stations = new ArrayList<>();
        elements.forEach(st -> Stations.add(new Stations(st.attr("title"), st.attr("data-line"))));

    }

}
