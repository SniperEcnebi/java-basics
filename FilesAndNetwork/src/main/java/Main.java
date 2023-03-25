
import core.Lines;
import core.Stations;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;





public class Main {

    private static final String htmlLink = "FilesAndNetwork/data/code.html";
    static List<Lines> lines;
    static List<Stations> stations;
    private static final String REGEX = "[0-9][0-9]?.";



    public static void main(String[] args) throws IOException {

       List<File> fileListJson = new ArrayList<>();
       List<File> fileListCsv = new ArrayList<>();
       File rootFile = new File("C:/Users/Amirkhan/Downloads/stations-data (1)/data");

       search(rootFile, fileListJson, fileListCsv);


       fileListJson.forEach(fileJson -> System.out.println(fileJson.getAbsolutePath()));
       fileListCsv.forEach(fileCsv -> System.out.println(fileCsv.getAbsolutePath()));



       String htmlLines = Parsing.parsefile(htmlLink);
       Document doc = Jsoup.parse(htmlLines);
       Elements elementsL = doc.select("span.js-metro-line");
       Elements elementsS = doc.select("div.js-metro-stations");
       addLines(elementsL);
       addStations(elementsS);
       for(Lines line : lines){
           System.out.println(line.getNumber() + " - " + line.getName());
       }
       for (Stations station : stations) {
           System.out.println("Линия: " + station.getLine() + ", станции: " + station.getName());
       }

       JsonParser js = new JsonParser();

       for (File i : fileListJson){
           js.JsonPathandParse(String.valueOf(i));

       }


       File temp = fileListCsv.get(0);
       fileListCsv.set(0, fileListCsv.get(1));
       fileListCsv.set(1, temp);
       for(File i : fileListCsv){
          CSVParser csv = new CSVParser(String.valueOf(i));
          List<String[]> data = csv.readData();
          for (String[] row : data) {
              System.out.println(Arrays.toString(row));
          }
       }

    }

    public static void addStations(Elements elements){
        stations = new ArrayList<>();
        elements.forEach(st -> stations.add(new Stations(st.text().replaceAll(REGEX, ""), st.attr("data-line"))));
    }

    public static void addLines(Elements elements){
        lines = new ArrayList<>();
        elements.forEach(line -> lines.add(new Lines(line.attr("data-line"), line.text())));
    }


    private static void search(File rootFile, List<File> fileListJson, List<File> fileListCsv){
        if (rootFile.isDirectory()) {
            File[] allFiles = rootFile.listFiles();
            if (allFiles != null) {
                for (File file : allFiles) {
                    if (file.isDirectory()) {
                        search(file, fileListJson, fileListCsv);
                    }
                    else {
                        if (file.getName().endsWith(".json")) {
                           fileListJson.add(file);
                        }
                        else if(file.getName().endsWith(".csv")){
                            fileListCsv.add(file);
                        }
                    }
                }

            }
        }

    }



}
