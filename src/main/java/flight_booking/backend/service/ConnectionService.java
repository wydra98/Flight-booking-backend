package flight_booking.backend.service;

import flight_booking.backend.models.Airport;
import flight_booking.backend.models.Connection;
import flight_booking.backend.models.Ticket;
import flight_booking.backend.models.find_connections.Search;
import flight_booking.backend.repository.AirportRepository;
import flight_booking.backend.repository.ConnectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ConnectionService {

    private final ConnectionRepository connectionRepository;
    private final AirportRepository airportRepository;

    public ConnectionService(ConnectionRepository connectionRepository,
                             AirportRepository airportRepository) {

        this.connectionRepository = connectionRepository;
        this.airportRepository = airportRepository;
    }

    public List<Connection> findConnectionsByAirport(Airport airport) {

        return connectionRepository.findConnectionByAirport(airport);
    }


    public Optional<Connection> findById(Long id) {
        return connectionRepository.findById(id);
    }


    public List<List<Connection>> findConnections(Long srcAirportId, Long dstAirportId) {

        List<Connection> allConnection = connectionRepository.findAll();

        Search search = new Search(srcAirportId, dstAirportId);
        List<List<Connection>> connections = search.findConnections(allConnection);

        return connections;
    }

    public boolean existsById(Long id) {
        return connectionRepository.existsById(id);
    }

    public Connection addNewConnection(Long srcAirportId,
                                       Long dstAirportId) {

        Optional<Airport> srcAirport = airportRepository.findById(srcAirportId);
        Optional<Airport> dstAirport = airportRepository.findById(dstAirportId);

        Connection connection = null;
        if (srcAirport.isPresent() && dstAirport.isPresent()) {
            connection = Connection.builder()
                    .srcAirport(srcAirport.get())
                    .dstAirport(dstAirport.get())
                    .build();
            connectionRepository.save(connection);
        }

        return connection;
    }

    public void save(Connection connection) {
        connectionRepository.save(connection);
    }

    public void deleteConnections(List<Connection> connections) {
        for (Connection connection : connections) {
            connectionRepository.deleteConnectionById(connection.getId());
        }
    }
}
