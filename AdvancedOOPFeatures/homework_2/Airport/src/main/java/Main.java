import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.
        List<Flight> flightList = airport.getTerminals().stream().flatMap(f -> f.getFlights().stream())
                .collect(Collectors.toList());

        return flightList.stream()
                .filter(r -> r.getType().equals(Flight.Type.DEPARTURE))
                .filter(a -> a.getDate().toInstant().isBefore(Instant.now().plusSeconds(7200)))
                .filter(a -> a.getDate().toInstant().isAfter(Instant.now())).collect(Collectors.toList());
    }

}