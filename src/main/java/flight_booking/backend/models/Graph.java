package flight_booking.backend.models;


import java.util.*;

public class Graph {
    private Map<String, TreeSet<String>> map = new HashMap();

    public void addEdge(String node1, String node2){//, LocalDate departureDate, LocalTime departureTime,LocalDate arrivalDate, LocalTime arrivalTime) {
        TreeSet<String> adjacent = map.get(node1);
        if(adjacent==null) {
            adjacent = new TreeSet();
            map.put(node1, adjacent);
        }
        adjacent.add(node2);
    }

    public ArrayList<String> adjacentNodes(String last) {
        TreeSet<String> adjacent = map.get(last);
        if(adjacent==null) {
            return new ArrayList<>();
        }
        return new ArrayList<String>(adjacent);
    }
}