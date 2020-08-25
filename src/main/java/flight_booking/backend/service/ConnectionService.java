package flight_booking.backend.service;

import flight_booking.backend.models.Airports.Airport;
import flight_booking.backend.models.Connections.Connection;
import flight_booking.backend.models.Connections.ConnectionRepository;
import flight_booking.backend.models.FindRelatedConnections.Search;
import org.springframework.stereotype.Service;
import flight_booking.backend.models.Airports.AirportRepository;

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


    public Connection addNewConnection(Long srcAirportId,
                                       Long dstAirportId) {

        Optional<Airport> srcAirport1 = airportRepository.findById(srcAirportId);
        Optional<Airport> dstAirport1 = airportRepository.findById(dstAirportId);

        Connection connection = Connection.builder()
                .srcAirport(srcAirport1.get())
                .dstAirport(dstAirport1.get())
                .build();
        connectionRepository.save(connection);
        return connection;
    }

    public void deleteConnectionWithAirlineId(Long id) {
        connectionRepository.deleteAllConnectionWithAirlineId(id);
    }

    public void deleteConnectionWithAirportId(Long id) {
        connectionRepository.deleteAllConnectionWithAirportId(id);
    }

    public List<Connection> findAll() {
        return connectionRepository.findAll();
    }

    public boolean existsById(Long id) {
        return connectionRepository.existsById(id);
    }

    public void deleteConnection(Long id) {
        connectionRepository.deleteById(id);
    }

    public Optional<Connection> findById(Long id) {
        return connectionRepository.findById(id);
    }

    public void save(Connection connection) {
        connectionRepository.save(connection);
    }

    public List<List<Connection>> findConnections(Long srcAirportId, Long dstAirportId, int maxChange) {

       List<Connection> allConnection = connectionRepository.findAll();

       Search search = new Search(srcAirportId,dstAirportId);
       List<List<Connection>> connections = search.findConnections(allConnection, maxChange);

       return connections;
    }

}
