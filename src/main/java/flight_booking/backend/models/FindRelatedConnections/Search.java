package flight_booking.backend.models.FindRelatedConnections;

import flight_booking.backend.models.Airport.Airport;
import flight_booking.backend.models.Connection.Connection;

import java.util.ArrayList;
import java.util.List;

public class Search {

    public static final int MAX_CONNECTION = 2;
    private Long START;
    private Long END;
    private List<List<Connection>> allConnection = new ArrayList();
    List<Connection> baseConnection;
    private int depth = 1;

    public Search(Long START, Long END) {
        this.START = START;
        this.END = END;
    }

    public List<List<Connection>> findConnections(List<Connection> baseConnection) {
        Graph graph = new Graph();
        this.baseConnection = baseConnection;
        for (Connection connection : baseConnection) {
            graph.addEdge(connection);
        }

        ArrayList<Long> visited = new ArrayList();
        visited.add(START);
        depthFirst(graph, visited);
        System.out.println(allConnection.size());
        for (List<Connection> connections : allConnection) {
            for (Connection connection : connections) {
                System.out.println("from: " + connection.getId() + " to: " + connection.getId());
            }
            System.out.println();
        }
        return allConnection;
    }

    private void depthFirst(Graph graph, ArrayList<Long> visited) {
        List<Long> nodes = graph.adjacentNodes(visited.get(visited.size() - 1));
        for (Long visit: visited
        ) {
            System.out.println(visit + " ");

        }
        for (Long node : nodes) {
            if (visited.contains(node)) {
                continue;
            }
            if (node.equals(END)) {
                visited.add(node);

                allConnection.add(buildFlight(visited));
                visited.remove(visited.size() - 1);
                break;
            }
        }
        for (Long node : nodes) {
            if (visited.contains(node) || node.equals(END)) {
                continue;
            }
            depth++;
            visited.add(node);
            if (depth <= MAX_CONNECTION) {
                depthFirst(graph, visited);
            }
            depth--;
            visited.remove(visited.size() - 1);
        }
    }

    private List<Connection> buildFlight(ArrayList<Long> visited) {
        List<Connection> arraysOfConnections = new ArrayList();
        List<Long> pairOfAirports = new ArrayList<>();
        for (int i = 0; i < visited.size(); i++) {
            if (i == 0) {
                pairOfAirports.add(visited.get(i));
            } else if (i < visited.size() - 1) {
                pairOfAirports.add(visited.get(i));
                Connection connection = findConnection(pairOfAirports.get(0), pairOfAirports.get(1));
                arraysOfConnections.add(connection);
                pairOfAirports.clear();
                pairOfAirports.add(visited.get(i));
            } else {
                pairOfAirports.add(visited.get(i));
                Connection connection = findConnection(pairOfAirports.get(0), pairOfAirports.get(1));
                arraysOfConnections.add(connection);
                pairOfAirports.clear();
            }
        }

        return arraysOfConnections;
    }

    private Connection findConnection(Long srcAirportId, Long dstAirportId){
        for(Connection connection: baseConnection){
            if(connection.equals(srcAirportId) && connection.equals(dstAirportId)){
                return connection;
            }
        }
        return null;
    }
}
