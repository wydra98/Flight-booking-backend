package flight_booking.backend.models.find_connections;


import flight_booking.backend.models.Connection;

import java.util.*;

public class Graph {
    public Map<Long, TreeSet<Long>> map = new HashMap();

    public void addEdge(Connection connection){
        TreeSet<Long> adjacent = map.get(connection.getSrcAirport().getId());
        if(adjacent==null) {
            adjacent = new TreeSet();
            map.put(connection.getSrcAirport().getId(), adjacent);
        }
        adjacent.add(connection.getDstAirport().getId());
    }

    public ArrayList<Long> adjacentNodes(Long id) {
        TreeSet<Long> adjacent = map.get(id);
        if(adjacent==null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(adjacent);
    }
}