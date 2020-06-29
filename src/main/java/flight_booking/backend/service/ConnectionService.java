package flight_booking.backend.service;

import flight_booking.backend.models.Connection.Connection;
import flight_booking.backend.models.Connection.ConnectionRepository;
import org.springframework.stereotype.Service;
import flight_booking.backend.models.Airport.AirportRepository;

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


//    public Connection addNewConnection(ConnectionDto connectionDto) {
//
//        Optional<Airport> srcAirport1 = airportRepository.findById(connectionDto.getSrcAirportDto().getId());
//        Optional<Airport> dstAirport1 = airportRepository.findById(connectionDto.getDstAirportDto().getId());
//
//        Connection connection = Connection.builder()
//                .srcAirport(srcAirport1.get())
//                .dstAirport(dstAirport1.get())
//                .times(Times.builder()
//                        .departureDate(LocalDate.parse(connectionDto.getDepartureDate()))
//                        .arrivalDate(LocalDate.parse(connectionDto.getArrivalDate()))
//                        .arrivalTime(LocalTime.parse(connectionDto.getArrivalTime()))
//                        .departureTime(LocalTime.parse(connectionDto.getDepartureTime()))
//                        .build())
//                .build();
//        connectionRepository.save(connection);
//        return connection;
//    }

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

    public Optional<Connection> findById(Long id){
       return connectionRepository.findById(id);
    }

    public void save(Connection connection){
        connectionRepository.save(connection);
    }


}
