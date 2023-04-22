import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import core.Station;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;


public class JsonAndCsvParser {

    public ArrayList<Station> stationList = new ArrayList<>();

    private void parseCsvFile(File folder)
    {
        try(BufferedReader br = new BufferedReader(new  FileReader(folder)))
        {

            while(br.readLine() != null)
            {

                String[] stationArray = br.readLine().split(",");

                if(folder.getName().equals("dates-1.csv")) {
                    stationList.add(parseDatesCsv(stationArray));
                } else if(folder.getName().equals("depths-2.csv")) {
                    stationList.add(parseDepths2(stationArray));
                } else if(folder.getName().equals("dates-3.csv")) {
                    stationList.add(parseDatesCsv(stationArray));
                }
            }
        } catch (Exception ex) {
            ex.toString();
        }
    }

    private void parseJsonFile(File folder)
    {
        JSONParser parser = new JSONParser();
        try{
            JSONArray stationsJsonArray =
                    (JSONArray) parser.parse(getJsonFile(folder));

            stationsJsonArray.forEach(stationObject -> {
                JSONObject stationJsonObject = (JSONObject) stationObject;
                if(folder.getName().equals("dates-2.json")) {
                    stationList.add(parseDates2(stationJsonObject));
                } else if(folder.getName().equals("depths-1.json")) {
                    stationList.add(parseDepths1(stationJsonObject));
                } else if(folder.getName().equals("depths-3.json")) {
                    stationList.add(parseDepths3(stationJsonObject));
                }
            });

        } catch (Exception ex) {
            ex.getMessage();
        }

    }

    private Station parseDatesCsv(String[] array)
    {
        return new Station(array[0], array[1], null);
    }

    private Station parseDates2(JSONObject o)
    {
        return new Station(
                (String) o.get("name"),
                (String) o.get("date"),
                (String) o.get("depth"));
    }

    private Station parseDepths1(JSONObject o)
    {
        return new Station(
                (String) o.get("name"),
                (String) o.get("date"),
                String.valueOf(o.get("depth")));
    }

    private Station parseDepths2(String[] array)
    {
        return new Station(array[0], null, array[1]);
    }

    private Station parseDepths3(JSONObject o)
    {
        return new Station(
                (String) o.get("station_name"),
                (String) o.get("date"),
                String.valueOf(o.get("depth_meters")));
    }

    public File recursiv(File folder)
    {
        if(folder.isFile()) {
            if(folder.getName().endsWith("json"))
            {
                parseJsonFile(folder);
            } else if (folder.getName().endsWith("csv"))
            {
                parseCsvFile(folder);
            }
            return folder;
        } else {
            File[] files = folder.listFiles();
            for(File file : files) {
                recursiv(file);
            }
        }
        return null;
    }

    private String getJsonFile(File folder) {

        StringBuilder builder = new StringBuilder();

        try {
            List<String> lines = Files.readAllLines(Paths.get(folder.getPath()));
            lines.forEach(line -> builder.append(line));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }
}