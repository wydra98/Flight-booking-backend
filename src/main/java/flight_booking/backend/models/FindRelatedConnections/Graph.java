package flight_booking.backend.models.FindRelatedConnections;


import flight_booking.backend.models.Airport.Airport;
import flight_booking.backend.models.Connection.Connection;

import java.util.*;

public class Graph {
    private Map<Airport, TreeSet<Airport>> map = new HashMap();

    public void addEdge(Connection connection){
        TreeSet<Airport> adjacent = map.get(connection.getSrcAirport());
        if(adjacent==null) {
            adjacent = new TreeSet();
            map.put(connection.getSrcAirport(), adjacent);
        }
        adjacent.add(connection.getDstAirport());
    }

    public ArrayList<Airport> adjacentNodes(Airport airport) {
        TreeSet<Airport> adjacent = map.get(airport);
        if(adjacent==null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(adjacent);
    }
}