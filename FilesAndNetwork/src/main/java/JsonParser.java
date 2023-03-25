import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {
    public static void JsonPathandParse(String filePath) {
        String jsonString = readJsonFile(filePath);

        JSONArray jsonArray = new JSONArray(jsonString);
        List<Station> stations = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String name = jsonObject.getString("station_name");
            String depth = jsonObject.getString("depth");
            Station station = new Station(name, depth);
            stations.add(station);
        }

        System.out.println("Parsed JSON data:");
        for (Station station : stations) {
            System.out.println(station);
        }

    }

    private static String readJsonFile(String filePath) {
        String content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    private static class Station {
        private String name;
        private String depth;

        public Station(String name, String depth) {
            this.name = name;
            this.depth = depth;
        }

        @Override
        public String toString() {
            return "name='" + name + '\'' +
                    ", depth='" + depth + '\'';
        }
    }
}
