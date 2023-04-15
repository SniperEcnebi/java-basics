import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;

public class JsonLinesWriter {

    private static final String PATH_TO_CREATE_FILE = "C:/skillbox/java_basics/FilesAndNetwork/FilesAndNetwork/src/main/java";

    public static void jlw(String path) {
        JSONObject json = new JSONObject();

        JSONObject stations = new JSONObject();

        try {
            Document doc = Jsoup.connect(path).maxBodySize(0).get();

            Elements linesList = doc.select("div.js-metro-stations");
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

            FileWriter fileWriter = new FileWriter(PATH_TO_CREATE_FILE + "metro.json");
            fileWriter.write(json.toString(4));
            fileWriter.flush();
            fileWriter.close();

            System.out.println("JSON file created successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}



// private static final String PATH_TO_CREATE_FILE = "C:/skillbox/java_basics/FilesAndNetwork/FilesAndNetwork/src/main/java";