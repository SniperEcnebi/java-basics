import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSON {

    public static void main(String[] args) {
        String PATH_TO_CREATE_FILE = "C:/skillbox/java_basics/FilesAndNetwork/FilesAndNetwork/src/main/java";
        String url = "https://skillbox-java.github.io/";
        String fileName = PATH_TO_CREATE_FILE + "stations.json";
        String jsonFilePath1 = "C:/Users/Amirkhan/Downloads/stations-data (1)/data/2/4/depths-1.json";
        String jsonFilePath2 = "C:/Users/Amirkhan/Downloads/stations-data (1)/data/7/1/depths-2.json";
        String jsonFilePath3 = "C:/Users/Amirkhan/Downloads/stations-data (1)/data/4/6/depths-3.json";
        String csvFilePath1 = "C:/Users/Amirkhan/Downloads/stations-data (1)/data/4/6/dates-1.csv";
        String csvFilePath2 = "C:/Users/Amirkhan/Downloads/stations-data (1)/data/0/5/dates-2.csv";
        String csvFilePath3 = "C:/Users/Amirkhan/Downloads/stations-data (1)/data/9/6/dates-3.csv";



        collectStationData(url, fileName, new String[]{jsonFilePath1, jsonFilePath2, jsonFilePath3}, new String[]{csvFilePath1, csvFilePath2, csvFilePath3});
    }

    public static void collectStationData(String url, String fileName, String[] jsonFilePaths, String[] csvFilePaths) {
        JSONObject jsonObject = new JSONObject();
        JSONArray stationsArray = new JSONArray();

        try {
            Document document = Jsoup.connect(url).get();
            Elements stationElements = document.select("div.js-metro-stations p");

            Map<String, String> stationDepthMap = readStationDepths(jsonFilePaths);
            Map<String, String> stationDateMap = readStationDates(csvFilePaths);

            for (Element stationElement : stationElements) {
                String stationName = stationElement.text().substring(3).trim();
                String lineNum = stationElement.parent().attr("data-line");
                String depth = stationDepthMap.get(stationName);
                String date = stationDateMap.get(stationName);
                boolean hasConnection = !stationElement.select(".t-icon-metroln").isEmpty();

                JSONObject stationObject = new JSONObject();
                stationObject.put("name", stationName);
                stationObject.put("line", lineNum);
                stationObject.put("depth", depth != null ? depth : "");
                stationObject.put("date", date != null ? date : "");
                stationObject.put("hasConnection", hasConnection);

                stationsArray.put(stationObject);
            }

            jsonObject.put("stations", stationsArray);

            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(jsonObject.toString(4));
            fileWriter.flush();
            fileWriter.close();

            System.out.println("Data collected and saved to " + fileName);

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, String> readStationDepths(String[] jsonFilePaths) {
        Map<String, String> stationDepthMap = new HashMap<>();

        for (String jsonFilePath : jsonFilePaths) {
            try {
                JSONTokener tokener = new JSONTokener(new FileInputStream(jsonFilePath));
                JSONArray jsonArray = new JSONArray(tokener);

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String stationName = jsonObject.getString("station_name");
                    String depth = jsonObject.getString("depth");
                    stationDepthMap.put(stationName, depth);
                }

            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
        }

        return stationDepthMap;
    }

    private static Map<String, String> readStationDates(String[] csvFilePaths) {
        Map<String, String> stationDateMap = new HashMap<>();

        for (String csvFilePath : csvFilePaths) {
            try {
                CSVReader csvReader = new CSVReader(new FileReader(csvFilePath));
                List<String[]> csvData = csvReader.readAll();

                for (int i = 1; i < csvData.size(); i++) {
                    String[] row = csvData.get(i);
                    String stationName = row[0];
                    String date = row[1];
                    stationDateMap.put(stationName, date);
                }

                csvReader.close();

            } catch (IOException | CsvException e) {
                e.printStackTrace();
            }
        }

        return stationDateMap;
    }
}