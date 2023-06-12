import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;

public class JsonLinesWriter {

    public static void toJson(String path) {
        linesWriter(path);
    }

    public static void linesWriter(String path) {
        JSONObject json = new JSONObject();
        JSONObject stations = new JSONObject();
        JSONArray connections = new JSONArray();

        try {
            Document doc = Jsoup.connect("https://skillbox-java.github.io/").get();
            Elements lines = doc.select(".js-metro-stations");

            for (Element line : lines) {
                String lineName = line.attr("data-line");
                Elements stationElements = line.select("p");

                JSONArray stationNames = new JSONArray();
                for (Element stationElement : stationElements) {
                    String stationName = stationElement.text();
                    stationNames.put(stationName);

                    Elements connectedStations = stationElement.select("span.t-icon-metroln");
                    for (Element connectedStation : connectedStations) {
                        String connectedStationName = connectedStation.previousElementSibling().text();
                        if (!connectedStationName.isEmpty()) {
                            JSONObject connection = new JSONObject();
                            connection.put("line", lineName);
                            connection.put("station", connectedStationName);
                            connections.put(connection);
                        }
                    }
                }

                stations.put(lineName, stationNames);
            }

            json.put("stations", stations);
            json.put("connections", connections);

            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write(json.toString(4));
            fileWriter.flush();
            fileWriter.close();

            System.out.println("JSON file created successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
