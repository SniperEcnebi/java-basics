
import core.Line;
import core.Stations;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


import java.nio.file.Files;
import java.nio.file.Paths;


public class Main {

    private static final String PATH_TO_CREATE_FILE = "C:/skillbox/java_basics/FilesAndNetwork/FilesAndNetwork/src/main/java";

    private static final String htmlLink = "FilesAndNetwork/data/code.html";
    static List<Line> lines;
    static List<Stations> stations;
    private static final String REGEX = "[0-9][0-9]?.";



    public static void main(String[] args) throws IOException {

       List<File> fileListJson = new ArrayList<>();
       List<File> fileListCsv = new ArrayList<>();
       File rootFile = new File("C:/Users/Amirkhan/Downloads/stations-data (1)/data");

       search(rootFile, fileListJson, fileListCsv);


       fileListJson.forEach(fileJson -> System.out.println(fileJson.getAbsolutePath()));
       fileListCsv.forEach(fileCsv -> System.out.println(fileCsv.getAbsolutePath()));



       String htmlLines = parsefile(htmlLink);
       Document doc = Jsoup.parse(htmlLines);
       Elements elementsL = doc.select("span.js-metro-line");
       Elements elementsS = doc.select("div.js-metro-stations");
       addLines(elementsL);
       addStations(elementsS);
       for(Line line : lines){
           System.out.println(line.getNumber() + " - " + line.getName());
       }
       for (Stations station : stations) {
           System.out.println("Линия: " + station.getLine() + ", станции: " + station.getName());
       }

       JsonParser js = new JsonParser();


       for(File i : fileListJson){
           js.JsonPathandParse(i.getAbsolutePath());
       }

       JsonLinesWriter jsonLinesWriter = new JsonLinesWriter();
       jsonLinesWriter.jlw("https://skillbox-java.github.io/");



       File temp = fileListCsv.get(0);
       fileListCsv.set(0, fileListCsv.get(1));
       fileListCsv.set(1, temp);
       System.out.println("Parsed from Csv:");
       for(File i : fileListCsv){
          CSVParser csv = new CSVParser(i.getAbsolutePath());
          List<String[]> data = csv.readData();
          for (String[] row : data) {
              System.out.println(Arrays.toString(row));

          }

       }

       JsonAndCsvParser jsonAndCsvParser = new JsonAndCsvParser();
       jsonAndCsvParser.recursiv(rootFile);

       HtmlParser htmlParser = new HtmlParser("FilesAndNetwork/data/code.html");
       htmlParser.getStationList();
       htmlParser.getLineList();
       htmlParser.createHasConnection();
       htmlParser.writeToJson();
       

    }

    public static void addStations(Elements elements){
        stations = new ArrayList<>();
        elements.forEach(st -> stations.add(new Stations(st.text().replaceAll(REGEX, ""), st.attr("data-line"))));
    }

    public static void addLines(Elements elements){
        lines = new ArrayList<>();
        elements.forEach(line -> lines.add(new Line(line.attr("data-line"), line.text())));
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


     public static String parsefile(String path) {
        StringBuilder builder = new StringBuilder();

        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.forEach(line -> builder.append(line + "\n"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }




}
