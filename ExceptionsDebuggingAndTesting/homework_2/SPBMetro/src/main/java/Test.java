import core.Line;
import core.Station;
import junit.framework.TestCase;


import java.util.*;


public class Test extends TestCase {

    RouteCalculator calculator;
    StationIndex stationIndex;
    List<Station> route;
    List<Station> stations;
    Station station1;
    Station station2;
    Station station3;
    Station from;
    Station to;

    @Override
    protected void setUp() throws Exception {
        stationIndex = new StationIndex();
        route = new ArrayList<>();
        calculator = new RouteCalculator(stationIndex);
        Line line1 = new Line(1, "first");
        stationIndex.addLine(line1);
        Line line2 = new Line(2, "second");
        stationIndex.addLine(line2);
        Line line3 = new Line(3,"third");
        stationIndex.addLine(line3);
        from = new Station("ecnebi", line1);
        stationIndex.addStation(from);
        route.add(from);
        station1 = new Station("Almaty", line1);
        stationIndex.addStation(station1);
        stations = from.getLine().getStations();
        route.add(station1);
        station2 = new Station("Moscow", line2);
        stationIndex.addStation(station2);
        route.add(station2);
        station3 = new Station("Berlin", line3);
        stationIndex.addStation(station3);
        route.add(station3);
        to = new Station("hehe", line3);
        stationIndex.addStation(to);
        route.add(to);
        stationIndex.addConnection(route);





    }

    public void testCalculateDuration(){
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 12.0;
        assertEquals(expected, actual);
    }


    public void testGetShortestRoute(){
        List<Station> actual = calculator.getShortestRoute(from, to);
        List<Station> expected = route;
        assertEquals(expected, actual);


    }

    public void testIsConnected(){
        boolean actual = false;
        if (stationIndex.getConnectedStations(station1).contains(station2)){
            actual = true;
        }
        
        boolean expected = true;
        assertEquals(expected, actual);
    }

    public void testGetRouteOnTheLine(){
        List<Station> actual = new ArrayList<>();
        if (from.getLine().equals(to.getLine())){
            actual = from.getLine().getStations();
        }
        List<Station> expected = stations;
        assertEquals(expected, actual);

    }

    public void testGetRouteWithOneConnection(){
        List<Station> routee = new ArrayList<>();
        List<Station> actual = new ArrayList<>();
        Line line2 = new Line(2, "second");
        Station to2 = new Station("Prussia", line2);
        if (stationIndex.getConnectedStations(from).contains(to2)){
            routee.add(from);
            routee.add(to2);
            actual.add(from);
            actual.add(to2);
        }
        List<Station> expected = routee;
        assertEquals(routee,actual);


    }

    public void testGetRouteViaConnectedLine(){
       List<Station> station = new ArrayList<>();
       List<Station> expected = new ArrayList<>();
       Set<Station> fromConnected = stationIndex.getConnectedStations(from);
        Set<Station> toConnected = stationIndex.getConnectedStations(to);
        for (Station srcStation : fromConnected) {
            for (Station dstStation : toConnected) {
                if (srcStation.getLine().equals(dstStation.getLine())) {
                    station = srcStation.getLine().getStations();
                    expected = srcStation.getLine().getStations();
                }
            }
        }
        List<Station> actual = station;
        assertEquals(expected, actual);

    }

    public void testGetRouteWithTwoConnections(){

        List<Station> actual = new ArrayList<>();
        if (!stationIndex.getConnectedStations(from).contains(to)){
            actual = null;
        }
        else{
            actual = calculator.getShortestRoute(from,to);

        }
        List<Station> expected = route;
        assertEquals(expected, actual);

    }






    @Override
    protected void tearDown() throws Exception {
    }
}
